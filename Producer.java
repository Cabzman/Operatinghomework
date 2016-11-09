

/**
 * This is the producer thread for the bounded buffer problem.
 */

import java.util.*;

public class Producer implements Runnable {





    String jobType;

    public Producer(Buffer b, String jobType) {
        buffer = b;
        this.jobType = jobType;
    }

    public void run() {
        Job job;

        while (!Thread.currentThread().isInterrupted()) {

            try {


                if (jobType.equals("I/O")) {
                    System.out.println("Producer napping for 10");
                    SleepUtilities.nap(10);
                } else {
                    System.out.println("Producer napping for 100");
                    SleepUtilities.nap(100);
                }


                // produce an item & enter it into the buffer
                job = new Job(jobType);
                System.out.println("Producer produced " + job + " " + job.getType().toString());

                buffer.insert(job);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

        private Buffer buffer;
    }

