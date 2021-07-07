package org.denisferreira.cleanarchitecture.designpatterns.strategy;

import org.denisferreira.cleanarchitecture.designpatterns.DesignPatternTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StrategyTest extends DesignPatternTest {

    @Test
    public void test() {
        ConcreteStrategy strategy = new ConcreteStrategy();
        Context context = new Context(strategy, new Request());
        context.doSomething();
        assertEquals("100L", outputStreamCaptor.toString()
                .trim());
        context.changeStrategy(new ConcreteStrategy());
    }

}