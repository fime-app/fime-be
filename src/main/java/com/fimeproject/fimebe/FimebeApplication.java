package com.fimeproject.fimebe;

import com.fimeproject.fimebe.dao.TimeblockDAO;
import com.fimeproject.fimebe.entity.Timeblock;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class FimebeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FimebeApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(TimeblockDAO timeblockDAO) {
		return runner -> {
			// createTimeblock(timeblockDAO);

			// readTimeblock(timeblockDAO);

			queryForTimeblocks(timeblockDAO);
		};
	}

	private void queryForTimeblocks(TimeblockDAO timeblockDAO) {
		List<Timeblock> theTimeblocks = timeblockDAO.findAll();

		for (Timeblock tempTimeblock : theTimeblocks) {
			System.out.println(tempTimeblock);
		}
	}
	private void readTimeblock(TimeblockDAO timeblockDAO) {

		// create timeblock object
		System.out.println("Creating a new timeblock object ...");
		Date startDate = Date.valueOf("2017-11-15");
		Timeblock tempTimeblock = new Timeblock(startDate, startDate, "Paul");

		// save the timeblock
		System.out.println("Saving the timeblock ...");
		timeblockDAO.save(tempTimeblock);

		// display timeblock
		int theId = tempTimeblock.getId();
		System.out.println("Saved timeblock. Generated id: " + theId);

		// retrieve timeblock based on id
		System.out.println("Retrieving student with id: " + theId);
		Timeblock myTimeblock = timeblockDAO.findById(theId);

		// display timeblock
		System.out.println("Found the timeblock " + myTimeblock);
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
