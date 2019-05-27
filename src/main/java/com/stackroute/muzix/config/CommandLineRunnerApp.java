package com.stackroute.muzix.config;

import com.stackroute.muzix.domain.Muzix;
import com.stackroute.muzix.service.MuzixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component

public class CommandLineRunnerApp implements CommandLineRunner {
    MuzixService muzixService;
    Muzix muzix1;
    @Autowired
    public CommandLineRunnerApp(){}
    public CommandLineRunnerApp(MuzixService muzixService, Muzix muzix1) {
        this.muzixService = muzixService;
        this.muzix1 = muzix1;
    }

    @Value("${trackId}")
    public   int trackId;
    @Value("${trackName}")
    public String trackName;
    @Value("${comments}")
	public String comments;

    @Override
    public void run(String... args){


        muzix1.setTrackId(trackId);
        muzix1.setTrackName(trackName);
        muzix1.setComments(comments);
        muzixService.seedData(muzix1);

    }
}
