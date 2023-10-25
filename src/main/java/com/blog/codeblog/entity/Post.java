package com.blog.codeblog.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="post")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Post implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	         
	@Column(name="título")
	@NotBlank
	private String titulo;
	
	@NotBlank
	private String autor;
	
	private LocalDate data;
	
	@NotBlank
	@Column(name="texto", length=1024)
	private String texto;


}
