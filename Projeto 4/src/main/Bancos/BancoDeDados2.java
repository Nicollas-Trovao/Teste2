package main.Bancos;

import java.io.Serializable;

import main.DAO.GenericDAO;
import main.Domain.Persistente;

public abstract class BancoDeDados2 <T extends Persistente, E extends Serializable>
extends GenericDAO<T,E> {

public BancoDeDados2(Class<T> persistenteClass) {
    super(persistenteClass, "Postgres_2");
}

}