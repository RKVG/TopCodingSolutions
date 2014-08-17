package tcs.net;

import tcs.net.pageBuilders.NavigationPage;
import tcs.net.pageBuilders.SolutionPage;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SiteBuilder {

    private static String matchInfoFile = "SiteBuilder/solutions.xml";

    private static String projRoot = "K:\\My Documents\\My " +
            "Projects\\TCS\\SiteBuilder";
    private static String templateDir = projRoot + "\\webapp";
    private static String outputDir = "K:\\My Documents\\My " +
            "Projects\\TCS_AppEngine\\site\\site-war";
    private static String outputWebAppRoot = outputDir + "\\src\\main\\webapp";
    private static String sourceBaseDir = "K:\\My Documents\\My " +
            "Projects\\TCS\\Site\\srm";

    public static void main(String[] args) throws Exception {

        SiteBuilder sb = new SiteBuilder();
        sb.build();
    }

    public static void deleteRecursive(File path)
            throws FileNotFoundException {

        if (!path.exists()) {
            return;
        }

        if (path.isDirectory()) {
            for (File f : path.listFiles()) {
                deleteRecursive(f);
            }
        }
        path.delete();
    }

    private void build() throws Exception {

        createProjectTemplate();

        Map<Integer, Solution> solutions = new HashMap<>();
        List<Match> matches = new ArrayList<>();

        SiteDataReader sr = new SiteDataReader(solutions, matches);
        sr.loadData(matchInfoFile);

        SiteBuilder sb = new SiteBuilder();
        sb.buildWebSite(matches);
    }

    private void buildWebSite(List<Match> matches) throws Exception {

        new NavigationPage(
                projRoot + "\\resources\\pages\\navigation.html",
                outputWebAppRoot + "\\srm\\div1.html",
                1, matches).createPage();

        new NavigationPage(
                projRoot + "\\resources\\pages\\navigation.html",
                outputWebAppRoot + "\\srm\\div2.html",
                2, matches).createPage();

        for (Match m : matches)  {

            String source = sourceBaseDir + "\\" + m.getId();

            new SolutionPage(
                    projRoot + "\\resources\\pages\\solution.html",
                    sourceBaseDir,
                    outputWebAppRoot + "\\srm", m).createPages();

        }

    }

    private void createProjectTemplate() throws Exception {

        // Delete the current directory
        deleteRecursive(new File(outputDir));

        File d = new File(outputDir);
        d.mkdir();

        Files.walkFileTree(new File(templateDir).toPath(),
                new CopyFileVisitor(new File(outputDir).toPath()));

    }

}
