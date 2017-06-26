import java.util.HashMap;
import java.util.Map;

/**
 * date 17/2/27
 *
 * @see https://leetcode.com/problems/longest-substring-without-repeating-characters/?tab=Description
 * @author wenle
 */
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0) {
            return 0;
        }
        int startIndex = 0;
        int maxLength = 1;
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {

            Character current = s.charAt(i);
            if(map.containsKey(current) && map.get(current) >= startIndex) { // duplicate character found
                startIndex = map.get(current) + 1;
            } else {
                int currentLength = i - startIndex + 1;
                if(currentLength > maxLength) {
                    System.out.println("i: " +i + "; currentLength: " + currentLength + "; startIndex: " + startIndex);
                    maxLength = currentLength;
                }
            }
            map.put(current, i);
        }
        return maxLength;
    }

    public static void main(String[] args) {

        System.out.println(new LongestSubstring().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubstring().lengthOfLongestSubstring("pwwkew"));
    }
}
