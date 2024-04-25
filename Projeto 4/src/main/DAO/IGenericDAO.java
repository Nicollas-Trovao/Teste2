package main.DAO;

import java.util.Collection;
import main.Domain.Persistente;

import java.io.Serializable;

public interface IGenericDAO  <T extends Persistente, E extends Serializable>  {

    public T cadastrar(T entity);

    public void excluir (T entity);

    public T alterar (T entity);

    public T consultar (E id);

    public Collection<T> buscarTodos();
}
