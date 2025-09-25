package se.berg;

import se.berg.domain.TestSequence;
import se.berg.io.JsonParser;
import se.berg.service.HtmlReportGenerator;
import se.berg.service.TestSequencePrinter;

public class Main {
    public static void main(String[] args) {
        try {
            //Parse JSON-file
            TestSequence seq = JsonParser.parseTestSequence("emilia_test_seq.json");

            //Print everything to textfile
            TestSequencePrinter.print(seq, "parsed-json.txt");

            //Generate HTML report
            HtmlReportGenerator.generateReport(seq, "test-report.html");
            System.out.println("Reports generated succesfully!");
            System.out.println("- Text report: parsed-json.txt");
            System.out.println("- HTML report: test-report.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}