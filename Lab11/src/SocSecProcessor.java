import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//importing

public class SocSecProcessor {

	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner(System.in);
		
		String name;
		String socsec;
		String response;
		char answer = 'y';
		//declaring variables
	
		while (Character.toUpperCase(answer) == 'Y') {
			//while they want to continue
			try {
				
				
				System.out.print("What is your name?");
				
				name = keyboard.next();
				
				System.out.print("What is your social security number?");
				
				socsec = keyboard.next();
				//getting information
				
				isValid(socsec);
				//running method to see if valid
				
				}
			catch(Exception e)
				{
				
					System.out.print(e.getMessage());
					//printing error message
				
				}
			
			System.out.printf("\nDo you want to continue (y/n)?");
			
			response = keyboard.next();
			answer = response.charAt(0);
			//seeing if they want to continue
			
		}

	}
	
	public static boolean isValid(String ssn) throws SocSecException
	//method to check if valid
	{
		
		Pattern pattern = Pattern.compile("^\\d{3}[- ]?\\d{2}[- ]?\\d{4}$");
		Matcher matcher = pattern.matcher(ssn);
		//seeing if the social security number matches
		
		boolean valid = true;
		//valid variable
		
		if(ssn.length() != 11)
		{
			throw new SocSecException("wrong number of characters.");
		}
		else if(ssn.charAt(3) != '-')
		{
			throw new SocSecException("no -.");
		}
		else if(ssn.charAt(6) != '-')
		{
			throw new SocSecException("no -.");
		}
		if(matcher.matches())
		{
			System.out.printf("The social security number %s is valid",ssn);
			return valid;
		}
		throw new SocSecException("not all digits.");
		//chain of if statements that see if it is valid and if not throw our exception

	}

}
