package com.tagify.config;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EnvLoader {
    public static void load(){
        Dotenv dotenv = Dotenv.configure()
            .directory(".")
            .filename(".env")
            .load();

        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
    }
    private EnvLoader(){

    }
}

