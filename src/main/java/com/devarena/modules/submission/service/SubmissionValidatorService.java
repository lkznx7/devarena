package com.devarena.modules.submission.service;

import com.devarena.modules.challenge.entity.ChallengeTestCase;
import com.devarena.modules.submission.enums.SubmissionStatus;
import com.devarena.modules.submission.ports.CodeExecutionResult;
import com.devarena.modules.submission.ports.CodeExecutorPort;
import com.devarena.modules.submission.entity.Submission;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubmissionValidatorService {

    private final CodeExecutorPort codeExecutorPort;

    public SubmissionValidatorService(CodeExecutorPort codeExecutorPort) {
        this.codeExecutorPort = codeExecutorPort;
    }

    public SubmissionStatus validate(Submission submission) {
        List<ChallengeTestCase> testCases = submission.getChallenge().getTestCases();
        
        long totalExecutionTime = 0;
        
        for (ChallengeTestCase testCase : testCases) {
            CodeExecutionResult result = codeExecutorPort.execute(
                    submission.getCode(),
                    submission.getChallenge().getLanguage(),
                    testCase.getInput()
            );

            if (result.exitCode() != 0) return SubmissionStatus.RUNTIME_ERROR;
            
            String actualOutput = result.stdout() != null ? result.stdout().trim() : "";
            String expectedOutput = testCase.getExpectedOutput() != null ? testCase.getExpectedOutput().trim() : "";

            if (!actualOutput.equals(expectedOutput)) {
                return SubmissionStatus.WRONG_ANSWER;
            }
            
            totalExecutionTime += result.executionTimeMs();
        }

        submission.setExecutionTimeMs(totalExecutionTime / Math.max(1, testCases.size()));
        return SubmissionStatus.ACCEPTED;
    }
}
