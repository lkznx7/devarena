package com.devarena.modules.submission.ports;

import com.devarena.modules.challenge.enums.ProgrammingLanguage;

public interface CodeExecutorPort {
    CodeExecutionResult execute(String code, ProgrammingLanguage language, String input);
}
