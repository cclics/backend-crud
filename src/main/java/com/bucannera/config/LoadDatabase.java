package com.bucannera.config;

import com.bucannera.post.Post;
import com.bucannera.post.PostRepository;
import com.bucannera.street.Street;
import com.bucannera.street.StreetRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PostRepository repository, StreetRepository repository2) {

        return args -> {
            log.info("Preloading " + repository.save(new Post("Football happiness", "People is happy.")));
            log.info("Preloading " + repository.save(new Post("The life of Jane Goodall", "The scientist of chimps.")));

            log.info("Preloading2 " + repository2.save(new Street("010","Rua das Acacias","Petropolis")));
            log.info("Preloading2 " + repository2.save(new Street("011", "Rua Calogeras", "Rio de Janeiro")));
        };
    }

    //@Bean
   // CommandLineRunner initDatabase2(StreetRepository repository2) {

    //    return args -> {
      //      log.info("Preloading2 " + repository2.save(new Street("","","Football happiness", "People is happy.")));
      //      log.info("Preloading2 " + repository2.save(new Street("The life of Jane Goodall", "The scientist of chimps.")));
       // };
   // }
}
