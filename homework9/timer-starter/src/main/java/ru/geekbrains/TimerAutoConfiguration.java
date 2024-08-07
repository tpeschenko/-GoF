package ru.geekbrains;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TimerAutoConfiguration {

    @Bean
    TimerAspect timerAspect() {
        return new TimerAspect();
    }
}
