/**
 * date 17/3/8
 *
 * @author wenle
 * @see https://leetcode.com/problems/longest-common-prefix/?tab=Description
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }

        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            commonPrefix = getCommonPrefix(commonPrefix, strs[i]);
        }
        return commonPrefix;
    }

    private String getCommonPrefix(String str1, String str2) {

        int len = Math.min(str1.length(), str2.length());
        int prefixLen = 0;
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                prefixLen ++;
            } else {
                break;
            }
        }
        return str1.substring(0, prefixLen);
    }

    public static void main(String[] args) {

        String[] strs = new String[]{"12345", "123", "1234"};
        LongestCommonPrefix l = new LongestCommonPrefix();

        System.out.println(l.longestCommonPrefix(strs));
    }

}
