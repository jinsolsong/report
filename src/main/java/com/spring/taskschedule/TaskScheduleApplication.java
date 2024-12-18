package com.spring.taskschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TaskScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskScheduleApplication.class, args);
    }

}
