package com.guendouz.yweather.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.guendouz.yweather.YWeather;
import com.guendouz.yweather.model.Units;
import com.guendouz.yweather.model.WeatherInfo;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*YWeather weather = new YWeather();
		WeatherInfo info = weather.getWeatherForWOEID("2442047", Units.TEMP_C);
		System.err.println(info.getItem().getForecastOne().getDay());
		info = weather.getWeatherForPlace("Lile", Units.TEMP_C);
		System.out.println(info.getItem().getCondtition().getIconUrl());*/
		 
		/*YWeather weather = new YWeather();
        WeatherInfo info = weather.getWeatherForPlace("Paris");
        // afficher la vitesse du vent
        System.out.println(info.getWind().getSpeed());
        System.out.println(info.getAtmosphere().toString());
        System.out.println(info.getUnits().toString());*/
        
        YWeather weather = new YWeather();
        /*WeatherInfo info = weather.getWeatherForPlace("Paris", Units.TEMP_C);
        System.out.println(info.getItem().getForecastOne().toString());*/
        
        try{
	        	FileWriter fw = new FileWriter("voldujour",false);
	        	BufferedWriter output = new BufferedWriter(fw);
	        	//On se connecte au site et on charge le document html
	        	Document doc = Jsoup.connect("http://www.strasbourg.aeroport.fr/destinations/vols").get();
	        	//On récupère dans ce document la premiere balise ayant comme nom h1 et pour attribut class="title"
	        	int i = 1;
	        	for(i=1;i<150;i+=5){
	        	Element element= doc.select("td .center").get(i);
	        	String element1 =  element.text();
	        	output.write(element1);
	        	System.out.println(element1);
	        	output.write("--");
	        	String ttt = element1;
	        	//WeatherInfo info = weather.getWeatherForPlace(ttt, Units.TEMP_C);
	        	//output.write(info.getItem().getForecastOne().toString());
	        	//output.write(info.getItem().getCondtition().toString());
	        	output.write("/");
	        	output.flush();
	        	}
	        	output.close();
        	 }
        	 catch(MalformedURLException e){
        	 System.out.println(e);
        	 }
        	 catch(IOException e){
        	 System.out.println(e);
        	 }
        	catch(NumberFormatException ex){
        		System.out.println(ex);
        	}
	}

}
