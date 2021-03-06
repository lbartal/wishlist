package com.lbartal.wishlist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lbartal.wishlist.domain.User;
import com.lbartal.wishlist.repository.UserRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner init(final UserRepository userRepository) {

		return new CommandLineRunner() {

			@Override
			public void run(String... arg0) throws Exception {
				userRepository.save(new User("Laci", "laszlo.bartal@gmail.com", "passwd"));
			}

		};

	}
}