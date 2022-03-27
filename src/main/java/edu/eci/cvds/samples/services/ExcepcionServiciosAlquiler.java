package edu.eci.cvds.samples.services;

import edu.eci.cvds.sampleprj.dao.PersistenceException;

public class ExcepcionServiciosAlquiler extends Exception {

    public ExcepcionServiciosAlquiler(String string, PersistenceException ex) {
        super(string, ex);
    }

    public ExcepcionServiciosAlquiler(String string) {
        super(string);
    }

}
