//package com.stackroute.muzix.config;
//
//import com.stackroute.muzix.MuzixApplication;
//import com.stackroute.muzix.domain.Muzix;
//import com.stackroute.muzix.service.MuzixService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//
//@Configuration
//@ComponentScan(basePackages = { "com.stackroute.*" })
//@PropertySource("classpath:application.properties")
//public class MuzixConfig {
//    private static final Logger logger = LoggerFactory.getLogger(MuzixApplication.class);
//    //Muzix muzix;
//    @Autowired
//    private MuzixService muzixService;
//
//
//    @Autowired
//    private Environment env;
//
//    @Value("${track.Id}")
//	private  int id;
//	@Value("${track.name}")
//	private String trackName;
//
//	@Value("${track.com}")
//	private String comments;
//
//    @Bean
//
//        private void runMu() {
//        logger.info("From Environment");
//		logger.info("Application id: {}", env.getProperty("track.Id"));
//		logger.info("Application name: {}", env.getProperty("track.name"));
//		logger.info("Application comments: {}", env.getProperty("track.com"));
//
//        logger.info("Using @Value injection");
//        logger.info("Application id: {}", id);
//        logger.info("Application name: {}", trackName);
//        logger.info("Application comments: {}", comments);
//    }
//    }
//
//
//
