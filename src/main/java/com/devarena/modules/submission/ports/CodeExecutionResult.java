package com.devarena.modules.submission.ports;

public record CodeExecutionResult(
    String stdout,
    String stderr,
    Long executionTimeMs,
    Integer exitCode
) {}
