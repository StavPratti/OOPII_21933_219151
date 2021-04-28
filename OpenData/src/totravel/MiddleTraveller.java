package totravel;

import java.lang.Math;
import static moreinfo.DistanceCalculator2.*;


public class MiddleTraveller extends Traveller{

	public MiddleTraveller(String city, String country) {
		super(city, country);
		// TODO Auto-generated constructor stub
	}

public double similarity_terms_vector(City cit){
        int sum=0; 
        int sum1 =0;
        int sum2=0;
        
        int[] user = new int[10];
        int[] city = new int[10];
        
        for(int i=0; i<user.length; i++){
            user[i]=getRatingVector(i);
            city[i]=cit.getTerms_vector(i);
            
            sum += user[i]*city[i];
            sum1 += Math.pow(user[i],2);
            sum2 += Math.pow(city[i],2);
        }
        
        if(sum1==0 || sum2==0)
            return 0;
        else
            return (double)(sum)/(Math.sqrt(sum1)+Math.sqrt(sum2));
     }


@Override
 public double calculate_similarity(City object) {
	double p=0.70;
	double distance=distance(getCurGeodestic_vector(0),getCurGeodestic_vector(1),object.getGeodestic_vector(0),object.getGeodestic_vector(1),'M');
	return p*similarity_terms_vector(object)+(1-p)*SimilarityGeodesticVector(distance);
	}


}







