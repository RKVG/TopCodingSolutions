package tcs.net;

public class Solution  {

    private int id;
    private String title;
    private String overview;
    private String statement;
    private String blog;

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getOverview() {

        return overview;
    }

    public void setOverview(String overview) {

        this.overview = overview;
    }

    public String getStatement() {
        return "http://community.topcoder.com/stat?c=problem_statement&pm=" +
        statement;
    }

    public void setStatement(String statement) {

        this.statement = statement;
    }

    public String getBlog() {

        return blog;
    }

    public void setBlog(String blog) {

        this.blog = blog;
    }

    public String getURL()  {
        return title + ".html";
    }

    public String getClassName() {
        return title + ".java";
    }

}
