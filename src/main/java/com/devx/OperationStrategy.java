package com.devx;

public interface OperationStrategy {
    Number execute(Number a, Number b);
    Number execute(Number a, Number b, int mod);
}
