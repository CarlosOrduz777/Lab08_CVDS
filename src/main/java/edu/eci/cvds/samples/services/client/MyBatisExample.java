/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cvds.samples.services.client;



import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.TipoItem;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author hcadavid
 */
public class MyBatisExample {

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException 
     */
    public static void main(String args[]) throws SQLException{
        SqlSessionFactory sessionfact = getSqlSessionFactory();

        try(SqlSession sqlss = sessionfact.openSession()) {

            pruebaMapperCliente(sqlss);
            pruebaMapperItems(sqlss);
            /*
             System.out.println("*******************************************");
            TipoItemMapper clienteMapper = sqlss.getMapper(TipoItemMapper.class);
            System.out.println(clienteMapper.getTiposItems());

            System.out.println("****************************************************");
            System.out.println(clienteMapper.getTipoItem(1).toString());
             */

            //Crear el mapper y usarlo:
            //ClienteMapper cm=sqlss.getMapper(ClienteMapper.class);
            //Cliente cliente = cm.consultarCliente(1);
            //cm...


            sqlss.commit();


            sqlss.close();
        }
        System.exit(0);
        
        
    }
    private static void pruebaMapperCliente(SqlSession sqlss) {
        //Crear el mapper y usarlo:
        ClienteMapper cm= sqlss.getMapper(ClienteMapper.class);
        //Consultar todos los clientes:
        /*

         */
        List<Cliente> result = cm.consultarClientes();
        for (Cliente c:result) {
            System.out.println(c.toString());
        }
        System.out.println("***********************************************************************************");
        /*
         * //Consultar un cliente con id 8:*/
        System.out.println(cm.consultarCliente(8).toString());

        /**
         System.out.println("***********************************************************************************");
         */
        //Insertar item rentado:
        /*
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		try {
			//Fechas:
			java.sql.Date sqlFechaInicial = new java.sql.Date(formato.parse("2021-10-06").getTime());
	        java.sql.Date sqlFechaFinal = new java.sql.Date(formato.parse("2021-10-06").getTime());
	        cm.agregarItemRentadoACliente(1478822, 92, sqlFechaInicial, sqlFechaFinal);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		   */
    }

    private static void pruebaMapperItems(SqlSession sqlss ) {
        ItemMapper im= sqlss.getMapper(ItemMapper.class);
        /**
         //Insertar item :
         //Fecha
         SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
         try {
         java.sql.Date sqlfechaLanzamiento = new java.sql.Date(formato.parse("2021-05-12").getTime());
         TipoItem tipoItem = new TipoItem(3, "Películas");
         Item item = new Item(tipoItem,20,"Oxígeno","Película Oxigeno 2021 - Netflix",sqlfechaLanzamiento,5000,"DVD","Ciencia ficción");
         im.insertarItem(item);
         }catch (ParseException e) {
         e.printStackTrace();
         }**/
        //Consultar Items:
        System.out.println(im.consultarItems());
        System.out.println("***********************************************************************************");
        //Consultar Item con id 20:
        System.out.println(im.consultarItem(20));


    }


}
