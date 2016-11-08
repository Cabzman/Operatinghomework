

/**
 * This is the consumer thread for the bounded buffer problem.
 */
import java.util.*;

public class Consumer implements Runnable {

    public Consumer(Buffer b) {
        buffer = b;
    }

    public void run() {
        Job job;
        String type;
        while (true) {
            job = (Job) buffer.remove();
            job.setServiceCompletionTime();
            type = job.getType();
            System.out.println("Consumer napping");
            if (type == ("I/O")) {
                SleepUtilities.nap(5);
            }else{
                SleepUtilities.nap(50);
            }


            // consume an item from the buffer
            System.out.println("Consumer wants to consume.");


            System.out.println("Consumer received message:" + job);


        }
    }
    private Buffer buffer;
}


