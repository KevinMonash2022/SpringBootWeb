package com.kevin.springcoreweb.rest;

import com.kevin.springcoreweb.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // Define a private field for the dependency
    private Coach myCoach;

//    @Autowired
//    public DemoController(@Qualifier("tennisCoach") Coach theCoach){
//        myCoach = theCoach;
//    }

    @Autowired
    public DemoController(Coach theCoach){
        myCoach = theCoach;
    }

//    // Define a constructor for dependency injection
//    @Autowired
//    public DemoController(Coach theCoach) {
//        myCoach = theCoach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}