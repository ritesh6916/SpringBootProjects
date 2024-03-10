package com.ritesh.survey.persistence;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ritesh.survey.templates.UserDetails;

@Component
public class UserDetailsConnandLineRunner implements CommandLineRunner {

	private UserRepository userRepository;

	private Logger logger = LoggerFactory.getLogger(getClass());

	public UserDetailsConnandLineRunner(UserRepository repository) {
		this.userRepository = repository;
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new UserDetails("Ritesh", "ADMIN"));
		userRepository.save(new UserDetails("Dummy", "USER"));
		
		List<UserDetails> users = userRepository.findAll();
		for (UserDetails user : users) {
			logger.info(user.toString());
		}
		logger.info("User with role ADMIN: "+userRepository.findByRole("ADMIN").toString());
	}

}