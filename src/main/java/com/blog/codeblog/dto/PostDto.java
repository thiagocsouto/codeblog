package com.blog.codeblog.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;


import lombok.Builder;

@Builder
public record PostDto(
		
		@Positive
		Long id,
		         
		@NotBlank
		String titulo,
		
		@NotBlank
		String autor,
		
		LocalDate data,
		
		@NotBlank
		@Size(max = 2000, message = "O texto não pode ter mais de 1024 caracteres")
		String texto
		
) {}
