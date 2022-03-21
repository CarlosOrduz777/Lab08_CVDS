package edu.eci.cvds.samples.services.impl;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;

import java.sql.Date;
import java.util.List;

public class ServiciosAlquilerItemsImpl implements ServiciosAlquiler {
    @Override
    public int valorMultaRetrasoxDia(int itemId) {
        return 0;
    }

    @Override
    public Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler {
        return null;
    }

    @Override
    public List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler {
        return null;
    }

    @Override
    public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
        return null;
    }

    @Override
    public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
        return null;
    }

    @Override
    public List<Item> consultarItemsDisponibles() {
        return null;
    }

    @Override
    public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
        return 0;
    }

    @Override
    public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
        return null;
    }

    @Override
    public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
        return null;
    }

    @Override
    public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler {

    }

    @Override
    public void registrarCliente(Cliente p) throws ExcepcionServiciosAlquiler {

    }

    @Override
    public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
        return 0;
    }

    @Override
    public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {

    }

    @Override
    public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {

    }

    @Override
    public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {

    }
}
