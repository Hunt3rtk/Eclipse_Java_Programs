import java.util.Scanner;
//importing scanner


public class DistanceTraveledModification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		float speed;
		float time;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter the speed in miles per hour:");
		speed = keyboard.nextFloat();
		
		System.out.print("Enter the time in hours:");
		time = keyboard.nextFloat();
		
		System.out.printf("The distance traveled is %.2f miles",distance(speed,time));

	}
	
	public static double distance(float speed, float time)
	{
		double distance = speed*time;
		return distance;
	}

}
