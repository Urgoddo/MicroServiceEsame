package it.apuliadigital.esame_EnricoDeVittorip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EsameDeVittoripApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsameDeVittoripApplication.class, args);
	}

}
