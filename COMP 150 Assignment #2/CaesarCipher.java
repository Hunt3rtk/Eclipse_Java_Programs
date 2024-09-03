

import java.util.Arrays;
import java.util.Scanner;


public class CaesarCipher {

static String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","Z"," "};
//declaring a array of the alphabet

public static void main(String[] args) {
// TODO Auto-generated method stub


Scanner keyboard = new Scanner(System.in);
//declaring keyboard to equal new scanner

System.out.println("Enter Your Code.");
//asking for phone number

String originalMessage = keyboard.next();
//getting the original message

System.out.println("");
//asking for phone number

//int secretKey = keyboard.nextInt();
//getting the secret key number

int secretKey = 2;
char letter = 'A';
int numberOfTimes = 2;
//declaring test numbers

String encryptedMessage= encryptMessage(originalMessage,secretKey);

System.out.print(encryptMessage(originalMessage, secretKey));

System.out.print(" ");

System.out.print(decryptMessage(encryptedMessage,secretKey));

System.out.print(" ");

System.out.print(Arrays.toString(identifyKeys (encryptedMessage, letter, numberOfTimes)));
//output of answers
}



public static String encryptMessage(String originalMessage, int secretKey) {
	//Method to encrypt message

int encryptedCharacterIndex;
String encryptedMessage = "";
//declaring character index and encrypted message

for(int i=0;i<originalMessage.length();i++)
	//looping the amount of times equal to the length of the original message
	{
		int originalCharacterIndex = Character.getNumericValue(originalMessage.charAt(i))-10;
		//getting the index of original message each loop
		
		if(originalMessage.charAt(i) == ' '|| originalMessage.charAt(i) == '\r' ||originalMessage.charAt(i) == '\n' || originalMessage.charAt(i) == '\t')
			//if there is a space it should keep it, but it is not working and I can't fix it. 
			{
				System.out.print("Should Work!");
				encryptedCharacterIndex = 25;
				//setting character index to the last character in array which is whitespace
			}
		else
			{
				if(originalCharacterIndex+secretKey > 24)
					{
						encryptedCharacterIndex = originalCharacterIndex+secretKey - 24;
					}
				else
					{
						encryptedCharacterIndex = originalCharacterIndex+secretKey;
					}
				//getting encrypted character index depending on if it overlaps the alphabet
			}

		encryptedMessage = encryptedMessage  + alphabet[encryptedCharacterIndex];
		//setting the encrypted message to all of the character indexes equivilent characters
	}
return encryptedMessage;
//returning answer
}


public static String decryptMessage (String encryptedMessage, int secretKey)
//Method to decrypt message
{

	int decryptedCharacterIndex;
	String decryptedMessage = "";
	//declaring characterindex and decrypted message

	for(int i=0;i<encryptedMessage.length();i++)
		//looping however long the message is
		{
			int encryptedCharacterIndex = Character.getNumericValue(encryptedMessage.charAt(i))-10;
			//setting the character index equal to the current character that the loop is on
			
			if(encryptedMessage.charAt(i) == ' ')
				//if there is a space it should keep it, but it is not working and I can't fix it. 
				{
					System.out.print("Should Work!");
					decryptedCharacterIndex = 25;
					//setting character index to the last character in array which is whitespace
				}
			else
				{
					if(encryptedCharacterIndex+secretKey > 24)
						{
							decryptedCharacterIndex = encryptedCharacterIndex-secretKey + 24;
						}
					else
						{
							decryptedCharacterIndex = encryptedCharacterIndex-secretKey;
						}
					//getting decrypted character index depending on if it overlaps the alphabet
				}

			decryptedMessage = decryptedMessage  + alphabet[decryptedCharacterIndex];
			//setting the decrypted message to all of the character indexes equivilent characters
		}
return decryptedMessage;
//returning decrypted message
}


public static  int[] identifyKeys (String encryptedMessage, char letter, int numberOfTimes)
//Method for identifying possible keys
{
	int[] results = new int [encryptedMessage.length()];
	int[] letterCount = new int [encryptedMessage.length()];
	//declaring the letter counter and the result as arrays

	for(int i = 0; i <encryptedMessage.length(); i++)
	//looping through all of the letters in the message
		{
			for(int n = 0; n < encryptedMessage.length(); n++)
				//looping through all of the letters in the message
				{
					if(encryptedMessage.charAt(i) == encryptedMessage.charAt(n))
					//seeing how many of each letter there are in the message
						{
							letterCount[i] += 1;
						}
				}
		}


	for(int k = 0; k < encryptedMessage.length();k++)
		{
			if(letterCount[k] == numberOfTimes)
			//looping through to see if any of the counters match with the numberOfTimes integer given
				{
					results[k] = ((Character.getNumericValue(letter)-10)+(Character.getNumericValue(encryptedMessage.charAt(k))-10));
					//returning the number that matches to give a possible key
				}
		}
	return results;

}
}

