import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import exceptions.WikipediaNoArcticleException;
import exceptions.WikipediaNoCityException;
import totravel.City;
import totravel.ElderTraveller;
import totravel.MiddleTraveller;
import totravel.Traveller;
import static totravel.Traveller.*;
import totravel.YoungTraveller;

public class OpenData {
	public static void main(String[] args) throws IOException, WikipediaNoArcticleException, WikipediaNoCityException {
		
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		
		String cityname="Rome";//βάζω λάθος όνομα πόλης
		

		City city1;
		City city2;
		City city3;
		
		while (true) {		
			try {		
	             city1=new City(cityname,"it");//λάθος όνομα για να πεταχτει το exception
				 city1.CityTerms();//δημιουργω πινακα με τα μετρημενα ορισματα
			     city1.CityLatLon();//δημιουργώ πινακα με τις συντεταγμενες
			     
			     city2=new City("Corfu","gr");//2η πόλη
				 city2.CityTerms();
				 city2.CityLatLon();
				 
				 city3=new City("Berlin","de");//3η πόλη
		     	 city3.CityTerms();
				 city3.CityLatLon();
			     break;
			   
			} catch (WikipediaNoArcticleException e) {
				System.out.println(e.getMessage());
				System.out.print("Type a correct city name: ");
				cityname = stdin.readLine();
				continue;
			}catch (WikipediaNoCityException e) {
				System.out.println(e.getMessage());
				System.out.print("Type a real city name: ");
				cityname = stdin.readLine();
				continue;
			}	
		}
		

		
		//φτιαχνω arraylist με τις πόλεις
	    ArrayList<City> cities=new ArrayList<City>();
	    cities.add(city1);
	    cities.add(city2);
	    cities.add(city3);
		
		YoungTraveller tr=new YoungTraveller("Athens","gr"); //φτιαχνω έναν νέο ταξιδιώτη
		City bestCity=tr.CompareCities(cities); //καλώ την comparecities για να επιστρέψει την πιο ιδανική πόλη
		System.out.println("The best city for the traveller is : "+bestCity.getCity());//τυπώνω την πιο ιδανικη
		
		
		ArrayList<City> city =tr.CompareCities(cities, 3);//καλώ την comparecities για να επιστρέψει τις πιο ιδανικες πόλεις
		for(int i=0;i<city.size();i++) {
			System.out.println("The"+" "+(i+2)+" "+"best city is:"+city.get(i).getCity()); //τυπώνω με την δεύτερη compare cities
		}
		
		//tr.CurrentlyCityLatLon();
		//tr.FavoriteCityTerms();
	    //System.out.println(tr.calculate_similarity(city1)); //similarity athens-rome
	    //System.out.println(tr.calculate_similarity(city2)); //similarity athens-corfu
	

		//free ticket
		//φτιάχνω travellers
		YoungTraveller young1=new YoungTraveller("Athens","gr");
		MiddleTraveller middle1=new MiddleTraveller("Athens","gr");
		ElderTraveller elder1=new ElderTraveller("Athens","gr");
		
		
		ArrayList<Traveller> travellers = new ArrayList<>(); 
		travellers.add(elder1);
		travellers.add(young1);
		travellers.add(middle1);
		
		//αλλάζω τα default vectors 
		elder1.setRating_vector(new int[] {2,9,9,0,3,1,0,0,0,0});
		middle1.setRating_vector(new int[] {0,4,2,7,1,0,0,0,9,1});
		
		//αλλάζω τα ονόματα τους
		middle1.setName("Nikoleta");
		elder1.setName("Nikos");
		
		System.out.println("The winner of the free ticket is : "+freeticket(travellers).getName());//τυπώνω τον νικητή του εισητηρίου
		
		
	}

}




