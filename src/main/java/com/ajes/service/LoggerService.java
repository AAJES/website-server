package com.ajes.service;

import java.io.FileOutputStream;
import java.io.PrintStream;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;

@Service
public class LoggerService {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(CareerService.class);

    public void doSomething() {
        logger.info("This is an information log message");
        logger.error("This is an error log message");
        
        String filePath = "D://error.txt";
        
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            PrintStream printStream = new PrintStream(fileOutputStream);
            System.setErr(printStream);
        } catch (Exception e) {
            logger.error("Error while redirecting errors to file: " + e.getMessage());
        }
        // ... other log levels (debug, warn, trace) as needed
    }

}
