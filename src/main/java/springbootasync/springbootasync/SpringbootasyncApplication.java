package springbootasync.springbootasync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SpringbootasyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootasyncApplication.class, args);
	}

}
