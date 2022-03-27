package edu.eci.cvds.samples.services.impl;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;

import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import java.sql.Date;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

@Singleton
public class ServiciosAlquilerImpl implements ServiciosAlquiler {

    @Inject
    private ItemDAO itemDAO;
    @Inject
    private ClienteDAO clienteDAO;

    @Inject
    private TipoItemDAO tipoItemDAO;


    @Override
    public int valorMultaRetrasoxDia(int itemId) {

        try {
            return (int) itemDAO.load(itemId).getTarifaxDia();
        } catch (Exception e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler {
        try {
            return clienteDAO.consultarCliente(docu);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public List<ItemRentado> consultarItemsCliente(int idcliente) throws ExcepcionServiciosAlquiler {
        try {
            return clienteDAO.consultarItemsRentadosCliente(idcliente);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
        try {
            return clienteDAO.consultarClientes();
        } catch (Exception e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
        try {
            return itemDAO.load(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar el item "+id,ex);
        }
    }

    @Override
    public List<Item> consultarItemsDisponibles() {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    @Override
    public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
        try {
            List<Cliente> clientes = consultarClientes();
            for (int i=0 ; i<clientes.size() ; i++) {
                ArrayList<ItemRentado> rentados = clientes.get(i).getRentados();
                for (int j=0 ; j<rentados.size() ; j++) {
                    if(rentados.get(j).getItem()!=null){
                        if (rentados.get(j).getItem().getId() == iditem) {
                            long diasRetraso = ChronoUnit.DAYS.between(rentados.get(j).getFechafinrenta().toLocalDate(), fechaDevolucion.toLocalDate());
                            if (diasRetraso < 0) {
                                return 0;
                            }
                            return diasRetraso * valorMultaRetrasoxDia(rentados.get(j).getId());
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw  new ExcepcionServiciosAlquiler("Error al consultar multa de item con id: "+iditem);
        }
        return iditem;
    }

    @Override
    public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler {
        try{
            if(clienteDAO.consultarCliente(docu)==null){
                throw new ExcepcionServiciosAlquiler("El cliente es null Pa") ;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_YEAR, numdias);
            clienteDAO.agregarItemRentadoACliente(docu,item.getId(),date,new java.sql.Date(calendar.getTime().getTime()));
        }  catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al agregar item rentado al cliente con id: " + docu, ex);
        }
    }

    @Override
    public void registrarCliente(Cliente c) throws ExcepcionServiciosAlquiler {
        try {
            clienteDAO.registrarCliente(c);
        } catch (Exception e) {
            throw new UnsupportedOperationException(e.toString());
        }
    }

    @Override
    public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
        try {
            return numdias * itemDAO.load(iditem).getTarifaxDia();
        } catch (Exception e) {
            throw new UnsupportedOperationException("Error al consultar costo alquiler del item con id: "+iditem);
        }
    }

    @Override
    public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
        throw new ExcepcionServiciosAlquiler("Se produjo un error al registrar el item."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
        try {
            if(clienteDAO.consultarCliente(docu)==null){
                throw new UnsupportedOperationException("Cliente Null Pa");
            }
            clienteDAO.vetarCliente(docu, estado);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }


}