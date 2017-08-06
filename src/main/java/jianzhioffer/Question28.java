package jianzhioffer;


/**
 * date 17/8/6
 *
 * @author wenle
 */
public class Question28 {


    public static void fullPermutations(char[] characters) {

        if (characters == null || characters.length == 0) {
            return;
        }
        arrange(characters, 0);
    }

    private static void arrange(char[] characters, int start) {

        int len = characters.length;
        if (start > len-1) {
            print(characters);
            return;
        }

        arrange(characters, start + 1);
        for (int i = start + 1; i < len; i++) {

            swap(characters, start, i);
            arrange(characters, start + 1);
            swap(characters, i, start); // eliminate the side effect of arrange
        }
    }

    private static void swap(char[] characters, int x, int y) {

        char temp = characters[y];
        characters[y] = characters[x];
        characters[x] = temp;
    }

    private static void print(char[] characters) {

        for (int i = 0; i < characters.length; i++) {
            System.out.print(characters[i]);
            if (i < characters.length - 1) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("array1:");
        char[] array1 = new char[] {'a', 'b', 'c', 'd'};
        fullPermutations(array1);

        System.out.println("array2:");
        char[] array2 = new char[] {};
        fullPermutations(array2);

    }


}
