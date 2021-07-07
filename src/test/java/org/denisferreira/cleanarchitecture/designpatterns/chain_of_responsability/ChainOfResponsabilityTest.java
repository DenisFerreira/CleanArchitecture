package org.denisferreira.cleanarchitecture.designpatterns.chain_of_responsability;

import org.denisferreira.cleanarchitecture.designpatterns.DesignPatternTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChainOfResponsabilityTest extends DesignPatternTest {

    @Test
    public void test() {
        ConcreteHandlerB c1 = new ConcreteHandlerB();
        ConcreteHandler c2 = new ConcreteHandler();
        ConcreteHandlerB c3 = new ConcreteHandlerB();
        c1.setNext(c2);
        c2.setNext(c3);
        c1.handle(new Request());
        assertEquals("Processed by ConcreteHandler", outputStreamCaptor.toString()
                .trim());
    }


}