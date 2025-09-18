package se.berg.service;

import se.berg.domain.TestSequence;

public class HtmlReportGenerator {
    public static void generateReport(TestSequence sequence, String fileName) {
        StringBuilder html = new StringBuilder();

        //HTML structure that looks like an IPV-document
        html.append("<!DOCTYPE html>\n");
        html.append("<html lang=\"en\">\n");
        html.append("<head>\n");
        html.append("    <meta charset=\"UTF-8\">\n");
        html.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        html.append("    <title>Factory Acceptance and IPV Test Report</title>\n");
        html.append("    <style>\n");
        html.append(getCSS());
        html.append("    </style>\n");
        html.append("</head>\n");
        html.append("<body>\n");

        //Header section that looks like an IPV-document
        html.append(generateHeader());

        // Test sekvens namn
        html.append("    <div class=\"main-content\">\n");
        html.append("        <h1>FACTORY ACCEPTANCE AND IPV TEST FOR BERG® MPC800M</h1>\n");
        html.append("        <h2>Test Sequence: ").append(sequence.getName().toUpperCase()).append("</h2>\n");

        //Project information (can be extended)
        html.append(generateProjectInfo());
    }

    private static String getCSS() {
        return """
            body {
                font-family: Arial, sans-serif;
                margin: 20px;
                line-height: 1.4;
                color: #333;
            }
        """;
    }

    private static String generateHeader() {
        return """
        """;
    }

    private static String generateProjectInfo() {
        return """
        """;
    }
}
