import java.util.ArrayList;
import java.util.Scanner;

class City {
	int money;
	ArrayList<City> paths = new ArrayList<City>();
}

public class TimeIsMoney {
	
	public static int max = 0;
	public static int total = 0;
	public static int c;
	public static int day;
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		c = kb.nextInt();
		City [] cities = new City[n]; 
		for (int i = 0; i<n; i++) {
			cities[i] = new City();
			cities[i].money = kb.nextInt();
		}
		for (int i = 0; i<m; i++) {
			cities[kb.nextInt()-1].paths.add(cities[kb.nextInt()-1]);
		}
		System.out.println(maxOf(cities[0]));
	}
	
	public static int maxOf(City city) {
		max += city.money;
		if (total <= max - c*(day*day)) {
			total = max - c*(day*day);
			for (int i = 1; i < city.paths.size(); i++) {
				maxOf(city.paths.get(i));
			}
		}
		return total;
	}
}
