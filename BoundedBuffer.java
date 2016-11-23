

import sun.awt.image.ImageWatched;

import java.util.*;
import java.util.concurrent.Semaphore;

/**
 * BoundedBuffer.java
 *
 * This program implements the bounded buffer with semaphores.
 * Note that the use of count only serves to output whether
 * the buffer is empty of full.
 */
public class BoundedBuffer implements Buffer   {

    private static final int BUFFER_SIZE = 2;
    private Semaphore mutex;
    private Semaphore empty;
    private Semaphore full;
    private int count;
    private int in, out;
 // private LinkedList buffer;
    private PriorityQueue buffer;

    public BoundedBuffer() {
        // buffer is initially empty
        count = 0;
        in = 0;
        out = 0;

      // buffer = new LinkedList();




        buffer = new PriorityQueue<Job>( new Comparator<Job>() {
            @Override
            public int compare(Job job1, Job job2) {
                if(job1.getType().equals("I/O)") && job2.getType().equals("CPU")){
                    return 1;
                }else if(job2.getType().equals("I/O)") && job1.getType().equals("CPU") ){
                    return -1;
                }
                return 0;
            }
        });

        mutex = new Semaphore(1);
        empty = new Semaphore(BUFFER_SIZE);
        full = new Semaphore(0);
    }

    // producer calls this method
    public void insert(Job item) {
        try {
            empty.acquire();
            mutex.acquire();
        } catch (Exception e) {
        }
        // add an item to the buffer
        ++count;
        buffer.add(item);
        in = (in + 1) % BUFFER_SIZE;

        if (count == BUFFER_SIZE) {
            System.out.println("Producer Entered " + item + " Buffer FULL");
        } else {
            System.out.println("Producer Entered " + item + " Buffer Size = " + count);
        }

        mutex.release();
        full.release();
    }

    // consumer calls this method
    public Object remove() {
        try {
            full.acquire();
            mutex.acquire();
        } catch (Exception e) {
        }


        // remove an item from the buffer
        --count;
       Job item = (Job) buffer.peek();

        buffer.remove();
        out = (out + 1) % BUFFER_SIZE;

        if (count == 0) {
            System.out.println("Consumer Consumed " + item + " Buffer EMPTY");
        } else {
           System.out.println("Consumer Consumed " + item + " Buffer Size = " + count);
        }

        mutex.release();
        empty.release();

        return item;
    }
}
