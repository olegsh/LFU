package org.olegsh.cache.lfu.api.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.olegsh.cache"})
public class App implements CommandLineRunner {
  private static Logger logger = LoggerFactory.getLogger(App.class);

  public static void main(String...args) {
    logger.info("LFU is starting...");
    SpringApplication.run(App.class, args);
    logger.info("LFU is Completed...");
  }

  @Override
  public void run(String... args) throws Exception {
    logger.info("EXECUTING : command line runner");
  }
}
