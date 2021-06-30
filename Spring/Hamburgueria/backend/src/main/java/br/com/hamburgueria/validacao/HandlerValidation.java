package br.com.hamburgueria.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.hamburgueria.dto.FormErrorDto;

@RestControllerAdvice
public class HandlerValidation {

	@Autowired
	private MessageSource msgSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<FormErrorDto> handler(MethodArgumentNotValidException exception) {

		List<FormErrorDto> dto = new ArrayList<>();

		List<FieldError> erros = exception.getBindingResult().getFieldErrors();
		erros.forEach(e -> {
			String mensagem = msgSource.getMessage(e, LocaleContextHolder.getLocale());
			FormErrorDto fed = new FormErrorDto(e.getField(), mensagem);
			dto.add(fed);
		});
		return dto;
	}
}