package jianzhioffer;

/**
 * date 17/7/23
 *
 * @author wenle
 */
public class Question12 {


    public static final char[] integers = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};


    public static void printAll(int n) {

        char[] number = new char[n];
        print(n-1, number);
    }

    public static void print(int m, char[] number) {

        if(m < 0) {
            boolean flag = false;
            for(char c : number) {
                if(c > '0') {
                    flag = true;
                }
                if(flag) {
                    System.out.print(c);
                }
            }
            System.out.println();
            return;
        }
        for(char c : integers) {
            number[m] = c;
            print(m-1, number);
        }
    }

    public static void main(String[] args) {

        printAll(3);
    }
}

