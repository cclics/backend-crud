package com.bucannera;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevDiagnostics implements  CommandLineRunner {

  public void run (String... args) {
      System.out.println("Hey Dev Engineer !!");
  }
}

