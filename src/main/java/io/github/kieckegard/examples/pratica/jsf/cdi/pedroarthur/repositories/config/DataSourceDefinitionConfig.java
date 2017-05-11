/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.examples.pratica.jsf.cdi.pedroarthur.repositories.config;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;

/**
 *
 * @author Pedro Arthur
 */
@DataSourceDefinition(
        name = "java:app/praticas/jsf-cdi/datasource",
        className = "org.h2.jdbcx.JdbcDataSource",
        url = "jdbc:h2:mem:pratica-jsf-cdi",
        user = "sa",
        password = ""
)
@Stateless
public class DataSourceDefinitionConfig {
    
}
