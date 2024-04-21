package Task2;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class RQ implements Iterable<Integer> {
    private Integer[] queue;
//    private boolean[] flags;
    private int front, back;
    private int count;
    private final int size;

    public RQ(int size) {
        if (size < 1)
            size = 1;
        this.size = size;
        this.queue = new Integer[size];
        front = back = -1;
        this.count = 0;
    }

    public int size() {
        return queue.length;
    }

    public void enqueue(int val) {
        if (isFull()) {
            System.out.println("\nQueue is full! Resizing... \n");
            resize();
        } else if (isEmpty()) {
            this.queue = new Integer[size];
            front++;
        }
        back++;
        queue[back] = val;
        count++;
    }

    public int dequeueRandom() {

        int pos = (int) Math.floor(Math.random() * (back - front + 1) + front);
        if (isEmpty())
            throw new NoSuchElementException();

        int tmp = queue[pos];
        System.out.println("Random remove: " + tmp);

        // THERE IS ONLY ONE ELEMENT
        if (pos == front && pos == back) {
            queue[front] = null;
            front = back = -1;

        } else if (pos == front) {
            queue[front] = null;
            front++;

        } else if (pos == back) {
            queue[back] = null;
            back--;

        // IF POS IS NEITHER FRONT NOR BACK
        } else {
            queue[pos] = queue[back];
            queue[back] = null;
            back--;
        }
        count--;
        return tmp;
    }

    public boolean isFull() {
        return back == queue.length-1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void resize() {
        Integer[] tmp = new Integer[queue.length*2];
        int i = 0;
        int j = front;

        do{
            tmp[i++] = queue[j];
            j = (j + 1) % queue.length;
        } while (j != front);

        back -= front;
        front = 0;
        queue = tmp;
    }

    public void printQueue() {
        System.out.println("--------------");
        for (Integer i : queue) {
            System.out.println(i);
        }
        System.out.println();
        System.out.println("FRONT:\t" + front);
        System.out.println("BACK:\t" + back);
        System.out.println("COUNT:\t" + count);
        System.out.println("--------------");
        System.out.println("\n\n");
    }

    @Override
    public java.util.Iterator<Integer> iterator() {
        return new RQ.Iterator();
    }

    private class Iterator implements java.util.Iterator<Integer> {

        int cn = count;
        int ft = front;
        int bk = back;


        @Override
        public boolean hasNext() {
            return cn != 0;
        }

        @Override
        public Integer next() {

            if (!hasNext())
                throw new NoSuchElementException();

            int pos = (int)Math.floor(Math.random() * (bk - ft + 1) + ft);
            int val = queue[pos];

            if (pos == ft && pos == bk) {
                ft = bk = -1;

            } else if (pos == ft) {
                ft++;

            } else if (pos == bk) {
                bk--;

            } else {
                queue[pos] = queue[bk];
                queue[bk] = val;
                bk--;
            }
            cn--;
            return val;
        }
    }


    // TEST
    public static void main(String[] args) {

        RQ rq = new RQ(5);

        // SHOW ENQUEUE WORKS
        System.out.println("Inserting 5 to 1");
        for (int i = 5; i >= 1; i--)
            rq.enqueue(i);

        rq.printQueue();

        System.out.println("Inserting 79 to 77");
        for (int i = 79; i >= 77; i--)
            rq.enqueue(i);

        rq.printQueue();

        // SHOW DEQUEUE AND ITERATOR
        System.out.println("Iterating twice over the queue before removing an element:");
        for (int i = 8; i > 0; i--) {
            System.out.println();

            // ITERATOR
            for (int j = 0; j < 2; j++) {
                for (Integer k : rq)
                    System.out.print(k + " ");
                System.out.println();
            }

            // DEQUEUE
            System.out.println();
            rq.dequeueRandom();
        }

        for (Integer j : rq) {
            System.out.println("DOWN HERE");
            System.out.println(j);
        }

        rq.printQueue();

        System.out.println("QUEUE SIZE:");
        System.out.println(rq.size());
    }
}
