package com.verydapeng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class ConfigSimpleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ConfigSimpleApplication.class, args);
    }

    @Autowired
    MyService service;

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(service.getMessage());
    }
}

@Configuration
class Config {

    @Bean
    MyService myService(MyRepo repo) {
        return new MyService(repo);
    }

    @Bean
    MyRepo myRepo() {
        return new MyRepo();
    }
}

class MyService {

    final MyRepo repo;

    MyService(MyRepo repo) {
        this.repo = repo;
    }

    String getMessage() {
        return repo.getMessage();
    }
}

class MyRepo {

    String getMessage() {
        return "this is the message";
    }
}