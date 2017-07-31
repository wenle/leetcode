package jianzhioffer;

import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * date 17/7/31
 * <p>
 * Question 21
 *
 * @author wenle
 */
public abstract class StackWithMin<T> {


    private Stack<T> dataStack;
    private Stack<T> minStack;

    public StackWithMin() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public abstract Comparator<T> getComparator();


    public void push(T node) {

        T min = node;
        if (!dataStack.empty()) {
            T peek = dataStack.peek();
            min = (getComparator().compare(node, peek) < 0) ? node : peek;
        }
        minStack.push(min);
        dataStack.push(node);

    }

    public T pop() {

        if (dataStack.empty()) {
            throw new EmptyStackException();
        }

        minStack.pop();
        return dataStack.pop();
    }

    public T min() {

        if (dataStack.empty()) {
            throw new EmptyStackException();
        }
        return minStack.peek();
    }

}
