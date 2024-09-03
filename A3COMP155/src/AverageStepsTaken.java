import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AverageStepsTaken {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		int [] dailySteps = new int[365];
		int totalSteps = 0;
		
		File  myFile = new File("steps.txt");
		Scanner inputFile  = new Scanner(myFile);
		
		
		for(int i = 0; i < 365; ++i)
		{
			dailySteps[i] = inputFile.nextInt();
		}
		inputFile.close();
		
		int janSteps= 0;
		int febSteps= 0;
		int marSteps= 0;
		int aprSteps= 0;
		int maySteps= 0;
		int junSteps= 0;
		int julSteps= 0;
		int augSteps= 0;
		int sepSteps= 0;
		int octSteps= 0;
		int novSteps= 0;
		int decSteps = 0;
		
		for(int i = 0; i < 31; ++i)
		{
			janSteps += dailySteps[i];
		}
		double janAverage = janSteps/31;
		System.out.printf("The average steps for January is: %f",janAverage);
		
		for(int i = 31; i < 59; ++i)
		{
			febSteps += dailySteps[i];
		}
		double febAverage = febSteps/28;
		System.out.printf("The average steps for February is: %f",febAverage);
		
		for(int i = 59; i < 90; ++i)
		{
			marSteps += dailySteps[i];
		}
		double marAverage = marSteps/31;
		System.out.printf("The average steps for March is: %f",marAverage);
		
		for(int i = 90; i < 120; ++i)
		{
			aprSteps += dailySteps[i];
		}
		double aprAverage = aprSteps/30;
		System.out.printf("The average steps for April is: %f",aprAverage);
		
		for(int i = 120; i < 151; ++i)
		{
			maySteps += dailySteps[i];
		}
		double mayAverage = maySteps/31;
		System.out.printf("The average steps for May is: %f",mayAverage);
		
		for(int i = 151; i < 181; ++i)
		{
			junSteps += dailySteps[i];
		}
		double junAverage = junSteps/30;
		System.out.printf("The average steps for June is: %f",junAverage);
		
		for(int i = 181; i < 212; ++i)
		{
			julSteps += dailySteps[i];
		}
		double julAverage = julSteps/31;
		System.out.printf("The average steps for July is: %f",julAverage);
		
		for(int i = 212; i < 243; ++i)
		{
			augSteps += dailySteps[i];
		}
		double augAverage = augSteps/31;
		System.out.printf("The average steps for August is: %f",augSteps);
		
		for(int i = 243; i < 273; ++i)
		{
			sepSteps += dailySteps[i];
		}
		double sepAverage = sepSteps/30;
		System.out.printf("The average steps for Spetember is: %f",sepSteps);
		
		for(int i = 273; i < 304; ++i)
		{
			octSteps += dailySteps[i];
		}
		double octAverage = octSteps/31;
		System.out.printf("The average steps for October is: %f",octAverage);
		
		for(int i = 304; i < 334; ++i)
		{
			novSteps += dailySteps[i];
		}
		double novAverage = novSteps/30;
		System.out.printf("The average steps for November is: %f",novAverage);
		
		for(int i = 334; i < 365; ++i)
		{
			decSteps += dailySteps[i];
		}
		double decAverage = decSteps/31;
		System.out.printf("The average steps for December is: %f",decAverage);
		

	}

}
