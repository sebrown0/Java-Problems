package chapter_1.non_repeating;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author SteveBrown
 */
public class NonRepeatingChecker {
	private String str;
	
	private Character currChar;	
	private List<Character> nonRepeating;
	
	public NonRepeatingChecker(String str) {
		this.str = str;
	}

	private void init() {
		nonRepeating = new ArrayList<>();
	}
	
	public void computeUsingList() {
		init();
		
		for(int idx=0; idx < str.length(); idx++) {
			currChar = str.charAt(idx);
			if(nonRepeating.contains(currChar) == false) {
				nonRepeating.add(currChar);					
			}	else {
				nonRepeating.remove(currChar);
			}			
		}	
	}
			
	public void computeUsingCodePoints() {
		init();
		
		// Count the code point and assign to map: k = code point, v = num occurs. 
	  Map<Integer, Long> chs = str.codePoints()	  	
	    .mapToObj(cp -> cp)	    
	    .collect(Collectors.groupingBy(Function.identity(),
	      LinkedHashMap::new, Collectors.counting()));

	  // Get the code point with occurrence that occurs first  
	  int cp = chs.entrySet().stream()
	   .filter(e -> e.getValue() == 1L)
	   .findFirst()
	   .map(Map.Entry::getKey)
	   .orElse(Integer.valueOf(Character.MIN_VALUE));

	  nonRepeating.add(Character.toChars(cp)[0]);	   	
	}
	
	public Optional<Character> getFirstNonRepeatingChar(){
		return (nonRepeating.size() > 0) ? Optional.of(nonRepeating.get(0)): Optional.empty();
	}
	
}
