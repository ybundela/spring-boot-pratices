package com.springboot.springcore.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class HockyCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Inside Hocky Coach";
    }
}
