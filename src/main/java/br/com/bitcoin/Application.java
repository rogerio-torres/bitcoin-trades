package br.com.bitcoin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("br.com.bitcoin")
public class Application {

  public static void main(String[] agrs) {
    SpringApplication.run(Application.class);
  }
}
