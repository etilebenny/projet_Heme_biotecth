package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	private String filepath =("symptoms.txt");
	private BufferedReader reader;
	
	public AnalyticsCounter()
	{
		this.filepath = filepath;
	}
	
	/* Cette fonction ou Methode sert à afficher et compter le nombre des symptoms qui se repetent 
	   elle fait appelle à la fonction GetSymptoms de la classe ReadSymptomDataFromFile et renvoie
	    une liste des symptoms et nombre de fois qu'ils se repetent*/
	
	public Map<String,Integer> CountSymptoms()
	{
		ReadSymptomDataFromFile listSymptom = new ReadSymptomDataFromFile(filepath);
		List<String> CountSymp = new ArrayList<>();
		Map<String,Integer> mapSymptom = new HashMap<String,Integer>();
		CountSymp = listSymptom.GetSymptoms();
		int i =0;
		for(i=0;i<CountSymp.size();i++)
		{
			if(mapSymptom.containsKey(CountSymp.get(i)))
			{
				int value = mapSymptom.get(CountSymp.get(i))+1;
				mapSymptom.put(CountSymp.get(i), value);
			}
			else
			{
				mapSymptom.put(CountSymp.get(i),1);
			}
		}
		
		return mapSymptom;
		
	}
	/* Cette fonction recupere le resultat de la fonction CountSymptoms et renvoie une liste des symptoms ordonner
	 * par ordre alphabetique ********/
	
	public Map<String,Integer> OrderSymptoms()
	{
		AnalyticsCounter ana = new AnalyticsCounter();
		List<String> CountSymp = new ArrayList<>();
		Map<String,Integer> orderSymp = new HashMap<String,Integer>();
		orderSymp = ana.CountSymptoms();
		TreeMap<String, Integer> mapClasse = new TreeMap<String, Integer>();
		mapClasse.putAll(orderSymp);
		
		return mapClasse;
			
	}
	/* pour finir cette fonction fait appelle a la fonction orderSymptoms puis ecrit la liste de resultat de la liste ordonner 
	 * par ordre alphabetique dans le result.out ******/
	public FileWriter WriterSymptoms() throws IOException
	{
		AnalyticsCounter ana = new AnalyticsCounter();
		TreeMap<String, Integer> mapClasse = new TreeMap<String, Integer>();
		FileWriter writer = new FileWriter("result.out");
		int i =0;
		mapClasse = (TreeMap<String, Integer>) ana.OrderSymptoms();
		 for(Map.Entry<String, Integer> entry : mapClasse.entrySet()) {
			 
			 writer.write((entry.getKey()+": " + entry.getValue() + "\n"));		
		 }
		 writer.close();
		 
		return  writer;
		
	}
}
