/**
 * Created by Cabz on 11/7/2016.
 */



//jobtype
    //servicetime
    //creation time
    //service start time
    //service comp time



public class Job {
    long serviceStartTime;
    long serviceCompletionTime;
    long waitTime;
    String type;


    public Job(String type){
        serviceStartTime =  System.currentTimeMillis();
        this.type = type;

    }

    public long getWaitTime(){
        waitTime = serviceStartTime - System.currentTimeMillis();
        return waitTime;
    }

    public long getServiceCompletionTime(){
        return System.currentTimeMillis();
    }


    long getServiceStartTime(){
                return serviceStartTime;
    }

    void setServiceCompletionTime(){
        serviceCompletionTime = System.currentTimeMillis();
    }

    String getType(){
        return type;
    }



}
