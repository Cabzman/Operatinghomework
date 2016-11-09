import java.util.ArrayList;

/**
 * Created by mayer on 11/8/16.
 */
public class Statistics {
    private long averageServiceTimeIO = 0;
    private long averageServiceTimeCPU = 0;
    private long averageWaitTimeCPU = 0;
    private long averageWaitTimeIO = 0;
    private long maxServiceTimeIO = 0;
    private long maxServiceTimeCPU;
    private long maxWaitTimeCPU = 0;
    private long maxWaitTimeIO = 0;

    private long averageTurnAroundTimeIO = 0;
    private long averageTurnAroundTimeCPU = 0;
    private  long maxTurnAroundTimeIO = 0;
    private  long maxTurnAroundTimeCPU = 0;



    public void maxTurnAroundTimeIO(long number){
        maxTurnAroundTimeIO = number;
        System.out.println("The max turn around time IO is : " + maxTurnAroundTimeIO);
    }

    public void maxTurnAroundTimeCPU(long number){
        maxTurnAroundTimeCPU = number;
        System.out.println("The max turn around time CPU is : " + maxTurnAroundTimeCPU);
    }




    public void maxWaitTimeCPU(long number) {
        maxWaitTimeCPU = number;
        System.out.println("The max wait time for CPU is " + maxWaitTimeCPU);
    }

    public void maxWaitTimeIO(long number) {
        maxWaitTimeIO = number;
        System.out.println("The max wait time for IO is " + maxWaitTimeIO);

    }

    public void averageServiceTimeIO(ArrayList time) {
        for (int i = 0; i < time.size(); i++) {
            long temp = (long) time.get(i);
            averageServiceTimeIO = (temp + averageServiceTimeIO) / 2;

        }
        System.out.println("Average service time IO for consumer is: " + averageServiceTimeIO);


    }

    public void averageServiceTimeCPU(ArrayList time) {
        for (int i = 0; i < time.size(); i++) {
            long temp = (long) time.get(i);
            averageServiceTimeCPU = (temp + averageServiceTimeCPU) / 2;

        }
        System.out.println("Average service time CPU for consumer is: " + averageServiceTimeCPU);


    }


    public void maxServiceTimeIO(long number) {
        maxServiceTimeIO = number;
        System.out.println("Max service time IO is: " + maxServiceTimeIO);
    }

    public void maxServiceTimeCPU(long number) {
        maxServiceTimeCPU = number;
        System.out.println("Max service time CPU is: " + maxServiceTimeCPU);
    }

    public void averageWaitTimeCPU(ArrayList time) {
        for (int i = 0; i < time.size(); i++) {
            long temp = (long) time.get(i);
            averageWaitTimeCPU = (temp + averageWaitTimeCPU) / 2;

        }
        System.out.println("Average wait time CPU for consumer is: " + averageWaitTimeCPU);


    }

    public void averageWaitTimeIO(ArrayList time) {
        for (int i = 0; i < time.size(); i++) {
            long temp = (long) time.get(i);
            averageWaitTimeIO = (temp + averageWaitTimeIO) / 2;

        }
        System.out.println("Average wait time IO for consumer is: " + averageWaitTimeIO);


    }

    public void averageTurnAroundTimeIO(ArrayList time){
    for (int i = 0; i < time.size(); i++) {
        long temp = (long) time.get(i);
        averageTurnAroundTimeIO= (temp + averageTurnAroundTimeIO) / 2;

    }
        System.out.println("Average turn around time IO for consumer is: " + averageTurnAroundTimeIO);


}

    public void averageTurnAroundTimeCPU(ArrayList time){
        for (int i = 0; i < time.size(); i++) {
            long temp = (long) time.get(i);
            averageTurnAroundTimeCPU= (temp + averageTurnAroundTimeCPU) / 2;

        }
        System.out.println("Average turn around time CPU for consumer is: " + averageTurnAroundTimeCPU);


    }

    public void processorThroughput(long startTime, long endTime,  int consumer){
        long totalTime = endTime - startTime;
        int totalJobs =  consumer;
        double processorThroughput = (double) totalJobs/totalTime;
        System.out.println("The Processor throughput percentage is " + processorThroughput * 100 + " percent");
    }


    public void processorUtilization(long startTime, long endTime, int busyTime){
        long totalTime = endTime - startTime;
        int consumerBusyTime = busyTime;
        double processorutilization = (double) consumerBusyTime/totalTime;
        System.out.println("Processor utilization is at " + processorutilization *100 + " percent");
    }



}
