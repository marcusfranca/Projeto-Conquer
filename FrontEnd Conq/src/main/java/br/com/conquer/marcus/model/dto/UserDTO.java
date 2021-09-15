package br.com.conquer.marcus.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class UserDTO  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotNull(message = "nome não pode estar nulo")
	private String name;
	
	@NotNull(message = "email não pode estar nulo")
	private String email;
	
	@NotNull(message = "telefone não pode estar nulo") 
	private String phone;
	
	@NotNull(message = "data de nascimento não pode estar nulo") 
	private LocalDate birthday;


}
