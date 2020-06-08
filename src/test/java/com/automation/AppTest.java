package com.automation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue(){

        assertTrue( true );

        Logger logger = LogManager.getLogger(AppTest.class);
        logger.debug("Hello from Log4j 2");

        logger.trace("log: Trace");
        logger.debug("log: debug");
        logger.info("log: info");
        logger.warn("log: warn");
        logger.error("log: error");
        logger.fatal("log: fatal");
    }
}
