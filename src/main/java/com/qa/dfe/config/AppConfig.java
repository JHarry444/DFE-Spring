package com.qa.dfe.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 4th component
public class AppConfig {

	@Bean // tells to make this for me
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
