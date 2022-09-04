//Qiqi Lian
//113187306
//Recitation # 4
import java.util.*;

/**
 *
 */
public class RandomGenerator {
    /**
     * @param rides This method randomly generates and gives each ride
     * @return
     */
    public static Ride selectRide(Ride[] rides) {

        Random rid = new Random();


        return rides[rid.nextInt(rides.length)];
    }

}

