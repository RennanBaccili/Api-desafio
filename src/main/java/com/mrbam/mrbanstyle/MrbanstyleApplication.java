package com.mrbam.mrbanstyle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients //habilita o feing no projeto
@SpringBootApplication
public class MrbanstyleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MrbanstyleApplication.class, args);
	}

}
