package br.com.locadoraferraz.annotation;



import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JsonFormat;

@JacksonAnnotationsInside
@Retention(RUNTIME)
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
public @interface JsonBRDataFormat {

}
