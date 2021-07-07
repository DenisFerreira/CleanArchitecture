package org.denisferreira.cleanarchitecture.designpatterns.strategy;

public class Context {
    private final Request request;
    private Strategy strategy;

    public Context(Strategy strategy, Request request) {
        this.strategy = strategy;
        this.request = request;
    }

    public void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doSomething() {
        strategy.execute(request);
    }
}
