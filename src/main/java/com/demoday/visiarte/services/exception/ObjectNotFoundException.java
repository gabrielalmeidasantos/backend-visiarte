package com.demoday.visiarte.services.exception;

public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    //Essa função é responsável pelo erro não encontrado.
    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
