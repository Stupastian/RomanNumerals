
public class RomanNumerals {
	public int convertToInteger(String romanNum) {
		
		romanNum = romanNum.toUpperCase();
		if(testRepetitiveIXCM(romanNum)) return -1;
		if(testRepetitiveVLD(romanNum)) return -2;
		if(testAllowedSubstractionsIXC(romanNum)) return -3;
		if(testAllowedSubstractionsOne(romanNum)) return -4;
		if(testNoSubstractionAllowedVLD(romanNum)) return -5;
		if(!romanNum.matches("^[IVXLCDM]+$") && romanNum != "") return -6;
		
		return calculateString(convertToNumberArray(romanNum));
		
	}
	
	private int getMainNumberValue(char pieceOfString){
		int result = 0;
		
		switch (pieceOfString){
			case 'I': 	result = 1;
						break;
			case 'V':	result = 5;
						break;
			case 'X':   result = 10;
						break;
			case 'L':   result = 50;
						break;
			case 'C':   result = 100;
						break;
			case 'D': 	result = 500;
						break;
			case 'M':   result = 1000;
						
		}
		return result;
	}
	
	private boolean testRepetitiveIXCM(String romanNum){
		boolean test = false;
		int counter = 1;
		for(int i = 0; i < romanNum.length(); i++){
			if(i >= 1 && romanNum.charAt(i) == romanNum.charAt(i-1)) {
				counter++;
				if(counter >= 4) test = true;
			}
			else counter = 1;
		}
		return test;
	}
	
	private boolean testRepetitiveVLD(String romanNum){
		boolean test = false;
		int counter = 1;
		for(int i = 0; i < romanNum.length(); i++){
			if(i >= 1 && romanNum.charAt(i) == romanNum.charAt(i-1) && "VLD".indexOf(romanNum.charAt(i)) >= 0) {
				counter++;
				if(counter >= 2) test = true;
			}
			else counter = 1;
		}
		return test;
	}
	
	private boolean testAllowedSubstractionsIXC(String romanNum){
		boolean test = false;

		for(int i = 1; i < romanNum.length(); i++){
			if(romanNum.charAt(i-1) == 'I' && "LCDM".indexOf(romanNum.charAt(i)) >= 0) test = true;
			if(romanNum.charAt(i-1) == 'X' && "DM".indexOf(romanNum.charAt(i)) >= 0) test = true;
		}	
		return test;
	}
	
	private boolean testAllowedSubstractionsOne(String romanNum){
		boolean test = false;

		for(int i = 2; i < romanNum.length(); i++){
			if(romanNum.charAt(i-2) == 'I' && romanNum.charAt(i-1) == 'I' && "VX".indexOf(romanNum.charAt(i)) >= 0) test = true;
			if(romanNum.charAt(i-2) == 'X' && romanNum.charAt(i-1) == 'X' && "LC".indexOf(romanNum.charAt(i)) >= 0) test = true;
			if(romanNum.charAt(i-2) == 'C' && romanNum.charAt(i-1) == 'C' && "DM".indexOf(romanNum.charAt(i)) >= 0) test = true;
		}	
		return test;
	}
	
	private boolean testNoSubstractionAllowedVLD(String romanNum){
		boolean test = false;

		for(int i = 1; i < romanNum.length(); i++){
			if(romanNum.charAt(i-1) == 'V' && romanNum.charAt(i) != 'I') test = true;
			if(romanNum.charAt(i-1) == 'L' && "IVX".indexOf(romanNum.charAt(i)) == -1) test = true;
			if(romanNum.charAt(i-1) == 'D' && romanNum.charAt(i) == 'M') test = true;
		}	
		return test;
	}
	
	private int calculateString(int[] numbersArray){
		int result = 0;
		
		for(int i=0; i < numbersArray.length; i++){
			if(i < numbersArray.length-1 && numbersArray[i] < numbersArray[i+1]) result-=numbersArray[i];
			else result += numbersArray[i];
		}	
		return result;
	}
	
	private int[] convertToNumberArray(String romanNum){
		int[] numbersArray = new int[10];

		for(int i = 0; i < romanNum.length(); i++){
			numbersArray[i] = getMainNumberValue(romanNum.charAt(i));
		}
		return numbersArray;
	}
	
	
}
