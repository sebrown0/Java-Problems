/**
 * 
 */
package chapter_1.probs_4_x;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author SteveBrown
 * Implement solutions for problems in chapter 1.
 * 
 * Problems solved are: 5 - X.
 * 
 */
public class ChapOneSolutions {	
	
	// problem 4
	public static boolean stringContainsOnlyDigits(String str) {		
		return str.matches("[0-9]+");
	}
	
	// problem 5
	private static int numConsts;
	private static int numVowels;
	
	public static void computeNumVowelsAndConsonants(String str) {
		numConsts=0;
		numVowels=0;		
		char[] chars = str.toLowerCase().toCharArray();
		for(char c: chars) {
			String strOfChar = String.valueOf(c);
			if(strOfChar.matches("[aeiou]")){
				numVowels++;
			}else if(c >= 'a' && c <= 'z') {
				numConsts++;
			}
		}		
	}
	public static int getNumConsts() {
		return numConsts;
	}
	public static int getNumVowels() {
		return numVowels;
	}
	
	// problem 6
	public static int getNumOccursOfCharInStr(char chr, String str) {
		int res = 0;
		String strValOfChar = String.valueOf(chr);
		char[] chars = str.toCharArray();
		
		for(char c: chars) {
			if(String.valueOf(c).equals(strValOfChar)) {
				res++;
			}
		}
		return res;
	}	
	public static long getNumOccursOfCharInStr_UisngStream(char chr, String str) {		
		return str.chars().filter(c -> c == chr).count();
	}
	
	// problem 7
	public static Long convertStrToLong(String s) {
		Long res = null;
		try {
			res = Long.parseLong(s);			
		} catch (NumberFormatException e) {
			res = Long.valueOf(-1);
		}
		return res;
	}
	
	// problem 8
	public static String removeWhiteSpace(String str) {
		return str.replaceAll("\\s","");
	}
	
	// problem 9
	public static String joinStringsWithDelimiter(String[] strings, String d) {		
		StringBuilder res = new StringBuilder();
		for(String s: strings) {
			res.append(s).append(d);
		}
		return  res.toString();
	}
	public static String joinStringsWithDelimiter_Java8(String[] strings, String d) {
		StringJoiner res = new StringJoiner(d);
		for(String s: strings) {
			res.add(s);
		}
		return  res.toString();
	}
	
	// problem 10
	public static void generateAllPermsOfString(String str){
		permuteAndPrint("", str);
	}
	private static void permuteAndPrint(String prefix, String str) {

	  int n = str.length();

	  if (n == 0) {
	    System.out.print(prefix + " ");
	  } else {
	    for (int i = 0; i < n; i++) {
	      permuteAndPrint(prefix + str.charAt(i),
	        str.substring(i + 1, n) + str.substring(0, i));
	    }
	  }
	}
	
//	private static void permuteAndPrint(String prefix, String str) {
//		int n = str.length();
//		
//		if(n == 0) {
//			System.out.println(prefix + " "); 	
//		}else {
//			for(int i = 0; i < n; i++) {
//				permuteAndPrint(prefix + str.charAt(i), str.substring(i+1, n) + str.substring(0, n));
//			}
//		}
//	}
	
//	public static List<String> generateAllPermsOfString(String str){
//		List<String> perms = new ArrayList<>();
//		int strLen = str.length();
////		char[] chars = str.toCharArray();
//		char temp;
//		
//		perms.add(str);
//		
//		for(int idx = 0; idx < strLen; idx++) {
//			char[] perm = str.toCharArray();
//			for(int jdx = idx; jdx < strLen-1; jdx++) {
//				temp = perm[jdx]; 
//				perm[jdx] = perm[jdx+1];
//				perm[jdx+1] = temp;
//				perms.add(String.valueOf(perm));
//			}
//		}
//		
//		perms.forEach(System.out::println);
//		return perms;
//	}
}
