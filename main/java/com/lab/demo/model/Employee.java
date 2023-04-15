package com.lab.demo.model;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;
	private String firstName;
	private String lastName;
	private String role;
	private Double salary;
	private LocalDate fecha;

	public Employee() {

	}

	public Employee(String firstName, String lastName, String role, Double salary, LocalDate fecha) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.salary = salary;
		this.fecha = fecha;

	}

	@Override
	public String toString() {
		return employeeId + "  " + firstName + " " + lastName + ", works as " + role + ", with a salary of: " + salary
				+ ", date :" + fecha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId, firstName, lastName, role, salary, fecha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(employeeId, other.employeeId) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(role, other.role)
				&& Objects.equals(salary, other.salary);
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public LocalDate getDate() {
		return fecha;
	}

	public void setDate(LocalDate fecha) {
		this.fecha = fecha;
	}

	private static int calcularEdad(Calendar fechaNac) {
		Calendar today = Calendar.getInstance();

		int año = today.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
		int mes = today.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
		int dia = today.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);

		if (mes < 0 || (mes == 0 && dia < 0)) {
			año = año - 1;
		}
		return año;
	}

	public static String getEdad(LocalDate date) {
		Date fecha = java.sql.Date.valueOf(date);
		if (fecha != null) {
			SimpleDateFormat fecha_s = new SimpleDateFormat("dd/MM/yyyy");
			StringBuilder edad_calculada = new StringBuilder();
			if (fecha != null) {
				edad_calculada.append(fecha_s.format(fecha));
				edad_calculada.append(" (");
				Calendar c = new GregorianCalendar();
				c.setTime(fecha);
				edad_calculada.append(calcularEdad(c));
				edad_calculada.append(" años)");
			}
			return edad_calculada.toString();
		}
		return "";
	}

}
