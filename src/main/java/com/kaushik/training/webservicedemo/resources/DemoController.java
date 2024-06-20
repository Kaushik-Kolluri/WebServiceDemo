package com.kaushik.training.webservicedemo.resources;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	//Strategy interface which supports i18n for messages.
	private MessageSource messageSource;
	
	public DemoController(MessageSource messageSource) {
		
		this.messageSource = messageSource;
	}
	
	@GetMapping("/i18ndemo")
	public String getSampleMessage() {
		
		Locale locale = LocaleContextHolder.getLocale();
		
		return messageSource.getMessage("good.morning.message", null, "Default Message",
				locale);
		
		//return "Hello World";
	}

}
