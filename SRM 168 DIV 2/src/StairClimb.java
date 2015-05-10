public class StairClimb {
	
	public int stridesTaken(int[] flights, int stairsPerStride) {

        int totalStrides = 0;

        for (int f = 0; f < flights.length; f++)  {

            // Get the number of strides in this flight.
            totalStrides += flights[f] / stairsPerStride;

            /*
            * If the last stride does not end evenly at the landing,
            * then we'll need one more stride.
            */
            if (flights[f] % stairsPerStride != 0) totalStrides++;

            // Add the two steps to turn at the landing.
            totalStrides += 2;
        }

        // We don't need to count the turn at the top.  Remove those strides.
        totalStrides -= 2;

        return totalStrides;
	}
}
