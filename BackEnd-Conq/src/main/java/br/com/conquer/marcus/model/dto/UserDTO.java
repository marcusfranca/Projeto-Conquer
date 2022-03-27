package br.com.conquer.marcus.model.dto;

import br.com.conquer.marcus.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO{


	public Long id;

	@NotNull(message = "nome é necessario")
	public String name;

	@NotNull(message = "email é necessario")
	@Email
	public String email;

	@NotNull(message = "telefone")
	@Size(min = 11, max = 11)
	public String phone;

	@NotNull(message = "data de nascimento é necessario")
	public LocalDateTime birthday;

	public User ToEntity(){
		return User.builder()
				.id(id)
				.name(name)
				.email(email)
				.birthday(birthday)
				.phone(phone)
				.build();
	}

}
