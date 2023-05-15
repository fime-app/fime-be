package com.fimeproject.fimebe;

import com.fimeproject.fimebe.dao.TimeblockDAO;
import com.fimeproject.fimebe.entity.Timeblock;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class FimebeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FimebeApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(TimeblockDAO timeblockDAO) {
		return runner -> {
			createTimeblock(timeblockDAO);
		};
	}

	private void createTimeblock(TimeblockDAO timeblockDAO) {
		System.out.println("Creating new time block object ...");

		Date startDate = Date.valueOf("2017-11-15");
		Timeblock tempTimeblock = new Timeblock(startDate, startDate, "Paul");

		System.out.println("Saving the timeblock  ...");

		System.out.println(tempTimeblock.toString());
		timeblockDAO.save(tempTimeblock);

		System.out.println("Saved student. Generated id: " + tempTimeblock.getId());

	}
}
