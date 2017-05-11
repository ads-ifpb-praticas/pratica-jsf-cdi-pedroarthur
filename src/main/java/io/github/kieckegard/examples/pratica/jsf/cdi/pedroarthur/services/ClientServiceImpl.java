/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.examples.pratica.jsf.cdi.pedroarthur.services;

import io.github.kieckegard.examples.pratica.jsf.cdi.pedroarthur.domain.Client;
import io.github.kieckegard.examples.pratica.jsf.cdi.pedroarthur.exceptions.CPFInUseException;
import io.github.kieckegard.examples.pratica.jsf.cdi.pedroarthur.repositories.ClientRepository;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Pedro Arthur
 */

@Stateless
@Local(ClientService.class)
public class ClientServiceImpl implements ClientService {
    
    @Inject
    private ClientRepository clientRepository;

    @Override
    public void save(Client client) {
        try {
            verifyCpf(client.getCpf());
            clientRepository.save(client);
        } catch (CPFInUseException ex) {
            throw new EJBException(ex);
        }
    }
    
    private void verifyCpf(String cpf) {
        Client found = clientRepository.find(cpf);
        if(found != null)
            throw new CPFInUseException("The cpf "+cpf+" is in use. Please insert a new one.");
    }

    @Override
    public void update(Client client) {
        clientRepository.update(client);
    }

    @Override
    public List<Client> listAll() {
        return clientRepository.listAll();
    }

    @Override
    public void remove(Client client) {
        Client found = clientRepository.find(client.getCpf());
        clientRepository.remove(found);
    }
    
}
