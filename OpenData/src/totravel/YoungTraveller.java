package totravel;

import java.lang.Math;
import static moreinfo.DistanceCalculator2.*;

public class YoungTraveller extends Traveller {

	public YoungTraveller(String city, String country) {
		super(city, country);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculate_similarity(City object) {
		double p=0.05;
		int sum=0;
		int user[]=new int[10];
		int city[]=new int[10];
		for(int i=0;i<10;i++) {
			sum+=(user[i]-city[i])^2;
		}
		double similarity_terms_vector=(double)1/(1+Math.sqrt(sum));
		
		double distance=distance(getCurGeodestic_vector(0),getCurGeodestic_vector(1),object.getGeodestic_vector(0),object.getGeodestic_vector(1),'M');
		
		return p*similarity_terms_vector+(1-p)*SimilarityGeodesticVector(distance);
	}

	
}
