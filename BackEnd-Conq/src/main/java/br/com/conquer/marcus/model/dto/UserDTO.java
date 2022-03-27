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

	@NotNull(message = "Nome não poder ser nulo")
	public String name;

	@NotNull(message = "Email não pode ser nulo")
	@Email
	public String email;

	@NotNull(message = "Telefone não pode ser nulo")
	@Size(min = 11, max = 11)
	public String phone;

	@NotNull(message = "Data De Nascimento não pode ser nulo")
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
