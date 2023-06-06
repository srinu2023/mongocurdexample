package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="productsdata")
public class Product {
	@Id
	private long id;
	@NotBlank
	@Size(max=100)
	@Indexed(unique=true)
	private String name;
	private String description;

}
