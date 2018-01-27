package com.tesji.dao.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tesji.dao.ClienteDAO;
import com.tesji.pojo.Cliente;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class ClienteDaoTest {
	
	@Autowired
	@Qualifier("clienteDao")
	ClienteDAO clienteDao;
	
	
	@Test
	public void testAddCliente(){
		Cliente clienteTest = new Cliente();
		clienteTest.setNombre("Zoe");
		clienteTest.setApellido_paterno("Castillo");
		clienteTest.setApellido_materno("Miranda");
		clienteTest.setEmail("email@Test");
		assertTrue(clienteDao.save(clienteTest));
	}
	
	/*
	@Test
	public void testFindAll(){
		List<Cliente> clientes = clienteDao.findAll();
		assertTrue(clientes.size() > 0);
	}
	*/

}
