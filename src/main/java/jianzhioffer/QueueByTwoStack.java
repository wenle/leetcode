package jianzhioffer;

import java.util.Stack;

/**
 * date 17/7/18
 *
 * @author wenle
 */
public class QueueByTwoStack<T> {


    private Stack<T> s1;
    private Stack<T> s2;


    public QueueByTwoStack(Stack<T> s1, Stack<T> s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public void appendTail(T node) {
        System.out.println("Append " + node);
        s1.push(node);
    }

    public T deleteHead() {
        if(s2.empty()) {
            while(!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        T pop = s2.pop();
        System.out.println("Deleted head: " + pop);
        return pop;
    }
    public void print() {

        System.out.println(s1);
        System.out.println(s2);
    }

    public static void main(String[] args) {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        QueueByTwoStack queue = new QueueByTwoStack(s1, s2);
        queue.appendTail(1);
        queue.print();
        queue.appendTail(2);
        queue.print();
        queue.deleteHead();
        queue.print();
        queue.deleteHead();
        queue.print();
        queue.appendTail(3);
        queue.print();
        queue.appendTail(4);
        queue.print();
        queue.appendTail(5);
        queue.print();
        queue.deleteHead();
        queue.print();
        queue.appendTail(6);
        queue.print();
    }

}
