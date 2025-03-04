package com.example.demo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Data
@Setter
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Employee{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer empId;
	
	@NonNull
	private String empName;
	
	@NonNull
	private Integer empAge;
}
