package com.tesji.main;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.tesji.dao.ClienteDAO;
import com.tesji.pojo.Cliente;

public class MainApp {

	private static Logger LOG = Logger.getLogger(MainApp.class.getName());

	public static void main(String... tesji) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
		ClienteDAO clienteDao = (ClienteDAO) applicationContext.getBean("clienteDao");

		Cliente cliente = new Cliente();
		cliente.setNombre("Nuevo");
		cliente.setApellido_paterno("Apellido");

	
		try {
			
			/*
			if (clienteDao.save(cliente)) {
				LOG.info("::: Se inserto de forma exitosa ::::");
			} else {
				LOG.info("::: No se inserto ::::");
			}
			*/

			
			/*
			List<Cliente> clientes = clienteDao.findAll();
			for (Cliente cliente2 : clientes) {
				LOG.info("====== " + cliente2);
			}
			*/
			
			/*
			LOG.info("Id 1) " + clienteDao.findById(1));
			LOG.info("Id 2) " + clienteDao.findById(4));
			
			LOG.info("Id Nombres) " + clienteDao.findByNombre("S")); 
            */
			
			Cliente clienteMod = new Cliente();
			clienteMod.setId_cliente(2);
			clienteMod.setNombre("Nuevo Nombre");
			clienteMod.setApellido_paterno("Nuevo Apellido");
			
			Cliente client = clienteDao.findById(1);
			LOG.info("::: CLiente id 1" + client );
			
			client.setNombre("Nuevo Nombre");
			
			if(clienteDao.update(client)){
				LOG.info("Actualizado correctamente :::");
			}else{
				LOG.info(":: NO ACTUALIZO ::::");
			}
			
			if(clienteDao.delete(client.getId_cliente())){
				LOG.info("::: Se elimino correctamente :::");
			}else{
				LOG.info("::: No se elimino :::");
			}
			
			
		} catch (CannotGetJdbcConnectionException ex) {
			ex.printStackTrace();
		} catch (DataAccessException ex) {
			ex.printStackTrace();
		}

	}

}
