//Qiqi Lian
//113187306
//Recitation # 4
import java.util.ArrayList;

public class Ride {
    private int duration;
    private int timeLeft;
    private String name;
    private VirtualLine virtualLine = new VirtualLine();
    private HoldingQueue holdingQueue = new HoldingQueue();
    private ArrayList <Person> peopleOnRide;
    private int i = 0;
    private int CAPACITY;


    /**
     * @param name
     * @param duration
     * @param timeLeft
     */
    public Ride (String name, int duration, int timeLeft){
        this.name = name;
        this.duration = duration;
        this.timeLeft = timeLeft;
        peopleOnRide = new ArrayList<Person>();

    }

    /** This method sets the capacity of the ride
     * @param CAPACITY
     */
    public void setCAPACITY(int CAPACITY) {
        this.CAPACITY = CAPACITY;
    }

    /** This method gets the capacity
     * @return
     */
    public int getCAPACITY() {
        return CAPACITY;
    }

    /** This method returns the people on the ride
     * @return
     */
    public ArrayList<Person> getPeopleOnRide() {
        return peopleOnRide;
    }

    /**
     * @return This method gets the current capacity
     */
    public int getCurrentCapacityOnRide() {
        return i;
    }

    /** This method gets the virtual line
     * @return
     */
    public VirtualLine getVirtualLine() {
        return virtualLine;
    }

    /** This method gets the holding queue
     * @return
     */
    public HoldingQueue getHoldingQueue() {
        return holdingQueue;
    }


    /** This method gets the duration of the ride
     * @return
     */
    public int getDuration() {
        return duration;
    }

    /** This method gets the timeleft for each ride
     * @return
     */
    public int getTimeLeft() {
        return timeLeft ;
    }

    /** This method gets the name
     * @return
     */
    public String getName() {
        return name;
    }

    /** This method sets the people into the rides
     * @param peopleOnRide
     */
    public void setPeopleOnRide(ArrayList<Person> peopleOnRide) {
        this.peopleOnRide = peopleOnRide;
    }


    /** This method sets the virtual line
     * @param virtualLine
     */
    public void setVirtualLine(VirtualLine virtualLine) {
        this.virtualLine = virtualLine;
    }

    /** This method sets the holding queue
     * @param holdingQueue
     */
    public void setHoldingQueue(HoldingQueue holdingQueue) {
        this.holdingQueue = holdingQueue;
    }

    /** This method sets the duration
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /** This method sets the time left
     * @param timeLeft
     */
    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    /** This method sets the name
     * @param name
     */
    public void setName(String name) {
        this.name = name;

    }


}
