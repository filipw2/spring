package com.itemtracker.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itemtracker.model.dao.Cena;
import com.itemtracker.model.dao.CenaRepository;
import com.itemtracker.model.dao.Dane;
import com.itemtracker.model.dao.DaneRepository;
import com.itemtracker.model.dao.Kopalnia;
import com.itemtracker.model.dao.KopalniaRepository;
import com.itemtracker.model.dao.Sortyment;
import com.itemtracker.model.dao.SortymentRepository;
import com.itemtracker.service.CenaService;
@Service
public class Parser {
	
	@Autowired
	CenaRepository cenaRepository;
	@Autowired
	KopalniaRepository kopalniaRepository;
	@Autowired
	DaneRepository daneRepository;
	@Autowired
	SortymentRepository sortymentRepository;
	@Autowired
	CenaService cenaService;
	public Parser() {}
	
	//TODO - ref
	//check data changes
	//update price
	public void parse() {
		try {
			List<Cena> ceny= new ArrayList<>();
			
			Elements elements = Jsoup.connect("http://gornictwo.wnp.pl/notowania/ceny_wegla_pgg/").header("Accept-Encoding", "gzip, deflate")
			        .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0")
			        .maxBodySize(0)
			        .timeout(600000)
			        .get().select(".table4 > tbody:nth-child(2) > tr");
			
			for(Element d:elements) {
				Cena cena = new Cena();
				Dane dane = new Dane();
				Kopalnia kopalnia = new Kopalnia();
				kopalnia.setName(d.select("td:nth-child(1)").html());
				System.out.println(kopalnia.getName());
				Kopalnia k= kopalniaRepository.getKopalnia(kopalnia.getName());
				if(k==null)
					kopalniaRepository.save(kopalnia);
				else
					kopalnia=k;
				System.out.println(kopalnia.getName());
				Sortyment sortyment = new Sortyment();
				sortyment.setName(d.select("td:nth-child(2)").html());
				
				Sortyment s= sortymentRepository.getSortyment(sortyment.getName());
				if(s==null)
					sortymentRepository.save(sortyment);
				else
					sortyment=s;
				
				dane.setKopalnia_id(kopalnia);
				dane.setSortyment_id(sortyment);
				dane.setKlasa(d.select("td:nth-child(3)").html());
				dane.setWymiar_dolny(Double.valueOf(d.select("td:nth-child(4)").html()));
				dane.setWymiar_gorny(Double.valueOf(d.select("td:nth-child(5)").html()));
				dane.setPopiol(Double.valueOf(d.select("td:nth-child(6)").html()));
				dane.setSiarka(Double.valueOf(d.select("td:nth-child(7)").html()));
				dane.setSpiekalnosc_od(Double.valueOf(d.select("td:nth-child(8)").html()));
				dane.setSpiekalnosc_do(Double.valueOf(d.select("td:nth-child(9)").html()));
				
				cena.setDane_id(dane);
				cena.setCena_bez_akcyzy(Double.valueOf(d.select("td:nth-child(10)").html()));
				cena.setCena_z_akcyza(Double.valueOf(d.select("td:nth-child(11)").html()));
				
				ceny.add(cena);
				
			}
			cenaService.insertCenas(ceny);
			System.out.println(ceny.size());
			System.out.println(cenaRepository);
		//	cenaRepository.saveAll(ceny);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IllegalArgumentException ei) {
			ei.printStackTrace();
		}
	}
	
}
