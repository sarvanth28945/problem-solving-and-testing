import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Convert string to character array and sort it
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = String.valueOf(charArray);

            // Put into hashmap
            map.putIfAbsent(sortedKey, new ArrayList<>());
            map.get(sortedKey).add(s);
        }

        // Return all values as a list of lists
        return new ArrayList<>(map.values());
    }
}
