
public class NumberPrinter {

	
	public NumberPrinter() {
		// TODO Auto-generated constructor stub
		
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int howMany = 4;
		int lineLength = 12;
		
		
		printNumbers(howMany, lineLength);
		System.out.println("");
		
		 howMany = 4;
		 lineLength = 10;
		
		
		printNumbers(howMany, lineLength);
		System.out.println("");
		
		 howMany = 3;
		 lineLength = 5;
		
		
		printNumbers(howMany, lineLength);
		System.out.println("");
		
		 howMany = 3;
		 lineLength = 2;
		
		
		printNumbers(howMany, lineLength);
		System.out.println("");
	}
	
	public static void printNumbers(int howMany, int lineLength)
	{
		if(lineLength < 3)
		{
			System.out.print("Error! lineLength has to be at least 3.");
			return;
		}
		String printedLine = "";
		
		for(int i = 1; i <= howMany; i++)
		{
			if((i*3) > lineLength)
			{
				printedLine += "\n";
			}
			printedLine += "[" + i + "]";
		}
		
		System.out.print(printedLine + "\n");	
	}
}
