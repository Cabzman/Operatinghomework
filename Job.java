/**
 * Created by Cabz on 11/7/2016.
 */



//jobtype
    //servicetime
    //creation time
    //service start time
    //service comp time



public class Job {
    //long serviceStartTime;
    long serviceCompletionTime;
    long processStart;
    long turnAroundTime;

    long waitTimeEnd;
    String type;


    public Job(String type){
        processStart=  System.currentTimeMillis();
        this.type = type;

    }
    public long getProcessStart(){
        return processStart;
    }


    public void waitTimeEnd(long number){
        waitTimeEnd = System.currentTimeMillis();
    }


    public long getWaitTimeEnd() {
        return waitTimeEnd;
    }



    public long getServiceCompletionTime(){
        return System.currentTimeMillis();
    }




    void setServiceCompletionTime(){
        serviceCompletionTime = System.currentTimeMillis();
    }

    String getType(){
        return type;
    }



}
