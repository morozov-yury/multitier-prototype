package com.mtp.service;

import org.apache.logging.log4j.Logger;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by morozov.yury on 27/05/2015.
 */
@Singleton
@Remote
public class TestService implements Serializable {

    @Inject
    private Logger logger;

    public String getOK () {
        logger.error("Error message");
        logger.info("Info message");
        return "OK";
    }

}
