package main.DAO;

import main.Bancos.BancoDeDados2;
import main.Domain.Cliente;

public class ClienteDAO2 extends BancoDeDados2<Cliente, Long> implements IClienteDAO<Cliente> {

	public ClienteDAO2() {
		super(Cliente.class);
	}

}
