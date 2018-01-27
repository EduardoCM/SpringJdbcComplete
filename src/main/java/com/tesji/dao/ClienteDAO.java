package com.tesji.dao;

import java.util.List;

import com.tesji.pojo.Cliente;

public interface ClienteDAO {
	
	public boolean save(Cliente admin);
	public List<Cliente> findAll();
	public Cliente findById(int id);
	public List<Cliente> findByNombre(String nombre);
	public boolean update(Cliente cliente);
	public boolean delete(int idCliente);

}
