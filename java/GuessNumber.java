/**
 * date 17/3/8
 *
 * @author wenle
 * @see https://leetcode.com/problems/guess-number-higher-or-lower/?tab=Description
 */
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class GuessNumber {

    private int secret;

    public void setSecret(int x) {
        this.secret = x;
    }

    int guess(int num) {

        if(secret < num) {
            return -1;
        }
        if(secret > num) {
            return 1;
        }
        return 0;
    }

    public int guessNumber(int n) {

        int left = 1;
        int right = n;

        while(right > left) {

            int middle = left + (right - left) / 2; // key point
            int guessMiddle = guess(middle);
            if(guessMiddle < 0) {
                right = middle-1; // do best efforts to narrow the range
                continue;
            }
            if(guessMiddle > 0) {
                left = middle + 1;
                continue;
            }
            if(guessMiddle == 0) {
                return middle;
            }
        }
        return right;
    }

    public static void main(String[] args) {

        GuessNumber guess1 = new GuessNumber();
        guess1.setSecret(63);
        System.out.println(guess1.guessNumber(100));


        GuessNumber guess2 = new GuessNumber();
        guess2.setSecret(Integer.MAX_VALUE);
        System.out.println(guess2.guessNumber(Integer.MAX_VALUE));



        GuessNumber guess3 = new GuessNumber();
        guess3.setSecret(1);
        System.out.println(guess3.guessNumber(10));
    }
}
