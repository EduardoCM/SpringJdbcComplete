package com.tesji.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ClienteRowMapper implements RowMapper<Cliente> {

	public Cliente mapRow(ResultSet rs, int arg1) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setId_cliente(rs.getInt("id_cliente"));
		cliente.setNombre(rs.getString("nombre"));
		cliente.setApellido_paterno(rs.getString("apellido_paterno"));
		return cliente;
	}
}
