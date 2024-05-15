package net.etfbl.webshop.beans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;

public class StatisticsBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArrayList<String> getAllLines(){
		ArrayList<String> allLines = new ArrayList<>();
		File file = new File("C:\\Users\\AcerAspireE5\\Desktop\\SpringBootApp\\logs.txt");
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(file));
			for(String line; (line = br.readLine()) != null; ) {
				allLines.add(line);
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return allLines;
	}
	
	/*public static void main(String args[]) {
		StatistikaBean s = new StatistikaBean();
		for(String ss:s.getAllLines()) {
			System.out.println(ss);
		}
	}*/

}