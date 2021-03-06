package totravel;

import static moreinfo.DistanceCalculator2.distance;

public class ElderTraveller extends Traveller {

	public ElderTraveller(String city, String country) {
		super(city, country);
		
	}

	@Override
	public double calculate_similarity(City object) {	//õëïðïßçóç 
		double p=0.05;	
		double distance=distance(getCurGeodestic_vector(0),getCurGeodestic_vector(1),object.getGeodestic_vector(0),object.getGeodestic_vector(1),'M');
		//ç óçìåéùóç åßíáé ãéá íá äù ôï óéìéëáñéôé ôçò ðïëçò ùóôå íá ôóåêáñù áí åéíáé óùóôåò ïé comparecities 
		//System.out.println(p*similarity_terms_vector(object)+(1-p)*SimilarityGeodesticVector(distance));
		return p*similarity_terms_vector(object)+(1-p)*SimilarityGeodesticVector(distance);
		
	}


	public double similarity_terms_vector(City cit){
	
	int sum_intersection=0;
	int sum_union=0;
	int[] user=new int[10];
	int[] city=new int[10];
	for(int i=0;i<user.length;i++) {
		//2,4,10,5,3,10,8,0,0,1
		user[i]= getRatingVector(i);
		//31,15,38,0,0,10,0,2,4,0
		city[i]=cit.getTerms_vector(i);
		if(city[i]>=1 && user[i]>=1) { //ôïìç
			sum_intersection+=1;
		}
		if(city[i]>=1 || user[i]>=1) { //åíùóç
			sum_union+=1;
		}
	}
	if (sum_union==0) {//ðáñïíïìáóôçò
		return 0;
	}
	
	return sum_intersection/sum_union;
	}





}