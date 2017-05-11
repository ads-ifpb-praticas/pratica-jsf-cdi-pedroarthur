/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.examples.pratica.jsf.cdi.pedroarthur.exceptions;

/**
 *
 * @author Pedro Arthur
 */
public class CPFInUseException extends RuntimeException {
    
    public CPFInUseException(String message) {
        super(message);
    }
}
