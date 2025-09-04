package se.berg.io;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import se.berg.domain.*;

public class JsonParser {
    public static TestSequence parseTestSequence(String filePath) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONObject obj = new JSONObject(content);

        String seqName = obj.getString("name");
        JSONArray testCasesJson = obj.getJSONArray("test_cases");

        List<TestCase> testCases = new ArrayList<>();
        for (int i = 0; i < testCasesJson.length(); i++) {
            JSONObject caseJson = testCasesJson.getJSONObject(i);
            String caseName = caseJson.getString("name");
            JSONArray stepsJson = caseJson.getJSONArray("steps");

            List<TestStep> testSteps = new ArrayList<>();
            for (int j = 0; j < stepsJson.length(); j++) {
                JSONObject stepJson = stepsJson.getJSONObject(j);

                //Simplified: Just get the __type__ as step description
                String type = stepJson.getString("__type__");
                testSteps.add(new TestStep(type));
            }

            testCases.add(new TestCase(caseName, testSteps));
        }

        return new TestSequence(seqName, testCases);
    }
}