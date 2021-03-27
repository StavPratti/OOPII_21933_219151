package totravel;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import weather.OpenWeatherMap;


public abstract class Traveller {
	
	private String city;
	private int[] rating_vector=new int[11];
	private double[] currently_geodestic_vector=new double[2];
	private String country;
	

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
	 // todo 
	 //int[] favorite_terms_vector=new int[10];
	 
	  }
	
	
    //συντεταγμένες του traveller
	public void CurrentlyCityLanLot() throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
		ObjectMapper mapper2=new ObjectMapper();
		//String country="it";
		//double[] geodestic_vector=new double[2];
		//city = "athens";
		//country =  "gr";
		String appid="c01b30fa264932378fe076eb38121dbc";
		OpenWeatherMap weather_obj = mapper2.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&APPID="+appid+""), OpenWeatherMap.class);
		currently_geodestic_vector[0]=weather_obj.getCoord().getLat();
		currently_geodestic_vector[1]=weather_obj.getCoord().getLon();
		//System.out.println("lat:"+geodestic_vector[0]+"\tlon"+geodestic_vector[1]);
	}
	
	// ή πιο απλά:
	/*public void CurrentlyCityLanLot() {
		//double[] currently_geodestic_vector=new double[2];
		city = "athens";
		country =  "gr";
		currently_geodestic_vector[0]=37.9795;
		currently_geodestic_vector[1]=23.7162;
		//System.out.println("lat:"+currently_geodestic_vector[0]+"\tlon"+currently_geodestic_vector[1]);
	}
	*/
	
	public abstract int calculate_similarity();
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
		
		//Traveller trav1=new Traveller("athens", "gr");
		//trav1.CurrentlyCityLanLot();
		//System.out.println("lat: "+trav1.currently_geodestic_vector[0]+"\tlon: "+trav1.currently_geodestic_vector[1]);
	}
	
	
	public int getRating_vector(int index) {
		return rating_vector[index];
	}

	public void setRating_vector(int[] rating_vector) {
		this.rating_vector = rating_vector;
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