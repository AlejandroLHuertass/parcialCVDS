package com.lab.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lab.demo.model.Employee;
import com.lab.demo.service.EmployeeService;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return (args) -> {

			System.out.println("\nDelete all employees....");
			employeeService.deleteAllEmployees();

			System.out.println("\nMi usuario");
			employeeService.addEmployee(
					new Employee("Alejandro", "Huertas", "developer", 1000000.00, LocalDate.of(2000, 1, 25)));
			employeeService.addEmployee(
					new Employee("jorge", "profe", "developer", 1000000.00, LocalDate.of(1992, 1, 25)));

			System.out.println("\nGetting all employees....");
			employeeService.getAllEmployees().forEach(employee -> System.out.println(employee));

			System.out.println("\nGetting employee with id = 1....");

			for (Employee i : employeeService.getAllEmployees()) {

				String edad = i.getEdad(i.getDate());
				System.out.println(i.getFirstName() + " edad " + edad);
			}

		};
	}

}
