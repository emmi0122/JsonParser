package se.berg.service;

import se.berg.domain.TestSequence;
import se.berg.domain.TestCase;
import se.berg.domain.TestStep;

import java.io.*;

import java.util.List;

public class TestSequencePrinter {
    public static void print(TestSequence sequence, String fileName) {
        String line = "------------------------------------------------------------";

        //Build up the text in a StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("Test Sequence Name: ").append(sequence.getName().toUpperCase()).append("\n");
        sb.append(line).append("\n");

        List<TestCase> testCases = sequence.getTestCases();
        for (int i = 0; i < testCases.size(); i++) {
            TestCase testCase = testCases.get(i);

            sb.append("\n");
            sb.append((i + 1)).append("    ").append(testCase.getName().toUpperCase()).append("\n");
            sb.append(line).append("\n");

            List<TestStep> testSteps = testCase.getTestSteps();
            for (int j = 0; j < testSteps.size(); j++) {
                sb.append((i + 1)).append(".").append((j + 1)).append(" ").append(testSteps.get(j).getDescription()).append("\n");

                if (testSteps.get(j).hasSubSteps()) {
                    appendSubSteps(sb, testSteps.get(j).getSubSteps(), (i + 1) + "." + (j + 1));
                }
            }
        }

        sb.append("\n").append(line).append("\n");

        //Print to console
        System.out.println(sb.toString());

        //Print to txt file
        try (FileWriter writer = new FileWriter("parsed-json.txt")) {
            writer.write(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void appendSubSteps(StringBuilder sb, List<TestStep> subSteps, String prefix) {
        for (int k = 0; k < subSteps.size(); k++) {
            sb.append("    ").append(prefix).append(".").append(k + 1).append(" ").append(subSteps.get(k).getDescription()).append("\n");

            if (subSteps.get(k).hasSubSteps()) {
                appendSubSteps(sb, subSteps.get(k).getSubSteps(), prefix + "." + (k + 1));
            }
        }
    }

    
}
