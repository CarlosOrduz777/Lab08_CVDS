package edu.eci.cvds.samples.services;

import edu.eci.cvds.sampleprj.dao.PersistenceException;

public class ExcepcionServiciosAlquiler extends Exception{
    public ExcepcionServiciosAlquiler(String message){
        super(message);
    }
    public ExcepcionServiciosAlquiler(String message, PersistenceException pe){
        super(message,pe);
    }
}
