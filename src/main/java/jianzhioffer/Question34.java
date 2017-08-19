package jianzhioffer;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * date 17/8/19
 *
 * @author 柏霜
 */
public class Question34 {

    private boolean isUglyNumber(int n) {

        while (n != 1 && n % 2 == 0) {
            n = n / 2;
        }

        while (n != 1 && n % 3 == 0) {
            n = n / 3;
        }

        while (n != 1 && n % 5 == 0) {
            n = n / 5;
        }
        return n == 1;
    }

    // 14 secs
    public int getNthUglyNumber(int n) {

        int i = 0;
        int number = 1;
        while (true) {
            if (isUglyNumber(number)) {
                i++;
                if(i == n) {
                    return number;
                } else {
//                    System.out.println("The " + i + "th ugly number: " + number);
                }
            }
            number++;
        }
    }

    private int findNextUglyByMultiple(List<Integer> uglyNumbers, int x) {

        int size = uglyNumbers.size();
        int currentMax = uglyNumbers.get(size -1); // 当前发现的最大丑数

        int start = currentMax/x; // 乘以x大于当前最大丑数的已知丑数,必须大于start
        for(int i=size-1;i>=0;i--) {

            if(uglyNumbers.get(i) <= start) {
                return uglyNumbers.get(i + 1) * x;
            }
        }
        return x;
    }

    // 10 mills
    public int getNthUglyNumber2(int n) {

        List<Integer> uglyNumbers = new ArrayList<>();
        uglyNumbers.add(1);

        while(uglyNumbers.size() < n) {
            int a = findNextUglyByMultiple(uglyNumbers, 2);
            int b = findNextUglyByMultiple(uglyNumbers, 3);
            int c = findNextUglyByMultiple(uglyNumbers, 5);
            int min = Math.min(Math.min(a, b), c);
//            System.out.println("The " + (uglyNumbers.size()+1) + "th ugly number: " + min);
            uglyNumbers.add(min);
        }

        return uglyNumbers.get(n-1);
    }

    // 5 mills
    public int getNthUglyNumber3(int n) {


        List<Integer> uglyNumbers = new ArrayList<>();
        uglyNumbers.add(1);
        int index = 1;

        int multiply2Index = 0;
        int multiply3Index = 0;
        int multiply5Index = 0;

        int nextNumber = 1;
        while(index < n) {

            while(uglyNumbers.get(multiply2Index) * 2 <= nextNumber) {

                multiply2Index++;
            }

            while(uglyNumbers.get(multiply3Index) * 3 <= nextNumber) {

                multiply3Index++;
            }

            while(uglyNumbers.get(multiply5Index) * 5 <= nextNumber) {

                multiply5Index++;
            }

            nextNumber = Math.min(uglyNumbers.get(multiply2Index) * 2, uglyNumbers.get(multiply3Index) * 3);
            nextNumber = Math.min(nextNumber, uglyNumbers.get(multiply5Index) * 5);
            uglyNumbers.add(nextNumber);
            index++;
        }
        return uglyNumbers.get(n-1);
    }

    public static void main(String[] args) {

        Question34 q = new Question34();

        LocalTime beginTime;
        long millis;

        beginTime = LocalTime.now();
        System.out.println(q.getNthUglyNumber3(1500));
        millis = Duration.between(beginTime, LocalTime.now()).toMillis();
        System.out.println("duration in mills: " + millis);
    }

}
