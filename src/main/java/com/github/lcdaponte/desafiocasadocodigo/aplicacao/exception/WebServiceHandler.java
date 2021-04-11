package com.github.lcdaponte.desafiocasadocodigo.aplicacao.exception;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WebServiceHandler {
	
	 @Autowired
	 private MessageSource messageSource;
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ValidationErrorsResponse handleValidationError(MethodArgumentNotValidException exception) {
		List<ObjectError> globalErrors = exception.getBindingResult().getGlobalErrors();
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		
		return buildValidationErrors(globalErrors,fieldErrors);
		
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public NoBodyResponse handleValidationError(HttpMessageNotReadableException exception) {
		return new NoBodyResponse("O body da requisição é obrigatório e não foi envidado");
	}
	
	
	
	
	
	private ValidationErrorsResponse buildValidationErrors(List<ObjectError> globalErrors,
			List<FieldError> fieldErrors) {
		ValidationErrorsResponse validationErrors = new ValidationErrorsResponse();
    	
    	globalErrors.forEach(error -> validationErrors.addError(getErrorMessage(error)));
    	
    	fieldErrors.forEach(error -> {
    		String errorMessage = getErrorMessage(error);
    		validationErrors.addFieldError(error.getField(), errorMessage);
    	});
		return validationErrors;
	}
	
	private String getErrorMessage(ObjectError error) {
        return messageSource.getMessage(error, LocaleContextHolder.getLocale());
    }

}
