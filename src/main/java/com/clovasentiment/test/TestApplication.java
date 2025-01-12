package com.clovasentiment.test;

import com.clovasentiment.test.apitest.entity.DeskEntity;
import com.clovasentiment.test.apitest.repository.DeskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);

	String a = "a";
		System.out.println("a: " +  a);


	}

	@Bean
	public CommandLineRunner run(DeskRepository deskRepository) {
		return args -> {
			// 데이터 저장
			deskRepository.save(new DeskEntity("Mina"));
			deskRepository.save(new DeskEntity("John Doe"));

			// 저장된 데이터 출력
			deskRepository.findAll().forEach(desk ->
					System.out.println("DeskEntity: " + desk.getMemberName())
			);
		};

	}



}






