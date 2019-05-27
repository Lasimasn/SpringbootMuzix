package com.stackroute.muzix.config;

import com.stackroute.muzix.MuzixApplication;
import com.stackroute.muzix.domain.Muzix;
import com.stackroute.muzix.service.MuzixService;
import com.stackroute.muzix.service.MuzixServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.*;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")

public class ListenerBean implements ApplicationListener<ContextRefreshedEvent>
{
        private MuzixServiceImpl muzixService;
        private  Muzix muzix;
        @Autowired
        public ListenerBean(MuzixServiceImpl muzixService, Muzix muzix) {
            this.muzixService = muzixService;
            this.muzix =muzix;
        }

        public ListenerBean() {
        }
        @Autowired
        private Environment env;
        @Override
        public void onApplicationEvent(ContextRefreshedEvent event) {
            System.out.println("Context refreshed event fired:");
            System.out.println(event);
            //Muzix muzix=new Muzix(1,"Jai ho","Hindi");
            //Muzix muzix1=new Muzix(2,"Harry","English");

                muzix.setTrackId(Integer.parseInt(env.getProperty("trackId1")));
                muzix.setTrackName(env.getProperty("trackName1"));
                muzix.setComments(env.getProperty("comments1"));
//                logger.info("Using @Value injection");
//                logger.info("Application id: {}", trackId);
//                logger.info("Application name: {}", trackName);
//                logger.info("Application comments: {}", comments);
            muzixService.seedData(muzix);
            }


        }


