package com.christ.attendanceTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class AttendanceTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceTrackerApplication.class, args);
	}

	@GetMapping("/")
	public String welcome() {
		return "<h1>This is springboot</h1>";
	}
	
}
