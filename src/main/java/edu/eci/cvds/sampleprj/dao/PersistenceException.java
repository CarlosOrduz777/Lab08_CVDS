package edu.eci.cvds.sampleprj.dao;

public class PersistenceException extends Exception{
    public PersistenceException(String message){
        super(message);
    }
    public PersistenceException(String string, org.apache.ibatis.exceptions.PersistenceException e) {
        super(string,e);
    }
}
