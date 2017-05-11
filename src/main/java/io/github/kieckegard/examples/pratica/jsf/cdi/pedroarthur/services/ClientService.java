/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.examples.pratica.jsf.cdi.pedroarthur.services;

import io.github.kieckegard.examples.pratica.jsf.cdi.pedroarthur.domain.Client;
import java.util.List;

/**
 *
 * @author Pedro Arthur
 */
public interface ClientService {
    void save(Client client);
    void update(Client client);
    List<Client> listAll();
    void remove(Client client);
}
