package org.denisferreira.cleanarchitecture.designpatterns.state;

import org.denisferreira.cleanarchitecture.designpatterns.DesignPatternTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StateTest extends DesignPatternTest {

    @Test
    public void test() {
        ConcreteStateA a = new ConcreteStateA();
        Context context = new Context(a);
        a.setContext(context);
        context.doThis();
        context.doThat();
        assertEquals("doThisAdoThatB", outputStreamCaptor.toString()
                .trim());
    }
}