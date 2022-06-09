package es.inditex.prices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Spring Startup Application
 * @author Benjamin Rodriguez
 *
 */
@EnableWebMvc
@SpringBootApplication
public class MsPricesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPricesApplication.class, args);
	}

}
