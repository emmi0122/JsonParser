package se.berg.domain;

import java.util.List;

public class TestCase {
    private String name;
    private List<TestStep> testSteps;

    public TestCase(String name, List<TestStep> testSteps) {
        this.name = name;
        this.testSteps = testSteps;
    }

    public String getName() {
        return name;
    }

    public List<TestStep> getTestSteps() {
        return testSteps;
    }
}
