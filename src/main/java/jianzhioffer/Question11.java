package jianzhioffer;

/**
 * date 17/7/23
 *
 * @author wenle
 */
public class Question11 {

    public static double power(double base, int exponent) {

        if (equals(base, 0.0) && exponent < 0) {
            throw new RuntimeException("0 exp with negative");
        }

        if (exponent < 0) {
            return 1.0 / powerWithUnsignedExponent(base, -exponent);
        } else {
            return powerWithUnsignedExponent(base, exponent);
        }

    }

    public static double powerWithUnsignedExponent2(double base, int exponent) {

        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        if ((exponent & 1) == 1) {
            return base * powerWithUnsignedExponent2(base, exponent - 1);
        } else {
            double tmp = powerWithUnsignedExponent2(base, exponent >> 1);
            return tmp * tmp;
        }


    }

    public static double powerWithUnsignedExponent(double base, int exponent) {

        double result = 1.0;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static boolean equals(double a, double b) {

        if ((a - b) < 0.0000001 && (a - b) > -0.0000001) {
            return true;
        } else {
            return false;
        }

    }

}
