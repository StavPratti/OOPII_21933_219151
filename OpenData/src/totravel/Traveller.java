package totravel;

import java.io.IOException;
import java.net.MalformedURLException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public abstract class Traveller {
	
	private String city;
	private String country;
	private double[] currently_geodestic_vector=new double[2];
	private int[] rating_vector=new int [10];

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
	   rating_vector[0]= 2;
	   rating_vector[1]=4;
	   rating_vector[2]=10;
	   rating_vector[3]=5;
	   rating_vector[4]=3;
	   rating_vector[5]=10;
	   rating_vector[6]=8;
	   rating_vector[7]=0;
	   rating_vector[8]=0;
	   rating_vector[9]=1;  
	  }
	
	
      //συντεταγμένες του traveller
	  public void CurrentlyCityLanLot() {
		currently_geodestic_vector[0]=37.9795;
		currently_geodestic_vector[1]=23.7162;
	}

	
    abstract double calculate_similarity(City object);
    

    protected double SimilarityGeodesticVector(double distance) {
    	int maxdist=15317;
		return Math.log(2/(2-distance/maxdist));	
    }
	
	
    public double getCurGeodestic_vector(int index) {
		return currently_geodestic_vector[index];
	}
    
    public double getRatingVector(int index) {	
  		return rating_vector[index];
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