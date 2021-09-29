package io.github.qaguru.allure;

import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static Integer ISSUE_NUMBER = 68;

    @Test
    public void testGithub() {
        WebSteps steps = new WebSteps();
        steps.openPage();
        steps.searchRepository(REPOSITORY);
        steps.goRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldHaveIssueWithNumber(ISSUE_NUMBER);
    }
}
