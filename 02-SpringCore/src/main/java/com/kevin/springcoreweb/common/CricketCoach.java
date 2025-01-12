package com.kevin.springcoreweb.common;

//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Scope;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // Define init method
    @PostConstruct
    public void doMyStartupStaff() {
        System.out.println("In doMyStartupStaff: " + getClass().getSimpleName());
    }

    // Define destroy method
    @PreDestroy
    public void doMyCleanupStaff() {
        System.out.println("In doMyCleanupStaff: " + getClass().getSimpleName());
    }


    @Override
    public String getDailyWorkout() {

        return "practice fast bowling for 15 minutes";
    }
}
