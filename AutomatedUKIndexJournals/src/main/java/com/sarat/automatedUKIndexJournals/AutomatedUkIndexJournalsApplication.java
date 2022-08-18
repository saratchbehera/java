package com.sarat.automatedUKIndexJournals;

import com.sarat.automatedUKIndexJournals.fileUpload.property.IndexFileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(IndexFileStorageProperties.class)
public class AutomatedUkIndexJournalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomatedUkIndexJournalsApplication.class, args);
	}
}
