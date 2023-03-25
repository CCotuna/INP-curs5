package treeMap;

import java.util.*;

public class CountingWords {

	public static TreeMap<String, Integer> countWords(String[] words){
		
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		System.out.println(words.length);
		for(int i = 0 ; i < words.length; i++) {
			
			String key = words[i].toLowerCase();
			
			if(words[i].length() > 1) {
				
				if(map.get(key) == null) {
					map.put(key, 1);
					
				}
				else
				{
					int value = map.get(key).intValue();
					value += 1; map.put(key, value);
				}
			}
		}
		return map;
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	
		
		String text = input.nextLine();
		String[] wordString = text.split(", ");
		
		input.close();
		System.out.println(countWords(wordString));
	}

}
