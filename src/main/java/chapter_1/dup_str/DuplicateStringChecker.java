/**
 * 
 */
package chapter_1.dup_str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author SteveBrown
 */
public class DuplicateStringChecker {
	private String str;
	
	private String currChar;
	private List<String> chars;
	private Map<String, Integer> duplicates;
	
	public DuplicateStringChecker(String str) {
		this.str = str;
	}
	
	private void init() {
		chars = new ArrayList<>();
		duplicates = new HashMap<>();
	}
	public void computeInBasicWay() {
		init();		
		
		for(int idx=0; idx < str.length(); idx++) {
			currChar = String.valueOf(str.charAt(idx));
			if(chars.contains(currChar)) {
				if(duplicates.containsKey(currChar)) {					
					duplicates.put(currChar, duplicates.get(currChar)+1);					
				}else {
					duplicates.put(currChar, 1);
				}
			}else {
				chars.add(currChar);
			}
		}
	}
	
	public void computeWithCompute() {
		init();
		
		for(int idx=0; idx < str.length(); idx++) {
			currChar = String.valueOf(str.charAt(idx));
			if(chars.contains(currChar)) {
				duplicates.compute(currChar, (k,v) -> {
					return v == null ? 1 : ++v;
				});
			}else {
				chars.add(currChar);
			}
		}
	}
	
	
	public long getTotalNumberOfDuplicates() {
		long res = 0;
		
		for (Entry<String, Integer> entry : duplicates.entrySet()) {
			res += entry.getValue();
		}
		return res;
	}
	
}
