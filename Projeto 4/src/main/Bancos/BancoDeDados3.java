package main.Bancos;

import java.io.Serializable;

import main.DAO.GenericDAO;
import main.Domain.Persistente;

public abstract class BancoDeDados3 <T extends Persistente, E extends Serializable>
extends GenericDAO<T,E> {

public BancoDeDados3(Class<T> persistenteClass) {
    super(persistenteClass, "Postgres3_");
}

}