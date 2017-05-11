/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.examples.pratica.jsf.cdi.pedroarthur.beans;

import io.github.kieckegard.examples.pratica.jsf.cdi.pedroarthur.domain.Client;
import io.github.kieckegard.examples.pratica.jsf.cdi.pedroarthur.services.ClientService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Pedro Arthur
 */

@Named
@ConversationScoped
public class ClientBean implements Serializable {
    
    @Inject
    private Conversation conversation;
    
    @Inject
    private ClientService clientService;
    
    private Client client;
    private Client selectedClient;
    
    private List<Client> clients;
    
    @PostConstruct
    private void init() {
        System.out.println("[ClientBean.init()] constructed.");
        initAttributes();
        loadList();
    }
    
    private void initAttributes() {
        this.client = new Client();
    }
    
    public String save() {
        System.out.println("[ClientBean.save()] entrei");
        try {
            this.clientService.save(client);
            addMessage("clientMsg", createMessage("O cliente "
                    + client.getName() + " foi salvo com sucesso!", 
                    FacesMessage.SEVERITY_INFO));
            loadList();
        } catch (EJBException ex) {
            addMessage("clientMsg", createMessage(ex
                    .getCausedByException().getMessage(), 
                    FacesMessage.SEVERITY_INFO));
        }
        return "manager";
    }
    
    public String select(Client client) {
        System.out.println("[ClientBean.select()] entrei");
        initConversation();
        this.selectedClient = client;
        return null;
    }
    
    public String remove() {
        System.out.println("[ClientBean.remove()] entrei");
        if(selectedClient == null) {
            addMessage("clientMsg", createMessage("Por favor, selecione "
                    + "um cliente abaixo antes de iniciar essa operação.", 
                    FacesMessage.SEVERITY_ERROR));
        } else {
            clientService.remove(selectedClient);
            loadList();
            addMessage("clientMsg", createMessage("O cliente "
                    + selectedClient.getName() + " foi removido com sucesso!", 
                    FacesMessage.SEVERITY_INFO));
            endConversation();
        }
        
        return null;
    }
    
    public String info() {
        if(selectedClient == null) {
            addMessage("clientMsg", createMessage("Por favor, selecione "
                    + "um cliente abaixo antes de iniciar essa operação.", 
                    FacesMessage.SEVERITY_ERROR));
            return null;
        } else {
            endConversation();
            return "info";
        } 
    }
    
    public String edit() {
        if(selectedClient == null) {
            addMessage("clientMsg", createMessage("Por favor, selecione "
                    + "um cliente abaixo antes de iniciar essa operação.", 
                    FacesMessage.SEVERITY_ERROR));
            return null;
        } else {
            return "edit";
        } 
    }
    
    public String update() {
        clientService.update(selectedClient);
        addMessage("clientMsg", createMessage("As alterações foram salvas "
                    + " com sucesso!", 
                    FacesMessage.SEVERITY_INFO));
        endConversation();
        return "manager";
    }
    
    private void loadList() {
        this.clients = clientService.listAll();
    }
    
    public boolean isEmpty() {
        return this.clients.isEmpty();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    private FacesMessage createMessage(String text, FacesMessage.Severity severity) {
        FacesMessage message = new FacesMessage(text);
        message.setSeverity(severity);
        return message;
    }

    private void addMessage(String clientId, FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(clientId, message);
    }

    public List<Client> getClients() {
        return clients;
    } 
    
    private void initConversation() {
        if(this.conversation.isTransient()) 
            this.conversation.begin();
    }
    
    private void endConversation() {
        if(!this.conversation.isTransient())
            this.conversation.end();
    }

    public Client getSelectedClient() {
        return selectedClient;
    }

    public void setSelectedClient(Client selectedClient) {
        this.selectedClient = selectedClient;
    }
    
}
