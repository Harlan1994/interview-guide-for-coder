package com.harlan.chapter01;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/8/17
 * Time: 14:57
 * Description: 两个栈实现一个队列
 */
public class QueueWithTwoStack {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public QueueWithTwoStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // 入队
    public void add(Integer value) {
        stack1.push(value);
    }

    // 出队
    // 出队必须保证，先进的先出去，那么stack1中栈底是要先出去的，stack2中应该是栈顶元素先出去
    // 而对于stack1和stack2中的元素，stack1中的元素必然是后进的，也应该是后出去
    public Integer poll() {
        if (isEmpty()) {
            return null;
        }
        if (stack2.isEmpty()) { // 如果为空
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueWithTwoStack queueWithTwoStack = new QueueWithTwoStack();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int op = Integer.parseInt(scanner.nextLine());
            if (op == 1) { // 入队
                int value = Integer.parseInt(scanner.nextLine());
                queueWithTwoStack.add(value);
            } else if(op == 2) { // 出队
                Integer poped = queueWithTwoStack.poll();
                System.out.println(poped);
            }
        }
    }
}
