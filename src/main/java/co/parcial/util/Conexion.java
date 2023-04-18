package co.parcial.util;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public abstract class Conexion<T> {
	private Class<T> c;

	private static final String PU = "previo1152085"; //Persistence Unit
	protected static EntityManager em;
	private static EntityManagerFactory emf;
	

	public Conexion() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory(PU);
		}
	}

	protected EntityManager getEntityManager() {
		if (em == null) {
			em = emf.createEntityManager();
		}

		return em;
	}

	public Conexion(Class<T> c) {
		em = this.getEm();
		this.c = c;
	}

	public void setC(Class<T> c) {
		this.c = c;
	}

	public static EntityManager getEm() {
		if (em == null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Parcial1");
			em = emf.createEntityManager();
		}
		return em;
	}

	public <E> T find(E id) {
		T object = (T) em.find(c, id);
		return object;
	}

	public List<T> list() {
		TypedQuery<T> consulta = em.createNamedQuery(c.getSimpleName() + ".findAll", c);
		List<T> lista = (List<T>) consulta.getResultList();
		return lista;
	}

	public void insert(T o) {
		try {
			em.getTransaction().begin();
			em.persist(o);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// em.close();
		}

	}

	public void update(T o) {
		try {
			em.getTransaction().begin();
			em.merge(o);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// em.close();
		}

	}

	public void delete(T o) {
		try {
			em.getTransaction().begin();
			em.remove(o);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// em.close();
		}

	}
}
