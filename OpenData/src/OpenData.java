import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import exceptions.WikipediaNoArcticleException;
import totravel.City;
import totravel.ElderTraveller;
import totravel.Traveller;
import static totravel.Traveller.*;
import totravel.YoungTraveller;

public class OpenData {
	public static void main(String[] args) throws IOException, WikipediaNoArcticleException {
		//νεος ταξιδιώτης
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String cityname="mhloikl";
		
		
		City city1=new City(cityname,"it");//παρομοια μπορω να φτιαξω και αλλες πολεις
		
		while (true) {		
			try {		
	
				
				city1.CityTerms();//για την συγκεκριμενη πολη φτιαχνει τα τερμσ
			
				//City city2=new City("Corfu","gr");
				//city2.CityTerms();
				//city2.CityLatLon();// θα τα τρεχω εδω ή στην κομπερ σιτις
			   break;
			} catch (WikipediaNoArcticleException e) {
				System.out.println(e.getMessage());
				System.out.print("Type a correct city name: ");
				cityname = stdin.readLine();
				continue;
			}
			
		}
		city1.CityLatLon();//το τατ λοτ, ωστε με γκετερς να μπορω να τα χρησιμοποιησω μετα
		
		
	   // ArrayList<City> cities=new ArrayList<City>();
	   // cities.add(city1);
	   // cities.add(city2);
	    
		
	    
	    
		YoungTraveller tr=new YoungTraveller("Athens","gr");
		//City bestCity=tr.CompareCities(cities);
		//ArrayList<City> city =tr.CompareCities(cities, 3);
		//for(int i=2;i<4;i++) {
		//	System.out.println(city.get(i));
		//}
		//System.out.println(bestCity.getCity());
		//tr.CurrentlyCityLatLon();
		//tr.FavoriteCityTerms();
	//System.out.println(tr.calculate_similarity(city1)); //similarity athens-rome
	//System.out.println(tr.calculate_similarity(city2)); //similarity athens-corfu
		//μεσήλικας ταξιδιώτης
		
		
		
		//γερος ταξιδιώτης
		//ElderTraveller elder=new ElderTraveller("Athens","gr");
		//elder.CurrentlyCityLatLon();
		//elder.FavoriteCityTerms();
//System.out.println(elder.calculate_similarity(city1)); //similarity athens-rome
	
		
		//free ticket
		YoungTraveller young1=new YoungTraveller("Athens","gr");
		ElderTraveller elder1=new ElderTraveller("Athens","gr");
		ArrayList<Traveller> travellers = new ArrayList<>(); 
		travellers.add(elder1);
		elder1.setRating_vector(new int[] {2,9,9,9,3,10,8,9,9,1});
		travellers.add(young1);
		System.out.println(freeticket(travellers));//διευθυνση μνημης
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}