package br.com.zup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.zup.entity.Poi;
import br.com.zup.repository.PoiRepository;

@SpringBootApplication
public class PoiApplication implements CommandLineRunner {
	
	@Autowired
	private PoiRepository poiRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PoiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Poi p1 = new Poi(null, "Lanchonete",27, 12);
		Poi p2 = new Poi(null, "Posto", 31, 18);
		Poi p3 = new Poi(null, "Joalheria", 15, 12);
		Poi p4 = new Poi(null, "Floricultura", 19, 21);
		Poi p5 = new Poi(null, "Pub", 12, 8);
		Poi p6 = new Poi(null, "Supermercado", 23, 6);
		Poi p7 = new Poi(null, "Churrascaria", 28, 2);
		
		List<Poi> listPois = new ArrayList<>();
		
		listPois.add(p1);
		listPois.add(p2);
		listPois.add(p3);
		listPois.add(p4);
		listPois.add(p5);
		listPois.add(p6);
		listPois.add(p7);
		
		poiRepository.save(listPois);
	}
}
