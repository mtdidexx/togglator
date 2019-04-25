package net.katrinka.togglator;

import net.katrinka.togglator.config.TogglatorFeatures;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.togglz.core.manager.EnumBasedFeatureProvider;
import org.togglz.core.spi.FeatureProvider;

@SpringBootApplication
public class TogglatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TogglatorApplication.class, args);
	}

	@SuppressWarnings("unchecked")
	@Bean
	public FeatureProvider featureProvider() {
		return new EnumBasedFeatureProvider(TogglatorFeatures.class);
	}
}
