package tcs.net.pageBuilders;

import tcs.net.Match;
import tcs.net.Solution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class SolutionPage {

    static Charset charset = Charset.forName("US-ASCII");

    private final Path templatePath;
    private final Path sourceBasePath;
    private final Path outFileBaseDirPath;
    private final Match match;

    public SolutionPage(String template, String source, String out,
                        Match match) throws Exception {

        templatePath = new File(template).toPath();
        outFileBaseDirPath = new File(out).toPath();
        sourceBasePath = new File(source).toPath();
        this.match = match;
    }

    public void createPages() throws Exception {

        Path matchPath = outFileBaseDirPath.resolve(match.getURL());

        if (!matchPath.toFile().exists()) {
            Files.createDirectories(matchPath);
        }

        for (int i = 0; i < match.getSolutions().size(); i++) {

            Solution s = match.getSolutions().get(i);

            Path solutionOutPath =
                    matchPath.resolve(match.getSolutions().get(i).getURL());

            Path solutionInBasePath = sourceBasePath.resolve(match.getId() +
                    "\\" + match.getSolutions().get(i).getTitle());

            BufferedWriter writer = Files.newBufferedWriter(solutionOutPath,
                    charset);

            BufferedReader reader =
                    Files.newBufferedReader(templatePath, charset);

            String line = null;
            while ((line = reader.readLine()) != null) {
                if ("INSERT HERE".equals(line)) {
                    writer.write("<div class=\"solution_heading\">Problem " +
                            "Statement:</div>");
                    writer.write("<p><a href=\"" + s.getStatement() +
                            "\" target=\"_blank\">SRM " +
                            match.getId() + " DIV " + match.getDivision() + "" +
                            " - " + match.getPoints().get(i) + " " +
                            "Points</a></p>");
                    writer.write("<div " +
                            "class=\"solution_heading\">Overview:</div>");
                    writer.write("<p>" + s.getOverview() + "</p>");
                    writer.write("<div class=\"solution_heading\">Java " +
                            "Source:</div>");

                    BufferedReader sourceReader = Files.newBufferedReader
                            (solutionInBasePath.resolve("src\\" +
                                    s.getClassName()), charset);

                    writer.write("<div class=\"code\"><pre>");

                    writer.write("   1: /*" + "\n");
                    writer.write("   2:  * TopCoder Single Round Match: " +
                            match.getId() + "\n");
                    writer.write("   3:  * Division: " + match.getDivision() +
                            "\n");
                    writer.write("   4:  * Level: " + match.getLevels().get
                            (i) + "\n");
                    writer.write("   5:  * Points: " + match.getPoints().get
                            (i) + "\n");
                    writer.write("   6:  * Problem Statement: " + match
                            .getSolutions
                            ().get(i).getStatement()+ "\n");
                    writer.write("   7:  */" + "\n");
                    writer.write("   8:\n");

                    int c = 9;
                    while ((line = sourceReader.readLine()) != null)  {
                        StringBuilder lineNumber = new StringBuilder(6);
                        lineNumber.append(c++);
                        while (lineNumber.length() < 4)  {
                            lineNumber = lineNumber.insert(0, " ");
                        }
                        lineNumber.append(": ");
                        writer.write(lineNumber.toString() + line + "\n");
                    }

                    sourceReader.close();

                    writer.write("</pre></div>");

                    writer.write("<div " +
                            "class=\"solution_heading\">Notes:</div>");

                    BufferedReader notesReader = Files.newBufferedReader
                            (solutionInBasePath.resolve("Description.html"), charset);
                    while ((line = notesReader.readLine()) != null)  {
                        writer.write(line);
                    }
                    notesReader.close();

                    writer.write("<div class=\"solution_footer\">");
                    writer.write("<p><i>Thank you</i> for taking the time to " +
                            "read this solution.  I welcome any feedback you may have.</p>");
                    writer.write("<p>Please post any questions or comments <a" +
                            " href=\"" + s.getBlog() + "\" target=\"_blank\">here</a>" +
                            ".</p>");

                } else {
                    writer.write(line);
                }
            }

            writer.flush();
            reader.close();
            writer.close();

        }
    }

}
