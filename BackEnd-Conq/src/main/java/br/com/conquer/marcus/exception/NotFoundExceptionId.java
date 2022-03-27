package br.com.conquer.marcus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExceptionId extends Exception{

	public NotFoundExceptionId(Long id){
		super(String.format("esse %s não existe no sistema", id));
	}
}
