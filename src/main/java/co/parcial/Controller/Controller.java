package co.parcial.Controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.parcial.dao.*;
import co.parcial.entities.Paciente;

@WebServlet("/paciente")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory emf;
	private EntityManager em;
	private Paciente_DAO pacienteDao;
	Paciente p = new Paciente();
	// pacienteDao pacienteDao = new pacienteDao();

	public Controller() {
		super();
		emf = Persistence.createEntityManagerFactory("ParcialWeb");
		em = emf.createEntityManager();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		try {
			switch (action) {
			case "/listar":
				listar(request, response);
				break;
			case "/ver":
				ver(request, response);
				break;
			case "/nuevo":
				nuevo(request, response);
				break;
			case "/editar":
				editar(request, response);
				break;
			case "/eliminar":
				eliminar(request, response);
				break;
			default:
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				break;
			}
		} catch (SQLException e) {
			throw new ServletException();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (jakarta.servlet.ServletException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();
		if (action == null || action.isEmpty()) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		} else if (action.equals("/crear")) {
			crear(request, response);
		} else if (action.equals("/actualizar")) {
			actualizar(request, response);
		} else {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Paciente> listPaciente = pacienteDao.selectAll();
		List<Paciente> pacientes = em.createQuery("FROM Paciente", Paciente.class).getResultList();

		for (Paciente paciente : pacientes) {
			p.calcularIMC(paciente);
		}
		request.setAttribute("pacientes", pacientes);
		request.getRequestDispatcher("/WEB-INF/views/paciente/listar.jsp").forward(request, response);
	}

	private void ver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		if (idStr == null) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		try {
			int id = Integer.parseInt(idStr);
			Paciente paciente = em.find(Paciente.class, id);
			if (paciente != null) {
				p.calcularIMC(paciente);
				request.setAttribute("paciente", paciente);
				request.getRequestDispatcher("/WEB-INF/views/paciente/ver.jsp").forward(request, response);
			} else {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, jakarta.servlet.ServletException {
		//request.getRequestDispatcher("/WEB-INF/views/paciente/nuevo.jsp").forward(request, response);
		javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("nuevo.jsp");
		dispatcher.forward(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		if (idStr == null) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		try {
			long id = new Long(idStr);
			Paciente paciente = pacienteDao.buscarPorId(id);
			if (paciente != null) {
				request.setAttribute("paciente", paciente);
				request.getRequestDispatcher("editar.jsp").forward(request, response);
			} else {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

	private void crear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idStr = request.getParameter("id");
		Long id = new Long(idStr);
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");
		String fechaNacimientoStr = request.getParameter("fechanacimiento");
		LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		String pesoStr = request.getParameter("peso");
		Double peso = new Double(pesoStr);
		String estaturaStr = request.getParameter("estatura");
		Double estatura = new Double(estaturaStr);

		Paciente paciente = new Paciente(id, documento, nombre, apellido, email, genero, fechaNacimiento, telefono,
				direccion, peso, estatura);
		try {
			pacienteDao.insert(paciente);
			response.sendRedirect(request.getContextPath() + "/listar");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al crear el paciente.");
		}
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		if (idStr == null) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		try {
			Long id = Long.parseLong(idStr);
			Paciente paciente = pacienteDao.buscarPorId(id);
			if (paciente == null) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				return;
			}

			String documento = request.getParameter("documento");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String email = request.getParameter("email");
			String genero = request.getParameter("genero");
			String fechaNacimientoStr = request.getParameter("fechanacimiento");
			LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);
			String telefono = request.getParameter("telefono");
			String direccion = request.getParameter("direccion");
			String pesoStr = request.getParameter("peso");
			Double peso = new Double(pesoStr);
			String estaturaStr = request.getParameter("estatura");
			Double estatura = new Double(estaturaStr);

			paciente.setDocumento(documento);
			paciente.setNombre(nombre);
			paciente.setApellido(apellido);
			paciente.setEmail(email);
			paciente.setGenero(genero);
			paciente.setFechaNacimiento(fechaNacimiento);
			paciente.setTelefono(telefono);
			paciente.setDireccion(direccion);
			paciente.setPeso(peso);
			paciente.setEstatura(estatura);

			pacienteDao.update(paciente);
			response.sendRedirect(request.getContextPath() + "/listar");
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al actualizar el paciente.");
		}
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String idStr = request.getParameter("id");
		if (idStr == null) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		try {
			Long id = Long.parseLong(idStr);
			pacienteDao.delete(id);
			response.sendRedirect(request.getContextPath() + "/listar");
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

}
