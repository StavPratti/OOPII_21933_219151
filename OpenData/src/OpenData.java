import java.io.IOException;
import totravel.City;

import totravel.YoungTraveller;
/**City description and weather information using OpenData with Jackson JSON processor.
* @since 29-2-2020
* @version 1.0
* @author John Violos */
public class OpenData {
	public static void main(String[] args) throws IOException {
		City city1=new City("Rome","it");//παρομοια μπορω να φτιαξω και αλλες πολεις
		city1.CityTerms();//για την συγκεκριμενη πολη φτιαχνει τα τερμσ
		city1.CityLanLot();//το τατ λοτ, ωστε με γκετερς να μπορω να τα χρησιμοποιησω μετα
		YoungTraveller tr=new YoungTraveller("Athens","gr");
		tr.CurrentlyCityLanLot();
		tr.FavoriteCityTerms();
		System.out.println(tr.calculate_similarity(city1));
	}
}