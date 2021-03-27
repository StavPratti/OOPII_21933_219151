package totravel;

import java.io.IOException;
import java.net.MalformedURLException;
//import java.net.URL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;

//import weather.OpenWeatherMap;


public abstract class Traveller {
	
	private String city;
	private String country;
	private double[] currently_geodestic_vector=new double[2];

	public Traveller(String city,String country) {
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
	
	//κριτήρια που ενδιαφέρουνε τον traveller
	public void FavoriteCityTerms() {
	  int[] rating_vector=new int [] {2, 5, 7, 3, 8, 9, 3, 6, 9, 4};
	  }
	
	
    //συντεταγμένες του traveller
	
	  public void CurrentlyCityLanLot() {
		currently_geodestic_vector[0]=37.9795;
		currently_geodestic_vector[1]=23.7162;
		//System.out.println("lat:"+currently_geodestic_vector[0]+"\tlon"+currently_geodestic_vector[1]);
	}

	
	//public abstract int calculate_similarity();
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
		
		//Traveller trav1=new Traveller("athens", "gr");
		//trav1.CurrentlyCityLanLot();
		//System.out.println("lat: "+trav1.currently_geodestic_vector[0]+"\tlon: "+trav1.currently_geodestic_vector[1]);
	}
	
    public double getCurGeodestic_vector(int index) {
		
		return currently_geodestic_vector[index];
	}

	public void setCurGeodestic_vector(double[] currently_geodestic_vector) {
		this.currently_geodestic_vector = currently_geodestic_vector;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	

}