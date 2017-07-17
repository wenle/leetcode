package jianzhioffer;

/**
 * date 17/7/17
 *
 * @author wenle
 */
public class Singleton {

    private Singleton() {

    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}
