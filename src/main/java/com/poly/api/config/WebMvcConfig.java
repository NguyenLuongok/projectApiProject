package com.poly.api.config;

import com.poly.api.repository.repositoryImpl.DesicionRepositoryImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Tong Duy Hai on 05/24/2020.
 * @created 24/05/2020
 * @project PolyProjectApi
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public DesicionRepositoryImpl getDesicionRepository(){
        return new DesicionRepositoryImpl();
    }
}
