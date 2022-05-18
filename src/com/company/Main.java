package com.company;

public class Main {

    public static void main(String[] args) throws Exception {

        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.addFirst(1);
        list.addFirst(0);
        list.addFirst(0);
        list.addFirst(0);
        list.addFirst(1);
        list.addFirst(0);
        list.addFirst(1);
        list.addFirst(0);
        list.addFirst(1);
        list.addFirst(0);
        for (int i = 0; i < list.getSize(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.println("Кол-во локальных минимумов: " + list.getMin());
        System.out.println("Кол-во локальных максимумов: " + list.getMax());
    }
}
