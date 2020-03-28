package pl.bykowski.springdataexample;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringdataexampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdataexampleApplication.class, args);
    }



    @Bean
    public ExitCodeGenerator exitCodeGenerator(){
        return () -> 42;
    }

}


