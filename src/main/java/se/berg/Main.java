package se.berg;

import java.net.URL;

import se.berg.domain.TestSequence;
import se.berg.io.JsonParser;
import se.berg.service.TestSequencePrinter;

public class Main {
    public static void main(String[] args) {
        try {
            TestSequence seq = JsonParser.parseTestSequence("emilia_test_seq.json");
            TestSequencePrinter.print(seq, "parsed-json.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}