package com.tesji.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.tesji.pojo.ClienteRowMapper;
import com.tesji.pojo.Cliente;

@Component("clienteDao")
public class ClienteDAOImpl implements ClienteDAO {

	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public boolean save(Cliente cliente) {
		String sql = "INSERT INTO Cliente (nombre, apellido_paterno) VALUES (:nombre, :apellido_paterno)";
		/*MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("nombre", admin.getNombre());
		paramMap.addValue("apellido_paterno", admin.getApellidoPaterno());
		*/
		BeanPropertySqlParameterSource paramMap = new BeanPropertySqlParameterSource(cliente);
		return jdbcTemplate.update(sql, paramMap) == 1;
	}

	public List<Cliente> findAll() {
		return jdbcTemplate.query("SELECT * FROM Cliente", new RowMapper<Cliente>() {

			public Cliente mapRow(ResultSet rs, int arg1) throws SQLException {
				Cliente cliente = new Cliente();
				cliente.setId_cliente(rs.getInt("id_cliente"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellido_paterno(rs.getString("apellido_paterno"));
				return cliente;
			}

		});
	}

	public Cliente findById(int id) {
		return jdbcTemplate.queryForObject("select * from Cliente where id_cliente=:id_cliente",
				new MapSqlParameterSource("id_cliente", id), new ClienteRowMapper());
	}

	public List<Cliente> findByNombre(String nombre) {
		return jdbcTemplate.query("SELECT * FROM Cliente WHERE nombre like :nombre ", 
				 new MapSqlParameterSource("nombre", "%" + nombre + "%"), new ClienteRowMapper());
	}

	public boolean update(Cliente cliente) {
		return jdbcTemplate.update("UPDATE Cliente set nombre = :nombre WHERE id_cliente = :id_cliente ", 
				new BeanPropertySqlParameterSource(cliente)) == 1;	
	}

	public boolean delete(int idCliente) {
		return jdbcTemplate.update("DELETE FROM Cliente WHERE id_cliente = :id_cliente", 
				new MapSqlParameterSource("id_cliente", idCliente)) == 1;
		
	}

}
