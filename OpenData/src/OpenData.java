import java.io.IOException;
import totravel.City;
import totravel.ElderTraveller;
import totravel.YoungTraveller;
/**City description and weather information using OpenData with Jackson JSON processor.
* @since 29-2-2020
* @version 1.0
* @author John Violos */
public class OpenData {
	public static void main(String[] args) throws IOException {
		//���� ����������
		City city1=new City("Rome","it");//�������� ����� �� ������ ��� ����� ������
		city1.CityTerms();//��� ��� ������������ ���� �������� �� �����
		city1.CityLatLon();//�� ��� ���, ���� �� ������� �� ����� �� �� ������������� ����
		YoungTraveller tr=new YoungTraveller("Athens","gr");
		tr.CurrentlyCityLatLon();
		tr.FavoriteCityTerms();
		System.out.println(tr.calculate_similarity(city1)); //similarity athens-rome
		//��������� ����������
		
		
		
		//����� ����������
		ElderTraveller elder=new ElderTraveller("Athens","gr");
		elder.CurrentlyCityLatLon();
		elder.FavoriteCityTerms();
		System.out.println(elder.calculate_similarity(city1)); //similarity athens-rome
		
	}
}