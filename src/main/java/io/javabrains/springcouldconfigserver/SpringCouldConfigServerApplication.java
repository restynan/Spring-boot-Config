package io.javabrains.springcouldconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCouldConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCouldConfigServerApplication.class, args);
    }

}
