import jdk.jshell.PersistentSnippet;
//Qiqi Lian
//113187306
//Recitation # 4
import java.util.ArrayList;

/**
 * This person class takes in the all the parameters to determine a person in line
 */
public class Person {
    private int number;
    private int maxLines;
    private String membership;
    private ArrayList <Ride> Lines;
    private Status Status;


    /**
     * @param number
     */
    public Person (int number){
        this.number = number;
        Lines = new ArrayList<Ride>();
        if(number < 0){
            throw new IllegalArgumentException();

        }

    }

    /**
     * @return This method is to get the type of membership
     */
    public String getMembership() {
        return membership;
    }

    /** This method sets the type of memebership
     * @param membership
     */
    public void setMembership(String membership) {
        this.membership = membership;
    }

    /** This method sets the status
     * @return
     */
    public Status getStatus() {
        return Status;
    }

    /** This method gets the status
     * @param status
     */
    public void setStatus(Status status) {
        Status = status;
    }

    /** This method sets the max amount of people per line
     * @param maxLines
     */
    public void setMaxLines(int maxLines) {
        this.maxLines = maxLines;
    }

    /** This method sets the number of people in each ride
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /** This method sets the individuals in each line
     * @param lines
     */
    public void setLines(ArrayList<Ride> lines) {
        Lines = lines;
    }

    /** This method gets the max amount of people allowed per ride
     * @return
     */
    public int getMaxLines() {
        return maxLines;
    }

    /** This method gets the amount of people in each ride
     * @return
     */
    public int getNumber() {
        return number;
    }

    /** This method gets the lines for each ride
     * @return
     */
    public ArrayList<Ride> getLines() {
        return Lines;

    }

    /**
     * @return This is the toString method
     */
    @Override
    public String toString() {
        return  "[" + number +  " , " + membership  + "]";

    }
}
