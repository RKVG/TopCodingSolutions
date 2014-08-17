package tcs.net;

import java.util.ArrayList;
import java.util.List;

public class Match implements Comparable<Match> {

    private int id;
    private int division;
    private List<Solution> solutions = new ArrayList<>();
    private List<Integer> levels = new ArrayList<>();
    private List<Integer> points = new ArrayList<>();


    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public int getDivision() {

        return division;
    }

    public void setDivision(int division) {

        this.division = division;
    }

    public List<Solution> getSolutions() {

        return solutions;
    }

    public void setSolutions(List<Solution> solutions) {

        this.solutions = solutions;
    }

    public List<Integer> getLevels() {

        return levels;
    }

    public void setLevels(List<Integer> levels) {

        this.levels = levels;
    }

    public List<Integer> getPoints() {

        return points;
    }

    public void setPoints(List<Integer> points) {

        this.points = points;
    }

    public String getURL()  {
        return "div" + division + "/" + id;
    }

    @Override
    public int compareTo(Match that) {

        if (this == that)  return 0;

        if (this.id < that.id) return -1;
        if (this.id > that.id) return 1;

        if (this.division < that.division) return -1;
        if (this.division > that.division) return 1;

        return 0;
    }
}
