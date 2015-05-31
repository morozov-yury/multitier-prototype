package com.mtp.service;

import javax.ejb.Remote;
import javax.ejb.Singleton;
import java.io.Serializable;

/**
 * Created by morozov.yury on 27/05/2015.
 */
@Singleton
@Remote
public class TestService implements Serializable {

    public String getOK () {
        return "OK";
    }

}
