package com.springboot.springcore.common;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("Inside Swim Costrutor");
    }
    @Override
    public String getDailyWorkout() {
        return "Swim in Narmda river";
    }
}
