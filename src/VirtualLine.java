//Qiqi Lian
//113187306
//Recitation # 4
import java.util.LinkedList;
public class VirtualLine extends LinkedList {
    private final int maxAmount = 3;


    /** This method enqueues people into different rides
     * @param x
     */
    public void enqueue (Person x){
        super.addLast(x);

    }

    /** This method gets the maximum amount of people in the ride
     * @return
     */
    public int getMaxAmount() {
        return maxAmount;
    }

    /** This method dequeues the people in rides after its over
     * @return
     */
    public Person dequeue (){
        Person person =  (Person)super.get(0);
        super.removeFirst();
        return person;
    }


    /** This method looks at the people in each line
     * @return
     */
    public Person peek (){
        return (Person) super.getFirst();

    }


    /** This method is to check if each line is empty
     * @return
     */
    public boolean isEmpty (){
        return super.isEmpty();


    }

}
