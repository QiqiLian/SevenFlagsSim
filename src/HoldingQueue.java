//Qiqi Lian
//113187306
//Recitation # 4
public class HoldingQueue extends VirtualLine {

    /**
     *
     */
    private int max_capacity;

    /** This sets the max capacity
     * @param max_capacity
     */
    public void setMax_capacity(int max_capacity) {
        this.max_capacity = max_capacity;
    }

    /** This gets the max capacity
     * @return
     */
    public int getMax_capacity() {
        return max_capacity;
    }

    /** This method enqueues people into rides
     * @param x
     */
    public void enqueue (Person x){
        super.addLast(x);
    }

    /** This method dequeue people from rides
     * @return
     */
    public Person dequeue (){
        super.removeFirst();

        return dequeue();
    }




}
