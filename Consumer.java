

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
    public static ArrayList averageServiceTimeIO = new ArrayList();
    public static ArrayList averageServiceTimeCPU = new ArrayList();
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

                    busyTime = busyTime + 5;
                    long serviceTimeStartIO = System.currentTimeMillis();
                    SleepUtilities.nap(5);
                    long serviceTimeEndIO = System.currentTimeMillis();

                    long tempServiceTimeIO = serviceTimeEndIO - serviceTimeStartIO ;
                    if (maxServiceTimeIO < tempServiceTimeIO) {
                        maxServiceTimeIO = tempServiceTimeIO;
                    }
                    averageServiceTimeIO.add(tempServiceTimeIO);

                    //subtract 50 to shift everything to line everything up properly
                    long tempWait =( (serviceTimeStartIO - job.getArrivialTime()) - job.getSleepTime() * 10 );

                    if (maxWaitTimeTotalIO < tempWait) {
                        maxWaitTimeTotalIO = tempWait;
                    }
                    averageWaitTimeIO.add(tempWait);

                    long tempTurnAroundTimeIO = tempWait + tempServiceTimeIO  ;
                    averageTurnAroundTimeIO.add(tempTurnAroundTimeIO);

                    if (maxTurnAroundTimeIO < tempTurnAroundTimeIO) {
                        maxTurnAroundTimeIO = tempTurnAroundTimeIO;
                    }


                    countIO++;


                } else {
                    System.out.println("Consumer napping for 50");
                    System.out.println("Consumer consumed job:" + job + " " + job.getType());

                    busyTime = busyTime + 50;
                    long serviceTimeStartCPU = System.currentTimeMillis();
                    SleepUtilities.nap(50);
                    long serviceTimeEndCPU = System.currentTimeMillis();
                    long tempServiceTimeCPU = serviceTimeEndCPU - serviceTimeStartCPU;
                    averageServiceTimeCPU.add(tempServiceTimeCPU);

                    if (maxServiceTimeCPU < tempServiceTimeCPU) {
                        maxServiceTimeCPU = tempServiceTimeCPU;
                    }

                    long tempWait = ( (serviceTimeStartCPU - job.getArrivialTime()));

                    averageWaitTimeCPU.add(tempWait);
                    if (maxWaitTimeTotalCPU < tempWait) {
                        maxWaitTimeTotalCPU = tempWait;
                    }
//
                    long tempTurnAroundTimeCPU =  tempServiceTimeCPU + tempWait;

                    averageTurnAroundTimeCPU.add(tempTurnAroundTimeCPU);
                    if (maxTurnAroundTimeCPU < tempTurnAroundTimeCPU) {
                        maxTurnAroundTimeCPU = tempTurnAroundTimeCPU;
                    }




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


