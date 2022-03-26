package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;

import java.util.Date;
import java.util.List;

public interface ClienteDAO {
    public void registrarCliente(Cliente c) throws PersistenceException;

    public Cliente consultarCliente(long id) throws PersistenceException;

    public List<Cliente> consultarClientes() throws PersistenceException;

    public void agregarItemRentadoACliente(long id, int idit, Date fechainicio, Date fechafin) throws PersistenceException;

    public void vetarCliente(long docu, boolean estado) throws PersistenceException;

    public List<ItemRentado> consultarItemsRentadosCliente(long docu) throws PersistenceException;
}
