/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.examples.pratica.jsf.cdi.pedroarthur.beans.validators;
import br.com.caelum.stella.validation.InvalidStateException;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Pedro Arthur
 */

@FacesValidator("cpfValidator")
public class CPFValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        try {
            new br.com.caelum.stella.validation.CPFValidator().assertValid(value.toString());
        } catch (InvalidStateException ex) {
            FacesMessage msg = new FacesMessage("O CPF inserido é inválido.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }  
}
