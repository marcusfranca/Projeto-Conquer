package br.com.conquer.marcus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.conquer.marcus.model.User;
import br.com.conquer.marcus.model.dto.UserDTO;
import br.com.conquer.marcus.repository.IUserRepository;

@Service 
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userRepository; // repository

	@Override
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User create(User user) {
		return userRepository.save(user);
	}

	@Override
	public User update(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public UserDTO toDTO(User user) {
		return null;
	}

	@Override
	public User toModel(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail(), userDTO.getPhone(),
				userDTO.getBirthday());
	}

}
