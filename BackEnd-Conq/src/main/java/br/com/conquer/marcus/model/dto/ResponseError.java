package br.com.conquer.marcus.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true) 
public class ResponseError {

    private String details;
}