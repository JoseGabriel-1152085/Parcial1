package co.parcial.dao;

import java.sql.SQLException;
import java.util.List;

import co.parcial.entities.Paciente;

public interface Paciente_DAO {

	public Paciente select(int id);

	public List<Paciente> selectAll();

	public void insert(Paciente paciente) throws SQLException;

	public void update(Paciente paciente) throws SQLException;

	public void delete(long id) throws SQLException;
	
	public List<Paciente> listar();
	
	public Paciente buscarPorId(long id);

}
