public class Books {

    public int sortMoves(String[] titles)  {

        int[] minMoves = new int[titles.length];

        int max = 0;

        for(int i = 0; i < titles.length; i++)  {
            minMoves[i] = 1;
            for(int j = 0; j < i; j++)  {
                if(titles[j].compareTo(titles[i]) <= 0)
                    minMoves[i] = Math.max(minMoves[i],minMoves[j]+1);
            }
            max = Math.max(max,minMoves[i]);
        }

        return titles.length-max;
    }

}
