package co.parcial.dao;

import java.sql.SQLException;
import java.util.List;

import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import co.parcial.entities.Paciente;
import co.parcial.util.Conexion;

public class pacienteDao extends Conexion implements Paciente_DAO {

	@Override
	public Paciente select(int id) {
		// TODO Auto-generated method stub
		return em.find(Paciente.class, id);
	}

	@Override
	public List<Paciente> selectAll() {
		// TODO Auto-generated method stub
		String hql = "SELECT p FROM Paciente p";
		em = getEntityManager();
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public void insert(Paciente paciente) throws SQLException {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			;
			em.persist(paciente);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace(System.out);
			em.getTransaction().rollback();

		}
	}

	@Override
	public void update(Paciente paciente) throws SQLException {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			;
			em.merge(paciente);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace(System.out);
			em.getTransaction().rollback();
		}

	}

	@Override
	public void delete(long id) throws SQLException {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			;
			em.remove(em.merge(em.find(Paciente.class, id)));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace(System.out);
			em.getTransaction().rollback();

		}
	}

	@Override
	public List<Paciente> listar() {
		TypedQuery<Paciente> query = em.createQuery("SELECT p FROM Paciente p", Paciente.class);
		return query.getResultList();
	}

	@Override
	public Paciente buscarPorId(long id) {
		return em.find(Paciente.class, id);
	}

}
