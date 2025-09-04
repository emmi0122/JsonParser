package se.berg.domain;

import java.util.List;

public class TestStep {
    private String description;
    private List<TestStep> subSteps;

    public TestStep(String description) {
        this.description = description;
        this.subSteps = null;
    }

    public TestStep(String description, List<TestStep> subSteps) {
        this.description = description;
        this.subSteps = subSteps;
    }

    public String getDescription() {
        return description;
    }

    public boolean hasSubSteps() {
        return subSteps != null && !subSteps.isEmpty();
    }

    public List<TestStep> getSubSteps() {
        return subSteps;
    }
}
