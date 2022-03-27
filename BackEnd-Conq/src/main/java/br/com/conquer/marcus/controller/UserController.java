package br.com.conquer.marcus.controller;

import br.com.conquer.marcus.model.dto.UserDTO;
import br.com.conquer.marcus.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("conquer/user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

	private final UserServiceImpl userService;

	@GetMapping
	public ResponseEntity<Page<UserDTO>> PageUser(
			@PageableDefault(page = 0, sort = {"name"}) Pageable pageable) {
		return ResponseEntity.ok(userService.PageUser(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findUserById(@PathVariable Long id) {
		return new ResponseEntity(userService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO userDTO) {
		return new ResponseEntity(userService.create(userDTO), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<UserDTO> updateUser(@RequestBody @Valid UserDTO userDTO, @PathVariable Long id) {
		return new ResponseEntity(userService.updateUser(userDTO, id), HttpStatus.OK);
	}

	@DeleteMapping("delete/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
}
