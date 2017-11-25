
public class RecursiveMethods {

	public static void main(String[] args) {
		//TEST C-5.13
		int result = recursiveProduct(3,3);	
		System.out.println("A recursive product: " + result);
		
		//TEST C-5.18
		String string1 = "gohangasalamiimalasagnahog";		//Add g on front and it is
		boolean isPalindrome = isPalindrome(string1);
		System.out.println("Result of palindrome testing: " + isPalindrome);
		
		//TEST C-5.19
		String string2 = "aaaabcssd";								//Add more vowels
		boolean hasMoreVowels = hasMoreVowels(string2, 0, 0, 0);
		System.out.println("More Vowels than Consonants?: " + hasMoreVowels); 
		
		//TEST C-5.30
		int numberOfDiscs = 3;
		towersOfHanoi(1, 2, 3, numberOfDiscs);
	}

//C-5.13
//Recursive algorithm used to compute the product of two positive integers, m and n,
//using only addition and subtraction
	
//Algorithm: recursiveProduct(int m, int n)
//Input: two integers, m and n, to be multiplied together
//Output: the product of m and n
	//if n==0 || m==0 then
	    //return 0;
	//else if n < 0 || m < 0 then
	   //throw exception because we are only allowing positive numbers
	//else do
	  // return recursive call to function passed m and n-1 added to m

	public static int recursiveProduct(int m, int n) throws UnsupportedOperationException
	{
	  //Anything multiplied by 0 is 0.
	  if(n == 0 || m == 0) {
		    return 0;
	  }
		//This method does not support negative arguments
		else if(n < 0 || m < 0) {
		    throw new UnsupportedOperationException("Only accepts nonnegative inputs.");
		}
		//This instance is the base case. As well as the 
		//main branch of the recursion.
		//When n is 1, the recursion should stop because
		//a number multiplied by one is the number itself.
		else
		{
			return m + recursiveProduct(m, (n - 1));
		}
		
	}
	
//C-5.18
//Recursive Java method that determines if a string is a palindrome
	public static boolean isPalindrome(String s)
	{
	    //This is the base case and the input validation. Both nothing and one
		//are the same forwards and backwards in my mind. Additionally, for the 
		//program to work, the base case needs to be considered true.
	    if(s.length() == 0 || s.length() == 1)
		    return true;
		//Check the first position and the last position indices for equivalence.	
		else if(s.charAt(0) == s.charAt(s.length()-1)) {
		    return isPalindrome(s.substring(1, s.length()-1));
		}
		//If neither of these first two cases is true, then it is necessarily false.
		else
		    return false;
	}


//C-5.18
//Recursive Java method that determines if a string has more
//vowels than consonants
	public static boolean hasMoreVowels(String s, int index, int vowelCount, 
										int consonantCount) throws UnsupportedOperationException
	{
	  if(index < s.length() && s.toUpperCase().charAt(index) >= 'A' && 
		                             s.toUpperCase().charAt(index) <= 'Z') {
		    switch (s.toUpperCase().charAt(index)) {
			    case 'A':
				case 'E':
				case 'I':
				case 'O':
				case 'U':
				    vowelCount++;
				break;
				default:
				    consonantCount++;
			}
			index++;
			return hasMoreVowels(s, index, vowelCount, consonantCount);
		} 
	  else if(index == s.length())
		    if (vowelCount > consonantCount) {
			    return true;
				}
			else
			    return false;
	  else
		  return false;
	}
	
//P-5.30
//A recursive method for solving the Towers of Hanoi puzzle
	public static void towersOfHanoi(int startPeg, int middlePeg, int goalPeg, int numberOfDiscs) {
		if (numberOfDiscs == 1)
		{
			System.out.println("Move disc from peg " + startPeg + " to peg " + goalPeg);
		}
		else {
			towersOfHanoi(startPeg, goalPeg, middlePeg, (numberOfDiscs)-1);
			System.out.println("Move disc from peg " + startPeg + " to peg " + goalPeg);
			towersOfHanoi(middlePeg, startPeg, goalPeg, (numberOfDiscs)-1);
		}
	}
}

