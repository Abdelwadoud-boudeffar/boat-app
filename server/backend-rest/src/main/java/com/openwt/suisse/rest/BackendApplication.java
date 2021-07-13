package com.openwt.suisse.rest;

import com.openwt.suisse.dto.BoatDTO;
import com.openwt.suisse.service.BoatService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.openwt.suisse.dto.UserCreateDTO;
import com.openwt.suisse.service.UserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * @author ABDELWADOUD BOUDEFFAR
 * @since 1.0
 */

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan({"com.openwt.suisse.service", "com.openwt.suisse.rest.controller"})
@EntityScan("com.openwt.suisse.dao.model")
@EnableJpaRepositories("com.openwt.suisse.dao.repository")
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner createInitialUsers(UserService userService, BoatService boatService) {
		return (args) -> {
			UserCreateDTO user = new UserCreateDTO();
			user.setUserName("User1");
			user.setFirstName("Abdel1");
			user.setLastName("Boudeffar1");

			userService.createUser(user);

			BoatDTO boat = new BoatDTO();
			boat.setBoatName("boat1");
			boat.setDescription("A boat is a watercraft of a large range of types and sizes, but generally smaller than a ship.");

			boatService.createBoat(boat);

			BoatDTO boat2 = new BoatDTO();
			boat2.setBoatName("boat2");
			boat2.setDescription("A boat is a watercraft of a large range of types and sizes, but generally smaller than a ship.");

			boatService.createBoat(boat2);

			BoatDTO boat3 = new BoatDTO();
			boat3.setBoatName("boat3");
			boat3.setDescription("A boat is a watercraft of a large range of types and sizes, but generally smaller than a ship.");

			boatService.createBoat(boat3);

		};
	}

}
