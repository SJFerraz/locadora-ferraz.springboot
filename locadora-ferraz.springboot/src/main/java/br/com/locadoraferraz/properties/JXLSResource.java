package br.com.locadoraferraz.properties;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JXLSResource {
      
	@Value("${application.name}")
	public String appName;
	
	@PostConstruct
	public void print() {
		System.out.println("---"+appName);
	}
}
