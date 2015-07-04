package com.mtp.dataaccess.dao.impl;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.annotation.PostConstruct;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ws.rs.core.MediaType;

/**
 * Created by morozov.yury on 27/06/2015.
 */
@Stateless
@Remote
public class TestDao {

    private static String SERVER_ROOT_URI = "http://localhost:7474/db/data/";

    public TestDao() {

    }

    @PostConstruct
    private void init () {
    }

    public String testConnectionToDB() {
        WebResource resource = Client.create().resource(SERVER_ROOT_URI);
        ClientResponse response = resource.get(ClientResponse.class);

        String formatedResponse = String.format("GET on [%s], status code [%d]",
                SERVER_ROOT_URI, response.getStatus());
        response.close();

        return formatedResponse;
    }

    public String getNodesWithProperty(String propertyName, int limit) {
        String query = "MATCH (n) WHERE has(n." + propertyName + ") " +
                "RETURN DISTINCT n " +
                "LIMIT " + limit;

        return executeQuery(query);
    }

    public String executeQuery(String query) {
        final String txUri = SERVER_ROOT_URI + "transaction/commit";
        WebResource resource = Client.create().resource( txUri );

        String payload = "{\"statements\" : [ {\"statement\" : \"" + query + "\"} ]}";
        ClientResponse response = resource
                .accept(MediaType.APPLICATION_JSON)
                .type(MediaType.APPLICATION_JSON)
                .entity(payload)
                .post(ClientResponse.class);

        String stringResponse = response.getEntity(String.class);

        response.close();
        return stringResponse;
    }
}
