import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

class code
{
	public static void main(String[] args) 
	{
		boolean test = false;
		try{
			//open file
			FileInputStream fileInputStream = new FileInputStream("input.txt");
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream,StandardCharsets.UTF_8));
			String line;

			//read file line by line
			while((line = bufferedReader.readLine()) != null)
			{
				line = line.trim();
				if(test) System.out.println(line);
				//ASCII I(1)=73 V(5)=86 X(10)=88 L(50)=76 C(100)=67 D(500)=68 M(1000)=77
				int firstNumber, secondNumber, positionOfPlus = line.indexOf('+');
		
				List<Integer> listOfFirstNumber = new ArrayList<Integer>(), listOfSecondNumber = new ArrayList<Integer>();
				if(test) System.out.println("positionOfPlus = " + positionOfPlus);
				for (int i = 0; i < line.length(); i++)
				{
					if(i != positionOfPlus){
						if(test) System.out.println("character=" + line.charAt(i));
						if(test) System.out.println("position=" + i);
						int number = convertRomanToArabic(line.charAt(i));
						if(number == 0) System.out.println("error when convertRomanTo Arabic ");
						else{
							if(i < positionOfPlus) listOfFirstNumber.add(number);
							else if(i > positionOfPlus) listOfSecondNumber.add(number);
						}	
					}
				}
				firstNumber = convertListToNumber(listOfFirstNumber);
				secondNumber = convertListToNumber(listOfSecondNumber);
				if(test) System.out.println(firstNumber);
				if(test) System.out.println(secondNumber);
				if(test) System.out.println(firstNumber + secondNumber);
				System.out.println(convertArabicToRoman(firstNumber + secondNumber));
			}
			bufferedReader.close();
		}catch(FileNotFoundException e){
			System.out.println("File didn't found");
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	//method change roman to arabic
	public static int convertRomanToArabic(char c){
		if(c == 73) return 1;
		if(c == 86) return 5;
		if(c == 88) return 10;
		if(c == 76) return 50;
		if(c == 67) return 100;
		if(c == 68) return 500;
		if(c == 77) return 1000;

		return 0;
	}

	//method sum arabic number in list to number
	public static int convertListToNumber(List listNumber){
		int sum = 0;
		for(int i = 0; i < listNumber.size(); i++){
			int j = i + 1;
			if(j < listNumber.size()){
				int n1 = (int) listNumber.get(i);
				int n2 = (int) listNumber.get(j);
				if(n1 >= n2) sum += n1;
				else if(n1 < n2){
					sum = sum + n2 - n1;
					i++;
				}		
			}
			else{
				sum += (int) listNumber.get(i);
			}
		}
		return sum;
	}

	//method change arabic result to roman 
	public static String convertArabicToRoman(int number){
		//ASCII I(1)=73 V(5)=86 X(10)=88 L(50)=76 C(100)=67 D(500)=68 M(1000)=77
		StringBuilder stringResult = new StringBuilder();
		int divisor = 1000,result;
		boolean toggle = true;
		char[] c = {'M','D','C','L','X','V','I'};
		int i = 0;
		

		while(divisor >= 1){
			if(number / divisor > 0){ 
				result = number / divisor;
				if(result >= 4){
					stringResult.append(c[i]);
					stringResult.append(c[i - 1]);
				}
				else{
					for(int j = 0; j < result; j++){
						stringResult.append(c[i]);
					}
				}
				number = number % divisor;
			}
			if(toggle){ 
				divisor /= 2;
				toggle = !toggle;
			}
			else{
				divisor /= 5;
				toggle = !toggle;
			}
			i++;
		}
		return stringResult.toString();
	}

	public static String findCharacter(int result, char c){
		StringBuilder string = new StringBuilder();
		
		
		return string.toString();
	}
}
