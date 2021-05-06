package totravel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JacksonFile {
	

	public void serializeTravellerData(ArrayList<Traveller> travellers) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		//mapper.enableDefaultTyping();
		//AllTravellers data = new AllTravellers();
		//data.setCollectionAllTravellers(travellers);
		mapper.writeValue(new File("travellerData.json"), travellers);	
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayList<Traveller> deserializeTravellerData() throws JsonParseException, JsonMappingException, IOException{
		/*File f = new File("travellerData.json");
		if(f.exists()) {
		ObjectMapper mapper=new ObjectMapper();
		ArrayList<Traveller> outputArrayListOfTravellers=mapper.readValue(f,ArrayList.class);
		return outputArrayListOfTravellers;
		
		}else {
			 return new ArrayList<Traveller>();
		}*/
	
		
		
		File f = new File("travellerData.json");
		if(f.exists()) {
			ObjectMapper mapper = new ObjectMapper();
			mapper.enableDefaultTyping();
			AllTravellers data = mapper.readValue(new File("travellerData.json"), AllTravellers.class);
			return data.getCollectionAllTravellers();
		}
		else {
			return new ArrayList<Traveller>();
		}
		
	}


}
