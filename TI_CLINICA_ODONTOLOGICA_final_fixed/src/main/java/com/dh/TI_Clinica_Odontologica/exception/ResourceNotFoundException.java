package com.dh.TI_Clinica_Odontologica.exception;

//creamos nuestra propia excepción
public class ResourceNotFoundException extends RuntimeException {
    //creo un constructor
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
