package totravel;

import java.io.IOException;
import java.net.MalformedURLException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import exceptions.WikipediaNoArcticleException;


 public abstract class Traveller implements Comparable<Traveller> {
	
	private String city;
	private String country;
	private double[] currently_geodestic_vector=new double[2];
	private int[] rating_vector=new int [10];
	protected double similarity;
    private String name;
    private long timestamp;
	private City visit;
	



	//�������������
	public Traveller(String city,String country) {
		this.similarity=0;
		this.name="Takis";//������ ��� �� ����� ��� �� ������ ���� freeticket
		this.city=city;	
		this.country=country;
		this.rating_vector=new int[] {0,0,10,0,0,10,8,0,0,1};
		this.currently_geodestic_vector=new double[] {37.9795,23.7162};
		this.timestamp=0;
	}
	
	//method that checks for doublecates and sorts travellers by their timestamp
	public static ArrayList<Traveller> travellersSortingByTimestamp(ArrayList<Traveller> travellers)  {
		ArrayList<Traveller> checkedAndSortedTravellers=new ArrayList<Traveller>();
		
		Collections.sort(travellers);
		int timesThatGotIntoTheLoop=0;
		checkedAndSortedTravellers.add(travellers.get(0));
		for(int i=1;i<travellers.size();i++) {
			if(!(checkedAndSortedTravellers.contains(travellers.get(i)))) {
				checkedAndSortedTravellers.add(travellers.get(i));
			}
		}
		
		/*for(int i=0;i<travellers.size();i++) {//��� �� �� �� ���� �������������� ����������
			System.out.println(travellers.get(i).getName());
			System.out.println(travellers.get(i).getTimestamp());
		}
		for(int i=0;i<checkedAndSortedTravellers.size();i++) {//��� �� �� �� ���� �������������� ����������
			System.out.println(checkedAndSortedTravellers.get(i).getName());
			System.out.println(checkedAndSortedTravellers.get(i).getTimestamp());
		}*/
		
		return checkedAndSortedTravellers;
	}
	
	 @Override
	  public int compareTo(Traveller traveller){
		 if(this.timestamp==traveller.timestamp)  
			 return 0;  
			 else if(this.timestamp>traveller.timestamp)  
			 return 1;  
			 else  
			 return -1;  
	  }
	 
	 @Override
	    public boolean equals(Object traveller) {
	  
	        // If the object is compared with itself then return true  
	        if (traveller == this) {
	            return true;
	        }
	  
	        // typecast o to Traveller so that we can compare them by name 
	        Traveller c = (Traveller) traveller;
	      
	        if(c.name==this.name) {
	        	return true;
	        }else {
	        	return false;
	        }
	    }
	


	/**Retrieves weather information, geotag (lan, lon) and a Wikipedia article for a given city.
	* @param city The Wikipedia article and OpenWeatherMap city. 
	* @param country The country initials (i.e. gr, it, de).
	* @param appid Your API key of the OpenWeatherMap.
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException */
	

    abstract double calculate_similarity(City object); //������
    

    protected double SimilarityGeodesticVector(double distance) {
    	int maxdist=15317;
    	
		return (Math.log(2/(2-distance/maxdist)) / Math.log(2));	
    }
	
	public City CompareCities(ArrayList<City> cities) throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
		
		
		Date date =new Date();
		long timestampTemp=date.getTime();
		if(timestamp==0 || timestamp>timestampTemp) {
		   timestamp=timestampTemp;
		}
	
		
		
		double min=-1.2;
		City bestCity = null;
		for(int i=0;i<cities.size();i++) {
			double similarity=calculate_similarity(cities.get(i)); //����������� ��� ����������
			if(similarity>min) {
				bestCity=cities.get(i);
			}
		}
		setVisit(bestCity);
		return bestCity;
	}
	

	
	public ArrayList<City> CompareCities(ArrayList<City> cities, int integer) {
		
		Date date =new Date();
		long timestampTemp=date.getTime();
		if(timestamp==0 || timestamp>timestampTemp) {
		   timestamp=timestampTemp;
		}
		
		
		//������� �� similarity
		ArrayList<Double> cities_sim = new ArrayList<Double>();//���� similarity �� arraylist		
		for(int i=0;i<cities.size();i++) {
			cities_sim.add(calculate_similarity(cities.get(i)));
		}
		 

		for(int i=0; i < (cities_sim.size()-1); i++){  //sorting
             for(int j=0; j < (cities_sim.size()-i-1); j++){ 
            	 if(cities_sim.get(j) < cities_sim.get(j+1)){  
                    //swap elements 
            		Collections.swap(cities_sim, j, j+1);  
	           	    Collections.swap(cities, j, j+1);
	             }  
             }  
	    }     
        ArrayList<City> selectedCities= new ArrayList<>();    
		for(int i = 1; i < integer; i++) { //���� �� ��� ArrayList ����� ��� ����� ����� ��� �������
		   selectedCities.add(cities.get(i));
		}
		return selectedCities;
	}
	

    //freeticket
    public static Traveller freeticket(ArrayList<Traveller> trav) throws JsonParseException, JsonMappingException, MalformedURLException, IOException, WikipediaNoArcticleException{
    	Traveller Winner=trav.get(0);
    	City city=new City("Rome","it"); //���� ��������� ��� ����
    	city.CityLatLon();
    	city.CityTerms();
    	for(int i=1;i<trav.size();i++) { //����� �� ���
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
	
		public double getSimilarity() {
		return similarity;
	}


	public void setSimilarity(double similarity) {
		this.similarity = similarity;
	}


	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	 public long getTimestamp() {
			return timestamp;
		}




		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
		}



	
	public City getVisit() {
		return visit;
	}




	public void setVisit(City visit) {
		this.visit = visit;
	}

}
 