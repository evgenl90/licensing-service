package com.optimagrowth.license;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class LicenseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LicenseServiceApplication.class, args);
	}


	/*Интернационализация – важное требование, позволяющее приложению адаптироваться к различным языкам.
	 Основная цель интернационализации – организовать в приложении возможность возвращать контент в
	 разных форматах и на разных языках.*/

	//Устанавливает локаль US как локаль по умолчанию
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource =
				new ResourceBundleMessageSource();

		//Не генерирует ошибку, если сообщение не найдено, а возвращает код сообщения вместо этого
		messageSource.setUseCodeAsDefaultMessage(true);

		//Задает базовое имя файлов с переводами сообщений на разные языки
		messageSource.setBasenames("messages");
		return messageSource;
	}
}
