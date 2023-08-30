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

}
