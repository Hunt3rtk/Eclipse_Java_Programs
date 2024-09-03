import java.util.Scanner;
//importing

public class TempCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner(System.in);
		//declaring keyboard as scanner
		
		System.out.print("Enter the temperature in Fahrenheit:");
		//asking for temp
		
		double fahrenheit = keyboard.nextDouble();
		//getting temp
		
		Temperature temp = new Temperature(fahrenheit);
		
		System.out.print("Celcius:" + temp.celsius() +  "\nKelvin:" + temp.kelvin());

	}

}
