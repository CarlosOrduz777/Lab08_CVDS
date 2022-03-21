package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;

import java.util.Date;
import java.util.List;

public interface ClienteDAO {
    public void registrarCliente(Cliente c) throws PersistenceException;

    public Cliente consultarCliente(int id) throws PersistenceException;

    public List<Cliente> consultarClientes() throws PersistenceException;

    public void agregarItemRentadoACliente(int id, int idit, Date fechainicio, Date fechafin) throws PersistenceException;

    public void vetarCliente(long docu, int estado) throws PersistenceException;

    public List<Item> consultarItemsRentadosCliente(int docu) throws PersistenceException;
}
