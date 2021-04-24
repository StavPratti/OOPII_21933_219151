import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import exceptions.WikipediaNoArcticleException;
import totravel.City;
import totravel.ElderTraveller;
import totravel.MiddleTraveller;
import totravel.Traveller;
import static totravel.Traveller.*;
import totravel.YoungTraveller;

public class OpenData {
	public static void main(String[] args) throws IOException, WikipediaNoArcticleException, InterruptedException {
		
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		
		String cityname="nrei";//βάζω λάθος όνομα πόλης ωστε να πεταχτει εξαίρεση και να βάλω ονομσ
		                        //Rome
		
       //map apo cities
		Map<String, City> mapOfCities = new HashMap<String, City>();
		
		
		 //δήλωση πόλεων
		City city1;
		City city2;
		City city3;
		City city4;
		City city5;
		
		while (true) {		
			try {		
	             city1=new City(cityname,"it");//λάθος όνομα για να πεταχτει το exception
	             if(!mapOfCities.containsKey(city1)) {
				 city1.CityTerms();//δημιουργω πινακα με τα μετρημενα ορισματα
			     city1.CityLatLon();//δημιουργώ πινακα με τις συντεταγμενες
			     mapOfCities.put(city1.getCity(),city1); //Rome
	             }
	             
	             city2=new City("Corfu","gr");//2η πόλη
	             if(!mapOfCities.containsKey(city2)) {
				 city2.CityTerms();
				 city2.CityLatLon();
				 mapOfCities.put(city2.getCity(),city2); //Corfu
	             }
	             
				 city3=new City("Berlin","de");//3η πόλη
				 if(!mapOfCities.containsKey(city3)) {
		     	 city3.CityTerms();
				 city3.CityLatLon();
				 mapOfCities.put(city3.getCity(),city3); //Berlin
				 }
				 
				 city4=new City("Dublin","ger");//3η πόλη
				 if(!mapOfCities.containsKey(city4)) {
		     	 city4.CityTerms();
				 city4.CityLatLon();
				 mapOfCities.put(city4.getCity(),city4); //Dublin
				 }
				 
				 city5=new City("Dublin","ger");
				 if(!mapOfCities.containsKey(city5)) {
		     	 city4.CityTerms();
				 city4.CityLatLon();
				 mapOfCities.put(city5.getCity(),city5); //den xanabazei tin idia poli mesa
				 }

			     break;
			   
			} catch (WikipediaNoArcticleException e) {
				System.out.println(e.getMessage());
				System.out.print("Type a correct city name: ");
				cityname = stdin.readLine();
				continue;
		}
		}
		
		/*for (String key: mapOfCities.keySet()) {
            System.out.println(key);
        } *///ektipwnei ta keys
			
		
			//φτιαχνω arraylist με τις πόλεις
			
	    ArrayList<City> cities=new ArrayList<City>(); 
	    cities.add(city1); //Rome
	    cities.add(city2); //Corfu
	    cities.add(city3); //Berlin
	    cities.add(city4); //Dublin
		
	    
	    
	    ArrayList<Traveller> travellers = new ArrayList<>(); //arraylist me tous travellers
	    //το ιδιο μπορω να το κανω και με εναν middle ,elder
		YoungTraveller youngTravellerExample=new YoungTraveller("Athens","gr"); //φτιαχνω έναν νέο ταξιδιώτη
		travellers.add(youngTravellerExample);//ton bazw kai sto collection
		
		//καλώ την comparecities για να επιστρέψει την πιο ιδανική πόλη
		City bestCity=youngTravellerExample.CompareCities(cities); 
		System.out.println("The best city for the traveller "+""+youngTravellerExample.getName()+ " "+ "is : "+bestCity.getCity());//τυπώνω την πιο ιδανικη
		
		//καλώ την comparecities για να επιστρέψει τις πιο ιδανικες πόλεις
		ArrayList<City> city =youngTravellerExample.CompareCities(cities, 4);
		for(int i=0;i<city.size();i++) {
			System.out.println("The"+" "+(i+2)+" "+"best city is:"+city.get(i).getCity()); //τυπώνω με την δεύτερη compare cities
		}
		
		//Εστω οτι ο ιδιος ταξιδιωτης θελει να βαλει διαφορετικα κρητηρια
		YoungTraveller youngTravellerExampleAgain=new YoungTraveller("Athens","gr");
		youngTravellerExampleAgain.setRating_vector(new int[] {6,8,0,0,0,0,0,0,0,0}); //βαζω άλλα κρητήρια
		City bestCityAgain =youngTravellerExampleAgain.CompareCities(cities); 
		System.out.println("The best city for the traveller "+""+youngTravellerExampleAgain.getName()+ " "+ "is : "+bestCityAgain.getCity());//τυπώνω την πιο ιδανικη
		travellers.add(youngTravellerExampleAgain);//τον προσθετω στο κολλεκτιον
		
		
		//tr.CurrentlyCityLatLon();
		//tr.FavoriteCityTerms();
	    //System.out.println(tr.calculate_similarity(city1)); //similarity athens-rome
	    //System.out.println(tr.calculate_similarity(city2)); //similarity athens-corfu
	

		
		
		
		
		
		//free ticket
		//φτιάχνω travellers
		YoungTraveller young1=new YoungTraveller("Athens","gr");
		MiddleTraveller middle1=new MiddleTraveller("Athens","gr");
		ElderTraveller elder1=new ElderTraveller("Athens","gr");
		YoungTraveller young2=new YoungTraveller("Athens","gr");
		MiddleTraveller middle2=new MiddleTraveller("Berlin","de");
		ElderTraveller elder2=new ElderTraveller("Athens","gr");
		YoungTraveller young3=new YoungTraveller("Athens","gr");
		MiddleTraveller middle3=new MiddleTraveller("Athens","gr");
		ElderTraveller elder3=new ElderTraveller("Berlin","de");
		
		
		//αλλάζω τα default vectors 
		elder1.setRating_vector(new int[] {2,9,9,0,3,1,0,0,0,0});
		middle1.setRating_vector(new int[] {0,4,2,7,1,0,0,0,9,1});
		young2.setRating_vector(new int[] {2,1,5,6,7,8,9,7,7,7,});
		elder2.setRating_vector(new int[] {0,0,0,0,0,0,0,0,0,0});
		middle2.setRating_vector(new int[] {1,0,0,0,0,0,0,0,0,0});
		young3.setRating_vector(new int[] {9,9,9,9,9,9,9,9,9,9});
		elder3.setRating_vector(new int[] {1,0,9,0,0,1,0,0,0,0});
		middle3.setRating_vector(new int[] {0,1,2,9,9,4,0,1,9,7});
		
		
		//αλλαζω τα λατ λον απο καποιους για να μην ειναι όλοι απο αθήνα
		middle2.setCurGeodestic_vector(new double[] {52.5244,13.4105});
		elder3.setCurGeodestic_vector(new double[] {52.5244,13.4105});
		
		//αλλάζω τα ονόματα τους
		young1.setName("Olga");
		middle1.setName("Nikoleta");
		elder1.setName("Stavroula");
		middle2.setName("Dimitris");
		elder2.setName("Sia");
		middle3.setName("Peggy");
		elder3.setName("Stefania");
		young2.setName("Chrisa");
		young3.setName("Maria");
		
		
		
		travellers.add(elder1);
		travellers.add(young1);
		travellers.add(middle1);
		travellers.add(elder2);
		travellers.add(young2);
		travellers.add(middle2);
		travellers.add(elder3);
		travellers.add(young3);
		travellers.add(middle3);
		
		
			
	    
		//kanw ena comparecities gia olous wste na exoun kanie toulaxiston mia anazitisi gia na exoun timestamp
		for(int i=0;i<travellers.size();i++) { //etsi oloi tha exoun kanei mia anazitisi
			travellers.get(i).CompareCities(cities);
			TimeUnit.SECONDS.sleep(1);//ωστε να υπαρχει εμφανής διαφορα στα δευτερολεπτα 
		}
		
		
	    //sort travellers by timestamp
	    travellersSortingByTimestamp(travellers);//επιστρεφει ενα Array ταξινομημενο σε αυξουσα σειρα 
		
	    
		System.out.println("The winner of the free ticket is : "+freeticket(travellers).getName());//τυπώνω τον νικητή του εισητηρίου
		 
		
		}
	}


