/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.examples.pratica.jsf.cdi.pedroarthur.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Pedro Arthur
 */

@Entity
public class Client implements Serializable {
    
    @Id
    private String cpf;
    private String name;
    private String email;
    private String phone;
    private String cellphone;
    private String observations;
    
    public Client() {
        
    }

    public Client(String cpf, String name, String email, String phone, String cellphone, String observations) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cellphone = cellphone;
        this.observations = observations;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    @Override
    public String toString() {
        return "Client{" + "cpf=" + cpf + ", name=" + name + ", email=" + email + ", phone=" + phone + ", cellphone=" + cellphone + ", observations=" + observations + '}';
    }
}
