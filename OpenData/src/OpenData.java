import java.io.IOException;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;
//import weather.OpenWeatherMap; 
import wikipedia.MediaWiki;
import totravel.City;
//import static moreinfo.CountWords.*;
import totravel.City.*;
/**City description and weather information using OpenData with Jackson JSON processor.
* @since 29-2-2020
* @version 1.0
* @author John Violos */
public class OpenData {

/**Retrieves weather information, geotag (lan, lon) and a Wikipedia article for a given city.
* @param city The Wikipedia article and OpenWeatherMap city. 
* @param country The country initials (i.e. gr, it, de).
* @param appid Your API key of the OpenWeatherMap.*/ 
 public static void RetrieveData(String city, String country, String appid) throws  IOException {
	 ObjectMapper mapper = new ObjectMapper(); 
	// OpenWeatherMap weather_obj = mapper.readValue(new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+","+country+"&APPID="+appid+""), OpenWeatherMap.class);
	// System.out.println(city+" temperature: " + (weather_obj.getMain()).getTemp());
	// System.out.println(city+" lat: " + weather_obj.getCoord().getLat()+" lon: " + weather_obj.getCoord().getLon());
	 MediaWiki mediaWiki_obj =  mapper.readValue(new URL("https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles="+city+"&format=json&formatversion=2"),MediaWiki.class);
	System.out.println(city+" Wikipedia article: "+mediaWiki_obj.getQuery().getPages().get(0).getExtract());	 
	 //int count=countCriterionfCity(mediaWiki_obj.getQuery().getPages().get(0).getExtract(),"walls");
	 //System.out.println(count);
}

 //https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles=Rome&format=json&formatversion=2 στο google το αρθρο τησ wikipedia for rome
public static void main(String[] args) throws IOException {
	//String appid ="c01b30fa264932378fe076eb38121dbc";
	City city1=new City("Rome","it");//παρομοια μπορω να φτιαξω και αλλες πολεις
	city1.CityTerms();//για την συγκεκριμενη πολη φτιαχνει τα τερμσ
	city1.CityLanLot();//το τατ λοτ, ωστε με γκετερς να μπορω να τα χρησιμοποιησω μετα
	System.out.println(city1.getGeodestic_vector(0));//lat γενικα ετσι μπορω να παρω ολα τα στοιχεια του πινακα
		
	//RetrieveData("Rome","it",appid);	
	/*RetrieveData("Athens","gr",appid);
	RetrieveData("Corfu","gr",appid);	
	RetrieveData("Berlin","de",appid);	*/
}

}