package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class principale {

	public static void main(String[] args) throws IOException {
		
		ReadSymptomDataFromFile counter = new ReadSymptomDataFromFile("symptoms.txt");
		AnalyticsCounter count = new AnalyticsCounter();
		List<String> mylist = new ArrayList<>();
		Map<String,Integer> mymap = new HashMap<String,Integer>();
		Map<String,Integer> map = new HashMap<String,Integer>();
		FileWriter writer = new FileWriter ("result.out");
		int i =0;
		mylist = counter.GetSymptoms();
		System.out.println("------------------------------");
		mymap = count.CountSymptoms();
		for(i=0;i<mylist.size();i++) //pour afficher la liste de tous les symptoms du fichier symptoms.txt
		{
		System.out.println(mylist.get(i));
		}
		System.out.println("------------------------------");
		
		for(Map.Entry mp : mymap.entrySet()) // pour faire la lecture de notre map qui  affichera le symptoms et le nbre de fois qu'ils se repetent 
		{
			System.out.println(mp.getKey()+ " : "+mp.getValue());
		}
		System.out.println("-------- Alphabetical order -------------");
		mymap = count.OrderSymptoms(); // pour afficher la liste ordonner des symptoms par ordre alphabetique
		for(Map.Entry<String, Integer> entry : mymap.entrySet()) 
		{
			 System.out.println((entry.getKey()+": " + entry.getValue() + "\n"));
		}
		writer = count.WriterSymptoms();
		}
	}

