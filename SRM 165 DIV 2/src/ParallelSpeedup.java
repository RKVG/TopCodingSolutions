public class ParallelSpeedup {

    private static final int MAX_PROCESSORS = 1_000_000;

	public int numProcessors(int k, int overhead) {

        // Time it takes for 1 processor.
        long fastest = k;

        for (int processors = 2; processors <= MAX_PROCESSORS; processors++)  {

            // Calculate the communications overhead
            long o = ((processors * (processors - 1)) / 2) * overhead;

            /*
             * Total time is the overhead, plus the number of tasks divided
             * by the number of processors.
             */
            long time = o + (k / processors);

            /*
            * If the number of tasks does not divide evenly by the number
            * of processors, then we'll need 1 extra ms to finish the remaining
            * tasks.
            */
            if (k % processors != 0) time += 1;

            /*
            * As soon as time levels out or begins increasing, stop
            * and return the previous number of processors.  From here
            * on, time will keep increasing.
            */
            if (time >= fastest) return processors - 1;

            // record our new fastest time.
            fastest = time;

        }

        // Should never reach here.
        return -1;

	}
}
