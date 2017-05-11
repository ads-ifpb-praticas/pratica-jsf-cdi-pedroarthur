/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.examples.pratica.jsf.cdi.pedroarthur.repositories;

import io.github.kieckegard.examples.pratica.jsf.cdi.pedroarthur.domain.Client;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Pedro Arthur
 */

@Stateless
@Local(ClientRepository.class)
public class ClientRepositoryJpaImpl implements ClientRepository {
    
    @PersistenceContext(unitName = "pratica-jsf-cdi-pu")
    private EntityManager manager;

    @Override
    public void save(Client client) {
        manager.persist(client);
    }

    @Override
    public void update(Client client) {
        manager.merge(client);
    }

    @Override
    public List<Client> listAll() {
        TypedQuery<Client> query = manager
                .createQuery("SELECT c FROM Client c", Client.class);
        return query.getResultList();
    }

    @Override
    public void remove(Client client) {
        manager.remove(client);
    }

    @Override
    public Client find(String cpf) {
        return manager.find(Client.class, cpf);
    }
    
}
