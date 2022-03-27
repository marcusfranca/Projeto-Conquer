package br.com.conquer.marcus.service;

import br.com.conquer.marcus.exception.NotFoundExceptionId;
import br.com.conquer.marcus.model.User;
import br.com.conquer.marcus.model.dto.UserDTO;
import br.com.conquer.marcus.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {

	private final IUserRepository userRepository;

	public Page<UserDTO> PageUser(Pageable pageable) {
		return userRepository.findAll(pageable).map(User::ToDto);
	}

	public UserDTO create(UserDTO userDTO) {
		return userRepository.save(userDTO.ToEntity()).ToDto();
	}


	public void deleteUser(Long id) {
		checkId(id);
		userRepository.deleteById(id);
	}

	public UserDTO updateUser(UserDTO userDTO, Long id) {
		checkId(id);
		userDTO.id = id;
		return userRepository.save(userDTO.ToEntity()).ToDto();
	}

	@SneakyThrows
	public UserDTO findById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new NotFoundExceptionId(id))
				.ToDto();
	}

	@SneakyThrows
	private void checkId(Long id) {
		userRepository.findById(id)
				.orElseThrow(() -> new NotFoundExceptionId(id))
				.ToDto();
	}
}
