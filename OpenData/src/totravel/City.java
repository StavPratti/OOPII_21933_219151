package totravel;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import static moreinfo.CountWords.*;
import weather.OpenWeatherMap;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import wikipedia.MediaWiki;

public class City {

	private String city;
	private int[] terms_vector=new int[10];
	private double[] geodestic_vector=new double[2];
	private String country;
	

	public City(String city,String country) {
		this.city=city;	
		this.country=country;
		
	}
	
	/**Retrieves weather information, geotag (lan, lon) and a Wikipedia article for a given city.
	* @param city The Wikipedia article and OpenWeatherMap city. 
	* @param country The country initials (i.e. gr, it, de).
	* @param appid Your API key of the OpenWeatherMap.
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException */ 
	//φτιαχνει τον πίνακα terms_vector
	public void CityTerms() throws JsonParseException, JsonMappingException, MalformedURLException, IOException{
	 
		
     String[] terms_vector_strings=new String[]{"sea","walls","ancient","mountain","brige","museum","squeare","restaurant","view","forest"};;
	 ObjectMapper mapper = new ObjectMapper(); 
	 MediaWiki mediaWiki_obj =  mapper.readValue(new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles="+city+"&format=json&formatversion=2"),MediaWiki.class);
	 for(int i=0;i<terms_vector_strings.length;i++) {
		 int count=countCriterionfCity(mediaWiki_obj.getQuery().getPages().get(0).getExtract(),terms_vector_strings[i]);
		 terms_vector[i]=count;
	  }
	}
	 
	
    //φτιαχνει τον πίνακα geodestic_vector
	public void CityLanLot() throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
		ObjectMapper mapper2=new ObjectMapper();
		//String country="it";
		//double[] geodestic_vector=new double[2];
		String appid="c01b30fa264932378fe076eb38121dbc";
		OpenWeatherMap weather_obj = mapper2.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&APPID="+appid+""), OpenWeatherMap.class);
		geodestic_vector[0]=weather_obj.getCoord().getLat();
		geodestic_vector[1]=weather_obj.getCoord().getLon();
	}
	
	public int getTerms_vector(int index) {
		return terms_vector[index];
	}

	public void setTerms_vector(int[] terms_vector) {
		this.terms_vector = terms_vector;
	}

	public double getGeodestic_vector(int index) {
		
		return geodestic_vector[index];
	}

	public void setGeodestic_vector(double[] geodestic_vector) {
		this.geodestic_vector = geodestic_vector;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
