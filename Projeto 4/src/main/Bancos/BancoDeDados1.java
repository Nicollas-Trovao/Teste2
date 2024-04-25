package main.Bancos;

import java.io.Serializable;

import main.DAO.GenericDAO;
import main.Domain.Persistente;

public abstract class BancoDeDados1 <T extends Persistente, E extends Serializable>
extends GenericDAO<T,E> {

public BancoDeDados1(Class<T> persistenteClass) {
    super(persistenteClass, "Postgres_1");
}

}