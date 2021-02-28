package com.bulo.springit;

import com.bulo.springit.config.SpringitProperties;
import com.bulo.springit.domain.Comment;
import com.bulo.springit.domain.Link;
import com.bulo.springit.repository.CommentRepository;
import com.bulo.springit.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
public class SpringitApplication {

    @Autowired
    private ApplicationContext applicationContext;
    private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
    }


    @Bean
    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository){
        return args -> {
          Link link = new Link ("Getting Started with Spring Boot2", "htpps://therealdanvega.com/springb-boot-2");
            linkRepository.save(link);

            Comment comment = new Comment("This Spring Boot Comment", link);
            commentRepository.save(comment);
            link.addComment(comment);

        };
    }
}
