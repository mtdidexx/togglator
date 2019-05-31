package net.katrinka.togglator;

import lombok.extern.slf4j.Slf4j;
import net.katrinka.togglator.config.TogglatorFeatures;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.togglz.core.manager.EnumBasedFeatureProvider;
import org.togglz.core.repository.file.FileBasedStateRepository;
import org.togglz.core.spi.FeatureProvider;
import org.togglz.spring.boot.autoconfigure.TogglzProperties;

import java.io.File;
import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class TogglatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TogglatorApplication.class, args);
	}

	@EventListener
	public void handleContextRefreshedEvent(ContextRefreshedEvent event) {
		var context = event.getApplicationContext();
//		Arrays.stream(context.getBeanDefinitionNames()).filter(s -> s.toLowerCase().contains("togglz")).sorted().forEach(System.out::println);
	}

	@Bean
	public FileBasedStateRepository fileBasedStateRepository() {
		File file = new File("tg.properties");
		log.info(" TOGGLZ CONFIG FILE EXISTS: {}", file.exists());
		return new FileBasedStateRepository(file);
	}

	@SuppressWarnings("unchecked")
	@Bean
	public FeatureProvider featureProvider() {
		return new EnumBasedFeatureProvider(TogglatorFeatures.class);
	}
}
