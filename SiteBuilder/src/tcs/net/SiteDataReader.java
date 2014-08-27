package tcs.net;

import javax.xml.parsers.*;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

import java.util.*;
import java.io.*;

public class SiteDataReader extends DefaultHandler {


    private Map<Integer, Solution> solutions;
    private List<Match> matches;

    private Solution currentSolution;
    private Match currentMatch;
    private StringBuilder elementData;

    private int id;
    private int division;
    private int level;
    private int points;
    private int class_id;

    public SiteDataReader(Map<Integer, Solution> solutions,
                          List<Match> matches)  {
        this.solutions = solutions;
        this.matches = matches;
    }
    public void loadData(String fileName) throws Exception {

        String solutionsFilePath = new File(fileName).toURI().toString();

        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        spf.setValidating(false);
        SAXParser saxParser = spf.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        xmlReader.setContentHandler(new SiteDataReader(solutions, matches));
        xmlReader.setErrorHandler(new MyErrorHandler(System.err));
        xmlReader.parse(solutionsFilePath);

    }

    public void startDocument() throws SAXException {
        System.out.println("Starting Document");
    }

    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes atts) throws
                                                            SAXException {

        if ("Solution".equals(localName)) {
            currentSolution = new Solution();
            id = Integer.parseInt(atts.getValue("id"));
        } else if ("Match".equals(localName))  {
            currentMatch = new Match();
            id = Integer.parseInt(atts.getValue("id"));
            division = Integer.parseInt(atts.getValue("division"));
        } else if ("Challenge".equals(localName))  {
            level = Integer.parseInt(atts.getValue("level"));
            points = Integer.parseInt(atts.getValue("points"));
            class_id = Integer.parseInt(atts.getValue("class_id"));
        }

    }

    public void characters(char ch[], int start, int length) {

        elementData = new StringBuilder();

        for (int i = 0; i < length; i++) {
            elementData.append(ch[start+i]);
        }

    }

    public void endElement(String uri, String localName, String qName)  {

        if ("Solution".equals(localName))  {
            int solution_id = id;
            currentSolution.setId(solution_id);
            solutions.put(solution_id, currentSolution);
        } else if ("Title".equals(localName))  {
            currentSolution.setTitle(elementData.toString());
        } else if ("Overview".equals(localName))  {
            currentSolution.setOverview(elementData.toString());
        } else if ("tc_id".equals(localName))  {
            currentSolution.setStatement(elementData.toString());
        } else if ("Blog".equals(localName))  {
            currentSolution.setBlog(elementData.toString());
        } else if ("Match".equals(localName))  {
            currentMatch.setId(id);
            currentMatch.setDivision(division);
            matches.add(currentMatch);
        } else if ("Challenge".equals(localName))  {
            currentMatch.getLevels().add(level);
            currentMatch.getPoints().add(points);
            int classId = class_id;
            currentMatch.getSolutions().add(solutions.get(classId));
        }

    }

    public void endDocument() throws SAXException {
        System.out.println("Ending Document");
    }

    // Error handler to report errors and warnings
    private static class MyErrorHandler implements ErrorHandler {

        /**
         * Error handler output goes here
         */
        private PrintStream out;

        MyErrorHandler(PrintStream out) {

            this.out = out;
        }

        /**
         * Returns a string describing parse exception details
         */
        private String getParseExceptionInfo(SAXParseException spe) {

            String systemId = spe.getSystemId();
            if (systemId == null) {
                systemId = "null";
            }
            String info = "URI=" + systemId +
                    " Line=" + spe.getLineNumber() +
                    ": " + spe.getMessage();
            return info;
        }

        // The following methods are standard SAX ErrorHandler methods.
        // See SAX documentation for more info.

        public void warning(SAXParseException spe) throws SAXException {

            out.println("Warning: " + getParseExceptionInfo(spe));
        }

        public void error(SAXParseException spe) throws SAXException {

            String message = "Error: " + getParseExceptionInfo(spe);
            throw new SAXException(message);
        }

        public void fatalError(SAXParseException spe) throws SAXException {

            String message = "Fatal Error: " + getParseExceptionInfo(spe);
            throw new SAXException(message);
        }
    }

}
