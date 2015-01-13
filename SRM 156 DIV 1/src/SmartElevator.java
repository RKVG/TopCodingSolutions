import java.util.HashSet;
import java.util.Set;

public class SmartElevator {

    private int minFinishTime = Integer.MAX_VALUE;

    private int[] startingFloors;
    private int[] destinationFloors;
    private int[] arrivalTimes;

    public int timeWaiting(int[] arrivalTime, int[] startingFloor,
                           int[] destinationFloor) {

        // Make these accessible to other methods.
        this.startingFloors = startingFloor;
        this.destinationFloors = destinationFloor;
        this.arrivalTimes = arrivalTime;

        /*
        * Initialize the simulation.  Creates Sets representing people
        * waiting for the elevator (regardless of their arrival time) and
        * people currently on the elevator.
        */
        Set<Integer> waiting = new HashSet<>();

        // Add everyone to the waiting Set.
        for (int i = 0; i < arrivalTime.length; i++) {
            waiting.add(i);
        }

        Set<Integer> elevator = new HashSet<>();
        int floor = 1;
        int time = 0;

        moveElevator(waiting, elevator, floor, time);

        return minFinishTime;
    }

    private void moveElevator(Set<Integer> waiting, Set<Integer> elevator,
                              int floor, int time) {

        /*
        * If there is nobody waiting, and nobody in the elevator, then we're
        * done.  If time is smaller than anything previously seen, set it
        * to our time.
        */
        if (waiting.isEmpty() && elevator.isEmpty()) {
            minFinishTime = Math.min(minFinishTime, time);
        }

        /*
        * Picking up people.
        * Recursively call moveElevator().  We'll move one person in turn
        * from the waiting Set to the elevator set.
        */
        for (int i : waiting) {
            Set<Integer> newWaiting = new HashSet<>(waiting);
            newWaiting.remove(i);

            Set<Integer> newElevator = new HashSet<>(elevator);
            newElevator.add(i);

            int newFloor = startingFloors[i];
            int travelTime = Math.abs(floor - newFloor);

            // Max of when elevator gets there, and when person arrives.
            int newTime = Math.max((time + travelTime), arrivalTimes[i]);

            moveElevator(newWaiting, newElevator, newFloor, newTime);
        }

        /*
        * Dropping off people.
        * Recursively call moveElevator() removing one person from the
        * elevator Set.
        */
        for (int i : elevator) {
            Set<Integer> newElevator = new HashSet<>(elevator);
            newElevator.remove(i);

            int newFloor = destinationFloors[i];
            int travelTime = Math.abs(floor - newFloor);
            int newTime = time + travelTime;

            moveElevator(waiting, newElevator, newFloor, newTime);
        }

    }
}
