package it.unicam.ids.garbageCollectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class GarbageCollectorsBackendApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GarbageCollectorsBackendApplication.class, args);
	}

}

