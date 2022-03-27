package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.Date;
import java.util.List;

import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Cliente;


public interface ClienteMapper {
    
    public Cliente consultarCliente(long id);
    
    /**
     * Registrar un nuevo item rentado asociado al cliente identificado
     * con 'idc' y relacionado con el item identificado con 'idi'
     * @param id
     * @param idit
     * @param fechainicio
     * @param fechafin 
     */
    public void agregarItemRentadoACliente(@Param("idcli")long id,
                                           @Param("idit")int idit,
                                           @Param("fechainicio")Date fechainicio,
                                           @Param("fechafin")Date fechafin);

    /**
     * Consultar todos los clientes
     * @return 
     */
    public List<Cliente> consultarClientes();
    public void registrarCliente(Cliente c);
    public void vetarCliente(long docu, boolean estado);

    public List<ItemRentado> consultarItemsRentadosCliente(@Param("idCliente") int idCliente);
}
