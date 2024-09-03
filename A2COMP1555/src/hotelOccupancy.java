import java.util.Scanner;
//importing scanner

public class hotelOccupancy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int floors;
		int occupiedRooms = 0;
		int vacantRooms;
		double occupancyRate;
		int totalRooms = 0;
		
		Scanner keyboard = new Scanner(System.in);
		// Create a scanner object to read from the keyboard Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter the number of floors:");
		//asking for a nonnegative integer
		
		floors = keyboard.nextInt();
		//getting the number of floors
		
		if(floors < 1)
		//if there is an invalid input asking for another input that is valid
		{
			System.out.print("Enter the number of floors that is greater than or equal to one:");
			//asking for a the number of floors
			
			floors = keyboard.nextInt();
			//getting the number of floors
			
		}
		
		int rooms[] = new int[floors];
		
		for(int i = 1; i <= floors; i++)
		{
			System.out.printf("Enter the number of rooms on floor %d:",i);
			//asking for number of rooms
			
			rooms[i-1] = keyboard.nextInt();
			//getting the number of rooms
			
			if(rooms[i-1] <= 9)
			//if there is an invalid input asking for another input that is valid
			{
				System.out.printf("Enter the number of rooms on floor %d that is greater than nine:",i);
				//asking for number of rooms
				
				rooms[i-1] = keyboard.nextInt();
				//getting the number of rooms
			}
			
			totalRooms += rooms[i-1];
			//adding up the total number of rooms
			
			System.out.printf("Enter the number of  occupied rooms on floor %d:",i);
			//asking for number of rooms
			
			occupiedRooms += keyboard.nextInt();
			//getting the number of occupied rooms
		}
				
		vacantRooms = totalRooms-occupiedRooms;
		//calculating the vacant rooms
		
		System.out.printf("The number of rooms is %d\nThe number of occupied rooms is %d\nThe number of vacant rooms is %d\nThe occupancy rate is %d/%d",totalRooms,occupiedRooms,vacantRooms,occupiedRooms,totalRooms);
		//displaying the number of rooms,occupied rooms, vacant rooms, and the occupancy rate
		

	}

}
