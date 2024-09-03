import java.util.Random;

public class DieGame {

	private int sides;
	private int value;
	//values for the dice
	
	public DieGame()
	{
		sides = 6;
		roll();
	}
	
	public void roll()
	{
		Random rand = new Random();
		
		value = rand.nextInt(sides)+1;
	}
	
	public int getValue()
	{
		return value;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int userWins = 0;
		int compWins = 0;
		
		DieGame user = new DieGame();
		DieGame comp = new DieGame();
		
		for(int i = 0; i < 10; ++i)
		{
			user.roll();
			comp.roll();
			
			if(user.getValue() > comp.getValue())
			{
				++userWins;
			}
			else
				++compWins;
		}
		
		System.out.printf("The computer won %d times and you won %d times.", compWins,userWins);

	}

}
