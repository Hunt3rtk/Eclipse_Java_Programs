import java.util.Scanner;
//importing scanner


public class TestAverageGrade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner keyboard = new Scanner(System.in);
			
			double student[];
			
			student = new double[5];
			
			
			System.out.print("Enter test grade for student 1:");
			student[0] = keyboard.nextInt();
							   
			System.out.print(" Enter test grade for student 2:");
			student[1] = keyboard.nextInt();
												  
			System.out.print(" Enter test grade for student 3:");
			student[2] = keyboard.nextInt();
																	 
			System.out.print(" Enter test grade for student 4:");
			student[3] = keyboard.nextInt();
							   
			System.out.print(" Enter test grade for student 5:");
			student[4] = keyboard.nextInt();
			
			determineGrade(student);
				
			clacAverage(student);
			
		}
		
		static void determineGrade(double[] student)
		{
			System.out.println(" The letter grades are as follows:");
			
			for(int i=0;i<=4;i++)
			{
			
				switch((int)Math.round(student[i])/10)
				{
					case 10:
					System.out.println("Student " + (i+1) + ": A");
					break;
					
					case 9:
					System.out.println("Student " + (i+1) + ": A");
					break;
					
					case 8:
					System.out.println("Student " + (i+1) + ": B");
					break;
					
					case 7:
					System.out.println("Student " + (i+1) + ": C");
					break;
					
					case 6:
					System.out.println("Student " + (i+1) + ": D");
					break;
					
					default:
					System.out.println("Student " + (i+1) + ": F");
					break;
				
				}
			
			}
			
		
		}
		
		static void clacAverage(double[] student)
		{
			
			double average = (student[0]+student[1]+student[2]+student[3]+student[4])/5;
		
			System.out.printf("The average grade was: %.2f\n",average);
		
		}
	}

