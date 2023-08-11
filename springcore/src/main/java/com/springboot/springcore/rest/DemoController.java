package com.springboot.springcore.rest;

import com.springboot.springcore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //Define the private field for the injection
    private Coach coach;

    //define a constructor for Dependency injection
/*    @Autowired
    public DemoController(Coach coach){
        this.coach = coach;
    }*/

    public DemoController(@Qualifier("yogibean") Coach coach){
        this.coach = coach;
    }

    //define a setter method for Dependency injection
/*    @Autowired
    public void setCoach(Coach coach){
        this.coach = coach;
    }*/

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return coach.getDailyWorkout();
    }

}
