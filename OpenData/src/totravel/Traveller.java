package totravel;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import exceptions.WikipediaNoArcticleException;
import exceptions.WikipediaNoCityException;

 public abstract class Traveller implements Comparable<Traveller> {
	
	private String city;
	private String country;
	private double[] currently_geodestic_vector=new double[2];
	private int[] rating_vector=new int [10];
	protected double similarity;




	public Traveller(String city,String country) {
		this.similarity=0;
		this.city=city;	
		this.country=country;
		this.rating_vector=new int[] {0,0,10,0,0,10,8,0,0,1};
		this.currently_geodestic_vector=new double[] {37.9795,23.7162};
	}
	

	public double getSimilarity() {
		return similarity;
	}


	public void setSimilarity(double similarity) {
		this.similarity = similarity;
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
	/*public void FavoriteCityTerms() {
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
	  }*/
	
	
      //συντεταγμένες του traveller
	/*  public void CurrentlyCityLatLon() {
		currently_geodestic_vector[0]=37.9795;
		currently_geodestic_vector[1]=23.7162;
	}*/

	
    abstract double calculate_similarity(City object);
    

    protected double SimilarityGeodesticVector(double distance) {
    	int maxdist=15317;
    	
		return (Math.log(2/(2-distance/maxdist)) / Math.log(2));	
    }
	
	public City CompareCities(ArrayList<City> cities) throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
		double min=-1.2;
		City bestCity = null;
		for(int i=0;i<cities.size();i++) {
			//cities.get(i).CityLatLon();//ωστε να υπολογιστει το lat,lon
			//cities.get(i).CityTerms();//countwords για την πολη
			double similarity=calculate_similarity(cities.get(i)); //υπολογισμος του σιμιλαριτι
			if(similarity>min) {
				bestCity=cities.get(i);
			}
		}
		return bestCity;
	}
	

	
public ArrayList<City> CompareCities(ArrayList<City> cities, int integer) {
		
		ArrayList<Double> cities_sim = new ArrayList<Double>();//σωζω similarity σε arraylist
				
		for(int i=0;i<cities.size();i++) {
			cities_sim.add(calculate_similarity(cities.get(i)));
		}
		
		Map<Double, City> map = new HashMap<Double, City>();//φτιαχνω map που θα σωζει με σχεση key/value την similarity και τι ςities
		for(int i = 0; i < cities_sim.size(); i++) {
		  map.put(cities_sim.get(i), cities.get(i));   
		}


		Collections.sort(cities_sim);//κανω sort την arraylist ομοιοτητας με το comparable interface
		cities.clear();//καθαριζω την cities rraylist

		for(int i = 0; i < map.size(); i++) {//φτιαχνω ξανα την cities arraylist συμφωνα με την σειρα στην arraylist ομοιοτητας 
		  cities.add(map.get(cities_sim.get(i)));//και χρησιμοποιοντας την key/value σχεση του map
		}

		cities.remove(1);//αφαιρω την 1η πολη
		return cities;
	}
	
	
	
	
	
	
    //freeticket
    public static Traveller freeticket(ArrayList<Traveller> trav) throws JsonParseException, JsonMappingException, MalformedURLException, IOException, WikipediaNoArcticleException, WikipediaNoCityException {
    	Traveller Winner=trav.get(0);
    	City city=new City("Rome","it");
    	city.CityLatLon();
    	city.CityTerms();
    	for(int i=1;i<trav.size();i++) {
    		if(trav.get(i).calculate_similarity(city)>Winner.calculate_similarity(city)) {
    			Winner =trav.get(i);
    		}
    	}
		return Winner;
    }
    





	


	public void setRating_vector(int[] rating_vector) {
		this.rating_vector = rating_vector;
	}
    public double getCurGeodestic_vector(int index) {
		return currently_geodestic_vector[index];
	}
    
    public int getRatingVector(int index) {	
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




	
	@Override
	public int compareTo(Traveller trav) {
		
			if(this.similarity>trav.similarity) {
				return 1;
			}
			if(this.similarity<trav.similarity) {
				return -1;
			}
			return 0;
		

		
	}


	
	
	

}