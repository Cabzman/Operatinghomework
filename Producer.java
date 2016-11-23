

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
                    System.out.println("Producer napping for random amount of time based off 10");
                    int temp = (int) (100* -Math.log(Math.random()));
                    SleepUtilities.nap(3);
                } else {
                    System.out.println("Producer napping for random amount of time based off 100");
                    int temp = (int) (100 * -Math.log(Math.random()));
                    SleepUtilities.nap(30);
                }


                // produce an item & enter it into the buffer
                job = new Job(jobType);
                System.out.println("Producer produced " + job + " " + job.getType().toString());
                if (job.getType() == "I/O"){
                    job.sleepTime(3);
                }else{
                    job.sleepTime(30);
                }
                job.arrivialTime();
                buffer.insert(job);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

        private Buffer buffer;
    }

