package com.github.lcdaponte.desafiocasadocodigo.aplicacao.validators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = {EntityExistsValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface EntityExists {
	
	String message() default "{com.github.lcdaponte.beanvalidation.entityexists}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	String fieldName();
	
	Class<?> domainClass();

}
