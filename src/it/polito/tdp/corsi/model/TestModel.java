package it.polito.tdp.corsi.model;

import java.util.Map;
import java.util.Map.Entry;

public class TestModel {
	
	public void run() {
		GestoreCorsi model = new GestoreCorsi();
		
		Map<Corso, Integer> mappa = model.getIscrittiCorsi(1);
		
		for(Entry entry : mappa.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}

	public static void main(String[] args) {
		TestModel main = new TestModel();
		main.run();
		
	}

}
