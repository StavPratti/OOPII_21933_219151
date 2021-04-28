import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import exceptions.WikipediaNoArcticleException;
import totravel.City;
import totravel.ElderTraveller;
import totravel.MiddleTraveller;
import totravel.Traveller;
import static totravel.Traveller.*;
import totravel.YoungTraveller;

public class OpenData {
	public static void main(String[] args) throws IOException, WikipediaNoArcticleException {
		
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		
		String cityname="nrei";//���� ����� ����� ����� ���� �� �������� �������� ��� �� ���� �����
		                        //Rome
		
        //������ ������
		City city1;
		City city2;
		City city3;
		City city4;
		
		while (true) {		
			try {		
	             city1=new City(cityname,"it");//����� ����� ��� �� �������� �� exception
				 city1.CityTerms();//��������� ������ �� �� ��������� ��������
			     city1.CityLatLon();//��������� ������ �� ��� �������������
			     
			     city2=new City("Corfu","gr");//2� ����
				 city2.CityTerms();
				 city2.CityLatLon();
				 
				 city3=new City("Berlin","de");//3� ����
		     	 city3.CityTerms();
				 city3.CityLatLon();
				 
				 city4=new City("Dublin","ger");//3� ����
		     	 city4.CityTerms();
				 city4.CityLatLon();
				 

			     break;
			   
			} catch (WikipediaNoArcticleException e) {
				System.out.println(e.getMessage());
				System.out.print("Type a correct city name: ");
				cityname = stdin.readLine();
				continue;
		}
		}


			//������� arraylist �� ��� ������
			
	    ArrayList<City> cities=new ArrayList<City>(); 
	    cities.add(city1); //Rome
	    cities.add(city2); //Corfu
	    cities.add(city3); //Berlin
	    cities.add(city4); //Dublin
		
	    //�� ���� ����� �� �� ���� ��� �� ���� middle ,elder
		YoungTraveller tr=new YoungTraveller("Athens","gr"); //������� ���� ��� ���������
		City bestCity=tr.CompareCities(cities); //���� ��� comparecities ��� �� ���������� ��� ��� ������� ����
		System.out.println("The best city for the traveller is : "+bestCity.getCity());//������ ��� ��� �������
		
		
		ArrayList<City> city =tr.CompareCities(cities, 4);//���� ��� comparecities ��� �� ���������� ��� ��� �������� ������
		for(int i=0;i<city.size();i++) {
			System.out.println("The"+" "+(i+2)+" "+"best city is:"+city.get(i).getCity()); //������ �� ��� ������� compare cities
		}
		
		//tr.CurrentlyCityLatLon();
		//tr.FavoriteCityTerms();
	    //System.out.println(tr.calculate_similarity(city1)); //similarity athens-rome
	    //System.out.println(tr.calculate_similarity(city2)); //similarity athens-corfu
	

		//free ticket
		//������� travellers
		YoungTraveller young1=new YoungTraveller("Athens","gr");
		MiddleTraveller middle1=new MiddleTraveller("Athens","gr");
		ElderTraveller elder1=new ElderTraveller("Athens","gr");
		YoungTraveller young2=new YoungTraveller("Athens","gr");
		MiddleTraveller middle2=new MiddleTraveller("Berlin","de");
		ElderTraveller elder2=new ElderTraveller("Athens","gr");
		YoungTraveller young3=new YoungTraveller("Athens","gr");
		MiddleTraveller middle3=new MiddleTraveller("Athens","gr");
		ElderTraveller elder3=new ElderTraveller("Berlin","de");
		
		
		//������ �� default vectors 
		elder1.setRating_vector(new int[] {2,9,9,0,3,1,0,0,0,0});
		middle1.setRating_vector(new int[] {0,4,2,7,1,0,0,0,9,1});
		young2.setRating_vector(new int[] {2,1,5,6,7,8,9,7,7,7,});
		elder2.setRating_vector(new int[] {0,0,0,0,0,0,0,0,0,0});
		middle2.setRating_vector(new int[] {1,0,0,0,0,0,0,0,0,0});
		young3.setRating_vector(new int[] {9,9,9,9,9,9,9,9,9,9});
		elder3.setRating_vector(new int[] {1,0,9,0,0,1,0,0,0,0});
		middle3.setRating_vector(new int[] {0,1,2,9,9,4,0,1,9,7});
		
		
		//������ �� ��� ��� ��� �������� ��� �� ��� ����� ���� ��� �����
		middle2.setCurGeodestic_vector(new double[] {52.5244,13.4105});
		elder3.setCurGeodestic_vector(new double[] {52.5244,13.4105});
		
		//������ �� ������� ����
		middle1.setName("Nikoleta");
		elder1.setName("Nikos");
		middle2.setName("Dimitris");
		elder2.setName("Sia");
		middle3.setName("Peggy");
		elder3.setName("Stefania");
		young2.setName("Chrisa");
		young3.setName("Maria");
		
		
		ArrayList<Traveller> travellers = new ArrayList<>(); 
		travellers.add(elder1);
		travellers.add(young1);
		travellers.add(middle1);
		travellers.add(elder2);
		travellers.add(young2);
		travellers.add(middle2);
		travellers.add(elder3);
		travellers.add(young3);
		travellers.add(middle3);
		
		
		
		System.out.println("The winner of the free ticket is : "+freeticket(travellers).getName());//������ ��� ������ ��� ����������
		
		}
	}
