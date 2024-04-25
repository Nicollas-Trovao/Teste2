package Teste;

import java.util.Random;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.postgresql.shaded.com.ongres.scram.common.bouncycastle.base64.EncoderException;
import static org.junit.Assert.assertTrue;

import main.DAO.ClienteDAO1;
import main.DAO.IClienteDAO;
import main.Domain.Cliente;

public class ClienteDAOTest {
	
	private IClienteDAO<Cliente> clienteDao;
	
	private Random rd;
	
	public void ClienteDaoTest() {
		this.clienteDao = new ClienteDAO1();
		rd = new Random();
	}
	
	@After
	public void end() {
		Collection<Cliente> list = clienteDao.buscarTodos();
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli);
			} catch (EncoderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	@Test
	public void pesquisarCliente() {
		Cliente cliente = criarCliente();
		clienteDao.cadastrar(cliente);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
		Assert.assertNotNull(clienteConsultado);
		
	}

	@Test
	public void salvarCliente() {
		Cliente cliente = criarCliente();
		Cliente retorno = clienteDao.cadastrar(cliente);
		Assert.assertNotNull(retorno);
		
		Cliente clienteConsultado = clienteDao.consultar(retorno.getId());
		Assert.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente);
		
		Cliente clienteConsultado1 = clienteDao.consultar(retorno.getId());
		Assert.assertNull(clienteConsultado1);
	}
	
	@Test
	public void excluirCliente()  {
		Cliente cliente = criarCliente();
		Cliente retorno = clienteDao.cadastrar(cliente);
		Assert.assertNotNull(retorno);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
		Assert.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente);
		clienteConsultado = clienteDao.consultar(cliente.getId());
		Assert.assertNull(clienteConsultado);
	}
	
	@Test
	public void alterarCliente() {
		Cliente cliente = criarCliente();
		Cliente retorno = clienteDao.cadastrar(cliente);
		Assert.assertNotNull(retorno);
		
		Cliente clienteConsultado = clienteDao.consultar(cliente.getId());
		Assert.assertNotNull(clienteConsultado);
		
		clienteConsultado.setNome("Nicollas Trovão");
		clienteDao.alterar(clienteConsultado);
		
		Cliente clienteAlterado = clienteDao.consultar(clienteConsultado.getId());
		Assert.assertNotNull(clienteAlterado);
		Assert.assertEquals("Nicollas Trovão", clienteAlterado.getNome());
		
		clienteDao.excluir(cliente);
		clienteConsultado = clienteDao.consultar(clienteAlterado.getId());
		Assert.assertNull(clienteConsultado);
	}
	
	@Test
	public void buscarTodos() {
		Cliente cliente = criarCliente();
		Cliente retorno = clienteDao.cadastrar(cliente);
		Assert.assertNotNull(retorno);
		
		Cliente cliente1 = criarCliente();
		Cliente retorno1 = clienteDao.cadastrar(cliente1);
		Assert.assertNotNull(retorno1);
		
		Collection<Cliente> list = clienteDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
		
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli);
			} catch (EncoderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Collection<Cliente> list1 = clienteDao.buscarTodos();
		assertTrue(list1 != null);
		assertTrue(list1.size() == 0);
	}
	
	private Cliente criarCliente() {
		Cliente cliente = new Cliente();
		cliente.setCpf(rd.nextLong());
		cliente.setNome("RNicollas");
		cliente.setCidade("São Gonçalo");
		cliente.setNumero(913873765);;
		return cliente;
	}

}