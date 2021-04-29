package totravel;

import java.lang.Math;
import static moreinfo.DistanceCalculator2.*;

public class YoungTraveller extends Traveller {

	
	
	public YoungTraveller(String city, String country) {
		super(city, country);
		// TODO Auto-generated constructor stub
	}



	public double similarity_terms_vector(City cit){
		
		int sum=0;
		int[] user=new int[10];
		int[] city=new int[10];
		for(int i=0;i<user.length;i++) {
			//2,4,10,5,3,10,8,0,0,1
			user[i]= getRatingVector(i);
			//31,15,38,0,0,10,0,2,4,0
			city[i]=cit.getTerms_vector(i);
			
			sum+=(user[i]-city[i])*(user[i]-city[i]);
			
		}
		
		return (double)1/(1+ Math.sqrt(sum));
	}

	

	@Override
	public double calculate_similarity(City object) {
    	double p=0.95;	
		double distance=distance(getCurGeodestic_vector(0),getCurGeodestic_vector(1),object.getGeodestic_vector(0),object.getGeodestic_vector(1),'M');
		//η σημειωση είναι για να δω το σιμιλαριτι της πολης ωστε να τσεκαρω αν ειναι σωστες οι comparecities 
		//System.out.println(p*similarity_terms_vector(object)+(1-p)*SimilarityGeodesticVector(distance));
		return p*similarity_terms_vector(object)+(1-p)*SimilarityGeodesticVector(distance);
	}


}
	
	


