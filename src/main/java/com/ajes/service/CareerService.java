package com.ajes.service;

import com.ajes.model.Career;
import com.ajes.repository.CareerRepository;

import ch.qos.logback.classic.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

@Service
public class CareerService {

    @Autowired
    private CareerRepository careerRepository;
    
    private static final Logger logger = (Logger) LoggerFactory.getLogger(CareerService.class);

    public Career addCareer(Career career){
    	
    	System.out.println(career.getAttachFile()+ career);
    	
    	if(career.getAttachFile().equals(" ")) {
    		System.out.println("catch block");
    		logger.error("Error occurred in CareerService: ");
    		logger.info("This is an information log message");
            logger.error("This is an error log message");
            
            String filePath = "./error.txt";
            
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                PrintStream printStream = new PrintStream(fileOutputStream);
                System.setErr(printStream);
            } catch (Exception p) {
                logger.error("Error while redirecting errors to file: " + p.getMessage());
            }
    	}else {
    		System.out.println("catch block");
    		logger.error("Error occurred in CareerService: ");
    		logger.info("This is an information log message");
            logger.error("This is an error log message");
            
            String filePath = "./error.txt";
            
            try {
            	logger.error("Error occurred in CareerService: ");
                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                PrintStream printStream = new PrintStream(fileOutputStream);
                System.setErr(printStream);
            } catch (Exception p) {
                logger.error("Error while redirecting errors to file: " + p.getMessage());
            }
    		return careerRepository.save(career);
    	}
    	return null;
    }

    public List<Career> getAllCareer(){
        return careerRepository.findAll();
    }

    public Career getCareerById(Integer careerId){
        return careerRepository.findById(careerId).get();
    }


    public Career deleteCareerId(Integer careerId){
       Career career = getCareerById(careerId);
       careerRepository.deleteById(careerId);
       return career;
    }

    public Career updateCareerById(Integer careerId,Career career){
        career.setCareerId(careerId);
        return careerRepository.save(career);
    }

}
