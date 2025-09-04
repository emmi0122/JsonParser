package se.berg.domain;

import java.util.List;

public class TestSequence {
    private String name;
    private List<TestCase> testCases;

    public TestSequence(String name, List<TestCase> testCases) {
        this.name = name;
        this.testCases = testCases;
    }

    public String getName() {
        return name;
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }
}
