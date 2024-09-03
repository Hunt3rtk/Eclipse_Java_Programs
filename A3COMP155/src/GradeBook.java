import java.util.ArrayList;
import java.util.Scanner;

public class GradeBook {
	
	static ArrayList<String> studentName = new ArrayList();
	
	public static double[][] studentScore = new double[5][5];
	
	public GradeBook()
	{
		Scanner keyboard = new Scanner(System.in);
		
		double[][] student = studentScore;
		
			 
			for(int n = 0; n < 5; ++n)
			{
				System.out.print("Enter the name of student:");
				
				studentName.add(keyboard.next());
				
				for(int i = 0; i < 5;++i)
				{
				
					System.out.printf("Enter test grade %d for student %d:",i,n);
					student[n][i] = keyboard.nextInt();
				}
			}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			GradeBook students = new GradeBook();
		
			students.getName(0);
			students.clacAverage(studentScore[0]);
			students.determineGrade(studentScore[0]);
			
			students.getName(1);
			students.clacAverage(studentScore[1]);
			students.determineGrade(studentScore[1]);
			
			students.getName(2);
			students.clacAverage(studentScore[2]);
			students.determineGrade(studentScore[2]);
			
			students.getName(3);
			students.clacAverage(studentScore[3]);
			students.determineGrade(studentScore[3]);
			
			students.getName(4);
			students.clacAverage(studentScore[4]);
			students.determineGrade(studentScore[4]);
		}
		
		public void determineGrade(double[] studentScore)
		{
			System.out.printf("The letter grades are:\n");
			
			for(int i=0;i<4;i++)
			{
				
				switch((int)Math.round(studentScore[i])/10)
				{
					case 10:
					System.out.println("Student score number " + (i+1) + ": A");
					break;
					
					case 9:
					System.out.println("Student score number " + (i+1) + ": A");
					break;
					
					case 8:
					System.out.println("Student score number " + (i+1) + ": B");
					break;
					
					case 7:
					System.out.println("Student score number " + (i+1) + ": C");
					break;
					
					case 6:
					System.out.println("Student score number " + (i+1) + ": D");
					break;
					
					default:
					System.out.println("Student score number " + (i+1) + ": F");
					break;
					
				}
			
			}
			
		
		}
		
		public void clacAverage(double[] student)
		{
			
			double average = (student[0]+student[1]+student[2]+student[3]+student[4])/5;
		
			System.out.printf("The average grade was: %.2f\n",average);
		
		}
		public void getName(int string)
		{
			System.out.print(studentName.get(string));
		}
}


