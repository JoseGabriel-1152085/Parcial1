package co.parcial.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "documento")
	private String documento;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "email")
	private String email;

	@Column(name = "genero")
	private String genero;

	@Column(name = "fechanacimiento")
	private LocalDate fechaNacimiento;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "peso")
	private double peso;

	@Column(name = "estatura")
	private double estatura;

	public Paciente(Long id, String documento, String nombre, String apellido, String email, String genero,
			LocalDate fechaNacimiento, String telefono, String direccion, double peso, double estatura) {
		super();
		this.id = id;
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
		this.peso = peso;
		this.estatura = estatura;
	}

	public Paciente() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	// Método para calcular el índice de masa corporal
	public Double calcularIMC(Paciente pac) {
		
		return pac.getPeso() / (pac.getEstatura() * pac.getEstatura());
	}

	// Método para obtener el estado del índice de masa corporal
	public String estadoIMC(Paciente pac) {
		Double imc = calcularIMC(pac);
		if (imc < 18.5) {
			return "BAJO PESO";
		} else if (imc >= 18.5 && imc < 25) {
			return "NORMAL";
		} else {
			return "SOBREPESO";
		}
	}

}
