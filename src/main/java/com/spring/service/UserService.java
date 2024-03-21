package com.spring.service;

import com.spring.entities.onetomany.MobileEntity;
import com.spring.repositories.MobileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private MobileRepository mobileRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public String getUser(String user){
        logger.info("doing something...");
        logger.info("doing something...");
        logger.info("doing something...");
        logger.info("doing something...");
        logger.info("doing something...");
        logger.info("doing something...");
        mobileRepository.save(new MobileEntity());
        return "done!!";
    }
}
