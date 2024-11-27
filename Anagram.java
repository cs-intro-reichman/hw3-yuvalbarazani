/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
	 	// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
	 	for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	
			System.out.println(preProcess("He33,, LL 54 ,O"));}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		
		if(str1.length()!=str2.length()){
			return false;
		}

		boolean isFound = false;//indictaes if the char is found in the other word

		while(str1.length()!=0)
		{
			isFound=false;

			for(int i=0 ; i<str2.length() && (!isFound);i++){
			
				if(str1.charAt(0)==str2.charAt(i)){
					//removes the equal char from both strings
					str1 = str1.substring(1, str1.length()); 
					str2=str2.substring(0, i)+str2.substring(i+1, str2.length());
					isFound=true;
				}

			}

			if(!isFound){
				return false;
			}
		}	

		return true;
		
	
	}
	
	
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str = str.toLowerCase();

		for(int i = 0; i<str.length();i++){
			if(str.charAt(i) > 'z' || str.charAt(i) < 'a'){

				str = str.substring(0, i) + str.substring(i+1, str.length()); // removes char at index i from the string 
				i--;
			}
		}
		return str;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {

		String strMixed = "";
		int random;
		while(str.length()!=0){
			random = (int)(Math.random()* str.length());
			strMixed+= str.charAt(random);
			str = str.substring(0, random) + str.substring(random+1, str.length());
		
		}
		return strMixed;
	}
}
