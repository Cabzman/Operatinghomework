import java.util.ArrayList;

/**
 * This creates the buffer and the producer and consumer threads.
 *
 */
public class Factory {

    public static void main(String args[]) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Buffer server = new BoundedBuffer();
        Statistics stats = new Statistics();
        ThreadGroup threadgroup = new ThreadGroup("");


        // now create the producer and consumer threads
        Thread producerThread = new Thread(threadgroup, new Producer(server,"I/O"));
        Thread producerThread0 = new Thread(threadgroup, new Producer(server,"CPU"));
        Thread consumerThread1 = new Thread(threadgroup, new Consumer(server));
      //  Thread consumerThread2 = new Thread(new Consumer(server));
        producerThread.start();
        producerThread0.start();
        consumerThread1.start();
      //  consumerThread2.start();

        Thread.sleep(10000);
        threadgroup.interrupt();

        long endTime = System.currentTimeMillis();
        stats.processorThroughput(startTime,endTime,Consumer.totalJobsConsumer);
        stats.processorUtilization(startTime,endTime,Consumer.busyTime);
        //Service time needs to be worked on, should equal the time the process ran.


        stats.averageServiceTimeIO(Consumer.averageServiceTimeIO);
        stats.averageServiceTimeCPU(Consumer.averageServiceTimeCPU);

        stats.maxServiceTimeIO(Consumer.maxServiceTimeIO);
        stats.maxServiceTimeCPU(Consumer.maxServiceTimeCPU);

        stats.maxWaitTimeCPU(Consumer.maxWaitTimeTotalCPU);
        stats.maxWaitTimeIO(Consumer.maxWaitTimeTotalIO);
//
        stats.averageWaitTimeCPU(Consumer.averageWaitTimeCPU);
        stats.averageWaitTimeIO(Consumer.averageWaitTimeIO);
//
        stats.averageTurnAroundTimeCPU(Consumer.averageTurnAroundTimeCPU);
        stats.averageTurnAroundTimeIO(Consumer.averageTurnAroundTimeIO);
//
        stats.maxTurnAroundTimeCPU(Consumer.maxTurnAroundTimeCPU);
        stats.maxTurnAroundTimeIO(Consumer.maxTurnAroundTimeIO);


        System.exit(0);
    }
}
