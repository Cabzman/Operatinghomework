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



//subtracting 2 due to last 2 entries being obvious outliers
    public void averageServiceTimeIO(ArrayList time) {
        for (int i = 0; i < time.size()- 2; i++) {
            long temp = (long) time.get(i);
            averageServiceTimeIO = (temp + averageServiceTimeIO);

        }
        System.out.println("Average service time IO : " + (double)(averageServiceTimeIO/(time.size()-2 ))/10);



    }

    public void averageServiceTimeCPU(ArrayList time) {
        for (int i = 0; i < time.size()-1; i++) {
            long temp = (long) time.get(i);
            averageServiceTimeCPU = (temp + averageServiceTimeCPU);

        }
        System.out.println("Average service time CPU : " + (averageServiceTimeCPU/((time.size())-1)/10));


    }


    public void maxServiceTimeIO(long number) {
        maxServiceTimeIO = number;
        System.out.println("Max service time IO is: " + maxServiceTimeIO/10);
    }

    public void maxServiceTimeCPU(long number) {
        maxServiceTimeCPU = number;
        System.out.println("Max service time CPU is: " + maxServiceTimeCPU/10);
    }



    public void maxTurnAroundTimeIO(long number){
        maxTurnAroundTimeIO = number;
        System.out.println("The max turn around time IO is : " + (double)maxTurnAroundTimeIO/10);
    }

    public void maxTurnAroundTimeCPU(long number){
        maxTurnAroundTimeCPU = number;
        System.out.println("The max turn around time CPU is : " + (double)maxTurnAroundTimeCPU/10);
    }




    public void maxWaitTimeCPU(long number) {
        maxWaitTimeCPU = number;
        System.out.println("The max wait time for CPU is " + (double)maxWaitTimeCPU/10);
    }

    public void maxWaitTimeIO(long number) {
        maxWaitTimeIO = number;
        System.out.println("The max wait time for IO is " + (double)maxWaitTimeIO/10);

    }


    //-1 is to remove an outlier
    public void averageWaitTimeCPU(ArrayList time) {
        for (int i = 0; i < time.size(); i++) {
            long temp = (long) time.get(i);
            averageWaitTimeCPU = (temp + averageWaitTimeCPU) ;

        }
        System.out.println("Average wait time CPU is : " + (double)(averageWaitTimeCPU/time.size())/10);


    }

    public void averageWaitTimeIO(ArrayList time) {
        for (int i = 0; i < time.size()-1; i++) {
            long temp = (long) time.get(i);
            averageWaitTimeIO = (temp + averageWaitTimeIO);

        }
        System.out.println("Average wait time IO is : " + (double)(averageWaitTimeIO/time.size()-1)/10);


    }

    public void averageTurnAroundTimeIO(ArrayList time){
    for (int i = 0; i < time.size(); i++) {
        long temp = (long) time.get(i);
        averageTurnAroundTimeIO= (temp + averageTurnAroundTimeIO);

    }
        System.out.println("Average turn around time IO  is: " + (double)(averageTurnAroundTimeIO/time.size())/10);


}

    public void averageTurnAroundTimeCPU(ArrayList time){
        for (int i = 0; i < time.size(); i++) {
            long temp = (long) time.get(i);
             averageTurnAroundTimeCPU= (temp + averageTurnAroundTimeCPU);
            int test1 = time.size();

        }
        System.out.println("Average turn around time CPU : " + (double)((averageTurnAroundTimeCPU/time.size())/10));


    }

    public void processorThroughput(long startTime, long endTime,  int consumer){
        long totalTime = endTime - startTime;
        int totalJobs =  consumer;
        double processorThroughput = (double) (totalJobs/(totalTime/10));
        System.out.println("The total jobs done is " + totalJobs + " and the time it took is " + totalTime + " and the " +
                " processorThroughput is " + processorThroughput);
    }


    public void processorUtilization(long startTime, long endTime, int busyTime){
        long totalTime = endTime - startTime;
        int consumerBusyTime = busyTime;
        double processorutilization = (double) consumerBusyTime/totalTime;
        System.out.println("Processor utilization is at " + processorutilization * 1000  + " percent");
    }



}
