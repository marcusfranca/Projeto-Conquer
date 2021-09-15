package br.com.conquer.marcus.service;

import java.util.List;
import java.util.Optional;

import br.com.conquer.marcus.model.User;
import br.com.conquer.marcus.model.dto.UserDTO;

public interface IUserService {
	
	Optional<User> findById(Long id);
	
	List<User> findAll();
	
	User create(User user); 
	
	User update(User user); 
	
	void deleteById(Long id); 
	
	UserDTO toDTO(User user); 
	
	User toModel(UserDTO userDTO); 
}
 