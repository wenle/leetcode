package jianzhioffer;

/**
 * date 17/7/17
 *
 * @author wenle
 */
public class Question4 {

    public static String replaceSpace(String str) {

        int count = 0;
        char[] sourceArray = str.toCharArray();
        for(char c : sourceArray) {
            if(c == ' ') {
                count++;
            }
        }
        char[] targetArray = new char[str.length() + 2*count];

        int srcPos = sourceArray.length;
        int destPos = targetArray.length;
        while((--srcPos) >= 0) {
            if(sourceArray[srcPos] == ' ') {
                targetArray[destPos-3] = '%';
                targetArray[destPos-2] = '2';
                targetArray[destPos-1] = '0';
                destPos-=3;
            } else {
                targetArray[destPos-1] = sourceArray[srcPos];
                destPos--;
            }
        }
        return new String(targetArray);
    }

    public static void main(String[] args) {

        String s = replaceSpace(" abc  1   4 5  ");
        System.out.println(s);
    }
}
