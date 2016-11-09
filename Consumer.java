

/**
 * This is the consumer thread for the bounded buffer problem.
 */

import java.util.*;


public class Consumer implements Runnable {
    long start;

    int countIO;

    //CPU utilization
    public static int busyTime;


    //Average service time
    public static ArrayList averageTimeIO = new ArrayList();
    public static ArrayList averageTimeCPU = new ArrayList();
    //Max service Time
    public static long maxServiceTimeIO = 0;
    public static long maxServiceTimeCPU = 0;
    //average wait time
    public static ArrayList averageWaitTimeCPU = new ArrayList();
    public static ArrayList averageWaitTimeIO = new ArrayList();
    //max wait time
    public static long maxWaitTimeTotalIO = 0;
    public static long maxWaitTimeTotalCPU = 0;


    //average turn around time
    public static ArrayList averageTurnAroundTimeIO = new ArrayList();
    public static ArrayList averageTurnAroundTimeCPU = new ArrayList();
    //max turnaround time
    public static long maxTurnAroundTimeIO = 0;
    public static long maxTurnAroundTimeCPU = 0;

    public static int totalJobsConsumer = 0;


    public Consumer(Buffer b) {
        buffer = b;

    }

    public void run() {


        Job job;
        String type;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                totalJobsConsumer++;
                start = System.currentTimeMillis();
                job = (Job) buffer.remove();

                job.setServiceCompletionTime();
                type = job.getType();

                if (type == ("I/O")) {
                    System.out.println("Consumer napping for 5");
                    System.out.println("Consumer consumed job:" + job + " " + job.getType());
                    long waitTimeEndIO = System.currentTimeMillis();
                    busyTime = busyTime + 5;
                    SleepUtilities.nap(5);
                    long turnAroundTimeIOend = System.currentTimeMillis();

                    long temp = turnAroundTimeIOend - waitTimeEndIO;
                    if (maxServiceTimeIO < temp) {
                        maxServiceTimeIO = temp;
                    }
                    averageTimeIO.add(temp);

                    long tempWait = waitTimeEndIO - job.getProcessStart();
                    if (maxWaitTimeTotalIO < tempWait) {
                        maxWaitTimeTotalIO = tempWait;
                    }
                    averageWaitTimeIO.add(tempWait);

                    long tempTurnAroundTimeIO = turnAroundTimeIOend - job.getProcessStart();
                    averageTurnAroundTimeIO.add(tempTurnAroundTimeIO);

                    if (maxTurnAroundTimeIO < tempTurnAroundTimeIO) {
                        maxTurnAroundTimeIO = tempTurnAroundTimeIO;
                    }


                    countIO++;


                } else {
                    System.out.println("Consumer napping for 50");
                    System.out.println("Consumer consumed job:" + job + " " + job.getType());
                    long waitTimeEndCPU = System.currentTimeMillis();
                    busyTime = busyTime + 50;
                    SleepUtilities.nap(50);
                    long turnAroundTimeCPUend = System.currentTimeMillis();
                    long temp = System.currentTimeMillis() - waitTimeEndCPU;
                    averageTimeCPU.add(temp);
                    if (maxServiceTimeCPU < temp) {
                        maxServiceTimeCPU = temp;
                    }
                    long tempWait = waitTimeEndCPU - job.getProcessStart();
//
                    if (maxWaitTimeTotalCPU < tempWait) {
                        maxWaitTimeTotalCPU = tempWait;
                    }
//

                    averageWaitTimeCPU.add(tempWait);
//
                    long tempTurnAroundTimeCPU = turnAroundTimeCPUend - job.getProcessStart();

                    averageTurnAroundTimeCPU.add(tempTurnAroundTimeCPU);
                    if (maxTurnAroundTimeCPU < tempTurnAroundTimeCPU) {
                        maxTurnAroundTimeCPU = tempTurnAroundTimeCPU;
                    }


//                    countCPU++;

                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                break;
            }


            // consume an item from the buffer
            //System.out.println("Consumer wants to consume.");


        }
    }

    private Buffer buffer;
}


