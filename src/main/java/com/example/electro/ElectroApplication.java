package com.example.electro;

import com.example.electro.entity.Appliance;
import com.example.electro.entity.User;
import com.example.electro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ElectroApplication {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	private void save() {
		List<User> list = new ArrayList<>();

		list.add(new User("Kalles Grustransporter AB",
				"Cementvägen 8, 111 11 Södertälje",
				Arrays.asList(
						new Appliance("YS2R4X20005399401", "ABC123", Timestamp.valueOf(LocalDateTime.now())),
						new Appliance("VLUR4X20009093588", "DEF456", Timestamp.valueOf(LocalDateTime.now())),
						new Appliance("VLUR4X20009048066", "GHI789", Timestamp.valueOf(LocalDateTime.now()))
				)));

		list.add(new User("Johans Bulk AB",
				"Balkvägen 12, 222 22 Stockholm",
				Arrays.asList(
						new Appliance("YS2R4X20005388011", "JKL012", Timestamp.valueOf(LocalDateTime.now())),
						new Appliance("YS2R4X20005387949", "MNO345", Timestamp.valueOf(LocalDateTime.now()))
				)));

		list.add(new User("Haralds Värdetransporter AB",
				"Budgetvägen 1, 333 33 Uppsala",
				Arrays.asList(
						new Appliance("YS2R4X20009048066", "PQR678", Timestamp.valueOf(LocalDateTime.now())),
						new Appliance("YS2R4X20005387055", "STU901", Timestamp.valueOf(LocalDateTime.now()))
				)));

		userRepository.saveAll(list);
	}

	public static void main(String[] args) {
		SpringApplication.run(ElectroApplication.class, args);
	}

}
