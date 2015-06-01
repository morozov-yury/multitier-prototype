package com.mtp.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 * Created by morozov.yury on 01/06/2015.
 */
public class LoggerProducer {

    @Produces
    public Logger getLogger(InjectionPoint injectionPoint) {
        return LogManager.getLogger(injectionPoint.getMember().getDeclaringClass());
    }

}