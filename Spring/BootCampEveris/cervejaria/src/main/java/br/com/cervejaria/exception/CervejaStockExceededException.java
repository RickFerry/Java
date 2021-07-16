package br.com.cervejaria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CervejaStockExceededException extends Exception {
	private static final long serialVersionUID = 1L;

	public CervejaStockExceededException(Long id, int quantityToIncrement) {
		super(String.format("Beers with %s ID to increment informed exceeds the max stock capacity: %s", id,
				quantityToIncrement));
	}
}
