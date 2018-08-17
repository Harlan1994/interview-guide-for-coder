package com.harlan.chapter01;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/8/16
 * Time: 16:11
 * Description: 实现一个栈，使其拥有获取当前栈中最小值的功能
 */
public class GetMinStack {

    Stack<Integer> dataStack, minStack;

    public GetMinStack() {
        this.dataStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    // 出栈
    // 出栈需要考虑当前出栈元素是否是当前最小的，如果是，那说明当前最小的已经没了，需要出栈minStack
    public Integer pop() {
        if (!this.dataStack.isEmpty() && !this.minStack.isEmpty()) {
            if (this.dataStack.peek() == this.minStack.peek()) {
                this.minStack.pop();
            }
            System.out.println("Current minimum: " + getMin());
            return this.dataStack.pop();
        }
        return null;
    }

    // 入栈
    // 入栈需要考虑新入栈的元素是否是当前最小，如果是，那么需要更新minStack
    public void push(Integer value) {

        this.dataStack.push(value);

        // 如果入栈的值小于等于当前最小值
        // 为何等于当前最小值的时候也要入栈呢？因为minStack需要记录每一次入栈出栈时的当前最小值
        // 如果不入栈，那么每次一个最小值pop的时候，必须删掉一个，可能会造成错误，因为很可能dataStack还有相同的数
        if (this.minStack.isEmpty()) {
            this.minStack.push(value);
        } else {
            if (value <= this.minStack.peek()) {
                this.minStack.push(value);
            }
        }

        System.out.println("Current minimum: " + getMin());
    }

    // 获取当前最小，只需要获取栈顶元素即可
    public Integer getMin() {
        if (!this.minStack.isEmpty()) {
            return this.minStack.peek();
        }
        return null;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GetMinStack getMinStack = new GetMinStack();
        while (true) {
            int value = Integer.parseInt(scanner.nextLine());
            if (value == 1) { // push
                getMinStack.push(Integer.parseInt(scanner.nextLine()));
            } else if (value == 2) {
                getMinStack.pop();
            }
        }
    }
}
