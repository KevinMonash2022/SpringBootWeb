package com.kevin.springcoreweb.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "practice fast bowling for 15 minutes";
    }
}