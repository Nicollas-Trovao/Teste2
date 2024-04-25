package main.DAO;

import main.Domain.Cliente;
import main.Bancos.BancoDeDados1;

public class ClienteDAO1 extends BancoDeDados1<Cliente, Long> implements IClienteDAO<Cliente> {

      public ClienteDAO1(){
        super(Cliente.class);
      }

}
