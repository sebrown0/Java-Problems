/**
 * 
 */
package chapter_1.probs_4_x;

import  static java.util.Map.Entry.comparingByValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;;

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
	
	// problem 11
	public static boolean isPalindrome(String str) {		
		return str.equals(new StringBuilder(str).reverse().toString());
	}
	public static boolean checkForPalindrome(int left, String str) {
		int strLen = str.length();
		
		if(left >= (strLen / 2)) {
			return true;
		}else if(str.charAt(left) == str.charAt(strLen - left - 1)) {
			checkForPalindrome(++left, str);
		}
		return false;
	}
	
	// problem 12
	public static String removeDuplicateChars(String str) {		
		StringBuilder sb = new StringBuilder();
		List<Character> chars = new ArrayList<>();
		
		for(char c: str.toCharArray()) {
			if(chars.contains(c) == false) {
				sb.append(c);
				chars.add(c);
			}
		}
		return sb.toString();
	}
	public static String removeDuplicateChars_Java8(String str) {		
		return 
			Arrays.asList(str.split("")).stream()
				.distinct()
				.collect(Collectors.joining());
	}
	
	// problem 13
	public static String removeGivenChars(String str, char... remove) {
		StringBuilder sb = new StringBuilder();
		List<Character> charsToRem = new ArrayList<>();
		
		for(char c : remove) {
			charsToRem.add(c);
		}
		
		for(char c : str.toCharArray()) {
			if(charsToRem.contains(c) == false) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	public static String removeGivenChars_Java8(String str, char... remove) {		
		List<Character> charsToRem = new ArrayList<>();
		
		for(char c : remove) {
			charsToRem.add(c);
		}
		
		return str.chars()
				.filter(c -> charsToRem.contains((char)c) == false)			
				.mapToObj(c -> String.valueOf((char)c))			
				.collect(Collectors.joining());		
	}
	
	// problem 14
	public static char charThatAppearsTheMost(String str) {
		char res = 0;
		Map<Character, Integer> charCount = new HashMap<>();
		int maxVal = -1;
		
		for(char c : str.toCharArray()) {			
			charCount.compute(c, (k, v) -> (v == null) ? 1 : ++v);							
		}
		
		for(Map.Entry<Character, Integer> e : charCount.entrySet()) {
			if(e.getValue() > maxVal) {
				res = e.getKey();
				maxVal = e.getValue();
			}
		}

		return res;
	}	
	public static char charThatAppearsTheMost_Java8(String str) {
		return str.chars()
			.filter(c -> !Character.isWhitespace(c))
			.mapToObj(c -> (char) c)
			.collect(Collectors.groupingBy(c -> c, Collectors.counting()))
		    .entrySet()
		    .stream()
		    .max(comparingByValue())
		    .map(p -> p.getKey())		    
		    .orElse(Character.valueOf((char) 0));		
	}
	
	// problem 15
	public static void sortStringsByLen(String...strings) {
		Map<Integer, List<String>> sorted = new HashMap<>();				
		
		for(String s: strings) {
			Integer len = Integer.valueOf(s.length());
			sorted.compute(len, 
				(k,v) -> {
					List<String> lst;
					if(v == null) { 
						lst = new ArrayList<String>();
						lst.add(s);
						return lst;
					}else {
						lst = sorted.get(len);
						lst.add(s);						
						return lst;
					}});
		}
	}

	// problem 16
		public static boolean stringContainsSubStr(String str, String subStr) {		
			return str.contains(subStr);
		}
		
	// problem 17
	public static int countOccursOfSubStringInStr(String str, String toFind) {
		  int position = 0;
		  int count = 0;
		  int n = toFind.length();

		  while ((position = str.indexOf(toFind, position)) != -1) {
		    position = position + n;
		    count++;
		  }
		  return count;
	}
	
	// problem 18
	public static boolean isAnagram(String word, String toFind) {
		int idx;
		StringBuilder sb = new StringBuilder(word.toLowerCase().replace(" ", ""));
		
		for(char c : toFind.toLowerCase().replace(" ", "").toCharArray()) {
			idx = sb.indexOf(String.valueOf(c));
			if(idx >= 0) {
				sb.deleteCharAt(idx);
			}else {
				return false;
			}
		}
		return true;
	}
	
}
