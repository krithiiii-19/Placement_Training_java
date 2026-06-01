import java.util.*;

public class GroupAnagram {
    
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            
            String key = Arrays.toString(count);
            
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] inp = {"eat", "tea", "tan", "ate", "nat", "bat"};
        
        List<List<String>> groupedAnagrams = groupAnagrams(inp);
        
        System.out.println("Grouped Anagrams:");
        for (List<String> group : groupedAnagrams) {
            System.out.println(group);
        }
    }
}