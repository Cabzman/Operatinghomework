/**
 * Created by Cabz on 11/7/2016.
 */



//jobtype
    //servicetime
    //creation time
    //service start time
    //service comp time



public class Job {

    long serviceCompletionTime;
    long processStart;
    long  arrivialTime;
    long timeinBuffer;
    int sleepTime;

    long waitTimeEnd;
    String type;


    public Job(String type){
        processStart=  System.currentTimeMillis();
        this.type = type;

    }

    public void sleepTime(int duration){
        int temp = (int) (duration * -Math.log(Math.random()));
        sleepTime = temp;
    }

    public int getSleepTime(){
        return sleepTime;
    }



    public void arrivialTime(){
        arrivialTime = System.currentTimeMillis();
    }

    public long getArrivialTime(){
        return  arrivialTime;
    }


    void setServiceCompletionTime(){
        serviceCompletionTime = System.currentTimeMillis();
    }

    String getType(){
        return type;
    }



}
