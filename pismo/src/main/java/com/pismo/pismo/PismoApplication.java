package com.pismo.pismo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({"com.pismo.pismo.configuration", "com.pismo.pismo"})
public class PismoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PismoApplication.class, args);
	}

}
