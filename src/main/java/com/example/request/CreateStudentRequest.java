package com.example.request;

import java.util.List;



import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateStudentRequest {

	@JsonProperty("first_name")
	@NotBlank(message = "First name is required")
	private String firstName;

	private String lastName;

	private String email;

	private String street;

	private String city;

	private List<CreateSubjectRequest> subjectsLearning;

}
