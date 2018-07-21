package br.com.bitcoin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("br.com.bitcoin")
public class Application {

  private static final Logger logger = LoggerFactory.getLogger(Application.class);

  @PostConstruct
  public void testLog() {
    logger.debug("Welcome to Archetype APP!");
  }

  public static void main(String[] agrs) {
    SpringApplication.run(Application.class);
  }
}
