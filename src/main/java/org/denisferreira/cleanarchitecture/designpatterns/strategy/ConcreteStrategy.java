package org.denisferreira.cleanarchitecture.designpatterns.strategy;

public class ConcreteStrategy implements Strategy {
    @Override
    public void execute(Request request) {
        System.out.println("100L");
    }
}
