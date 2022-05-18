package com.company;

public class SimpleLinkedList<Integer> {

    public static class SimpleLinkedListException extends Exception {
        public SimpleLinkedListException(String message) {
            super(message);
        }
    }

    private class SimpleLinkedListNode {
        public int value;
        public SimpleLinkedListNode next;

        public SimpleLinkedListNode(int value, SimpleLinkedListNode next) {
            this.value = value;
            this.next = next;
        }

        public SimpleLinkedListNode(int value) {
            this(value, null);
        }
    }

    private SimpleLinkedListNode head = null;
    private SimpleLinkedListNode tail = null;
    private int size;

    public void addFirst(int value) {
        head = new SimpleLinkedListNode(value, head);
        if(size == 0){
            tail = head;
        }
        size++;
    }

    public void addLast(int value) {
        if (size == 0) {
            head = tail = new SimpleLinkedListNode(value);
        } else {
            tail.next = new SimpleLinkedListNode(value);
            tail = tail.next;
        }
        size++;
    }

    private void checkEmptyError() throws Exception {
        if (size == 0) {
            throw new SimpleLinkedListException("Empty List");
        }
    }

    private SimpleLinkedListNode getNode(int index) {
        SimpleLinkedListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public void removeFirst() throws Exception {
        checkEmptyError();
        head = head.next;
        if (size == 1) {
            tail = null;
        }
        size--;
    }

    public void removeLast() throws Exception {
        checkEmptyError();
        if (size == 1) {
            head = tail = null;
        } else {
            tail = getNode(size - 2);
            tail.next = null;
        }
    }

    public void remove(int index) throws Exception {
        checkEmptyError();
        if (index < 0 || index >= size) {
            throw new SimpleLinkedListException("Incorrect idex");
        }
        if (index == 0) {
            removeFirst();
        } else {
            SimpleLinkedListNode prev = getNode(index - 1);
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
            size--;
        }
    }

    public int getSize() {
        return size;
    }

    public int get(int index) throws Exception{
        checkEmptyError();
        return getNode(index).value;
    }

    public int getFirst() throws Exception{
        checkEmptyError();
        return head.value;
    }

    public int getLast() throws Exception{
        checkEmptyError();
        return tail.value;
    }

    public int getMin() throws Exception{
        checkEmptyError();
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (i >= 1 && i <= size - 2) {
                if (getNode(i - 1).value > getNode(i).value && getNode(i + 1).value > getNode(i).value) {
                    count++;
                }
            } else if (i == 0) {
                if (getNode(i).value < getNode(i + 1).value) {
                    count++;
                }
            } else if (i == size - 1) {
                if(getNode(i).value < getNode(i - 1).value) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getMax() throws Exception{
        checkEmptyError();
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (i >= 1 && i <= size - 2) {
                if (getNode(i - 1).value < getNode(i).value && getNode(i + 1).value < getNode(i).value) {
                    count++;
                }
            } else if (i == 0) {
                if (getNode(i).value > getNode(i + 1).value) {
                    count++;
                }
            } else if (i == size - 1) {
                if(getNode(i).value > getNode(i - 1).value) {
                    count++;
                }
            }
        }
        return count;
    }
}
