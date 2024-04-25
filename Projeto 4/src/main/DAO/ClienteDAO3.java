package main.DAO;

import main.Bancos.BancoDeDados3;
import main.Domain.Cliente;

public class ClienteDAO3 extends BancoDeDados3<Cliente, Long> implements IClienteDAO<Cliente> {

	public ClienteDAO3() {
		super(Cliente.class);
	} 
}
