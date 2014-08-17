package tcs.net.pageBuilders;

import tcs.net.Match;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

/**
 * User: Patrick Date: 8/16/2014 Time: 4:43 PM Description:
 */
public class NavigationPage {

    static Charset charset = Charset.forName("US-ASCII");
    final Path inFile;
    final Path outFile;
    final int division;
    final List<Match> matches;

    public NavigationPage(String inFilePath, String outFilePath, int div,
                          List<Match> matches) {

        inFile = new File(inFilePath).toPath();
        outFile = new File(outFilePath).toPath();
        this.matches = matches;

        this.division = div;
    }

    public void createPage() throws Exception {

        BufferedWriter writer = Files.newBufferedWriter(outFile, charset);

        BufferedReader reader =
                Files.newBufferedReader(inFile, charset);

        String line = null;
        while ((line = reader.readLine()) != null) {
            if ("INSERT HERE".equals(line)) {

                writer.write("<p>Divison " + division + ":</p>");
                writer.write("<table class=\"navigation_table\">");

                for (Match m : matches) {
                    if (m.getDivision() == division) {

                        String divStr = "" + m.getId();

                        for (int i = 0; i < m.getSolutions().size(); i++) {
                            writer.write("<tr>");
                            writer.write("<td>");
                            if (divStr != null) {
                                writer.write(divStr);
                                divStr = null;
                            }
                            writer.write("</td>");
                            writer.write("<td>" + "Level " + m.getLevels()
                                    .get(i) + "</td>");
                            writer.write("<td>" + m.getPoints()
                                    .get(i) + " Points</td>");
                            writer.write("<td><a href=" + m.getURL() + "/" +
                                    m.getSolutions().get(i).getURL() + ">" +
                                    m.getSolutions().get(i).getTitle() +
                                    "</a></td>");

                            writer.write("</tr>");
                        }

                    }
                }

                writer.write("</table>");

            } else {
                writer.write(line);
            }
        }

        writer.flush();
        reader.close();
        writer.close();

    }

}
