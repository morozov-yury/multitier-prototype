package com.mtp.service;

import com.mtp.dao.impl.TestDao;
import org.apache.logging.log4j.Logger;

import javax.ejb.EJB;
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

    @EJB
    private TestDao testDao;

    public String getOK () {
        logger.error("Error message");
        logger.info("Info message");
        return "OK";
    }

    public String testDB () {
        return testDao.testConnectionToDB();
    }

    public String getNodesWithProperty(String propertyName, int limit) {
        return testDao.getNodesWithProperty(propertyName, limit);
    }

}
