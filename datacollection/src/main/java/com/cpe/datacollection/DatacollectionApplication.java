package com.cpe.datacollection;

import com.cpe.datacollection.model.Student;
import com.cpe.datacollection.repo.StudentRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@ServletComponentScan
@RequiredArgsConstructor
public class DatacollectionApplication {

	private final StudentRepo studentRepo;

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DatacollectionApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DatacollectionApplication.class, args);
	}

	@PostConstruct
	public void initDB () {
		List<Student> students = Arrays.asList(
				new Student(null, "John", "Doe", "180406895", "Engineering", "Computer Engineering", "darey1oguns@gmail.com", "07014587854"),
				new Student(null, "Alicia", "Keys", "180406895", "Engineering", "Computer Engineering", "darey1oguns@gmail.com", "07014587854"),
				new Student(null, "Brian", "White", "180406895", "Engineering", "Computer Engineering", "darey1oguns@gmail.com", "07014587854")
		);
		studentRepo.saveAll(students);
	}
}
