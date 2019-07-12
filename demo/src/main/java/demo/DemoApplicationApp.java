package demo;

import demo.entities.User;
import demo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;


@SpringBootApplication
public class DemoApplicationApp {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DemoApplicationApp.class, args);
    }

    @Bean
    CommandLineRunner init(final UserRepository userRepository){
        return args -> {
            Stream.of("Avi","Chida","Rahul","Jio","Zach").forEach(name -> {
                User user = new User(name,name.toLowerCase() + "@gmail.com");
                userRepository.save(user);
            });
            userRepository.findAll().forEach(System.out:: println);
        };
    }
}
