package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;

import java.util.Date;
import java.util.List;

public class MyBATISClienteDAO implements ClienteDAO {

    @Inject
    private ClienteMapper clienteMapper;


    @Override
    public void registrarCliente(Cliente c) throws PersistenceException {
        try{
            clienteMapper.registrarCliente(c);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al Registrar Cliente " + clienteMapper.toString(), e);
        }
    }

    @Override
    public Cliente consultarCliente(long id) throws PersistenceException {
        try{
            return clienteMapper.consultarCliente(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al Consultar Cliente " + clienteMapper.toString(), e);
        }
    }

    @Override
    public List<Cliente> consultarClientes() throws PersistenceException {
        try{
            return clienteMapper.consultarClientes();
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al Consultar la lista de clientes " + clienteMapper.toString(), e);
        }
    }

    @Override
    public void agregarItemRentadoACliente(long id, int idit, Date fechainicio, Date fechafin) throws PersistenceException {
        try{
            clienteMapper.agregarItemRentadoACliente(id,idit,fechainicio,fechafin);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al Agregar ItemRentadoAlCliente " + clienteMapper.toString(), e);
        }
    }

    @Override
    public void vetarCliente(long docu, boolean estado) throws PersistenceException {
        try{
            clienteMapper.vetarCliente(docu,estado);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al vetar Cliente " + clienteMapper.toString(), e);
        }
    }

    @Override
    public List<ItemRentado> consultarItemsRentadosCliente(long docu) throws PersistenceException {
        return null;
    }
}
