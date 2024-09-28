package com.automation.listener;

import com.automation.utils.ExtentReportManager;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.Status;
import io.cucumber.plugin.event.TestStepFinished;

public class TestListener implements ConcurrentEventListener {

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestStepFinished.class, this::handleStepFinished);
    }

    private void handleStepFinished(TestStepFinished event) {
        String step = event.getTestStep().getCodeLocation();
        String step1 = step.substring(0, step.indexOf("("));
        String step2 = step1.substring(step1.lastIndexOf(".") + 1);
        if (event.getResult().getStatus().equals(Status.FAILED) && !step2.contains("before") && !step2.contains("after")) {
            ExtentReportManager.getExtentTest().createNode(step2).fail(" FAILED");
            ExtentReportManager.getExtentTest().fail(event.getResult().getError());
        } else if (!step2.contains("before") && !step2.contains("after")) {
            ExtentReportManager.getExtentTest().createNode(step2).pass(" PASSED");
        }
    }
}