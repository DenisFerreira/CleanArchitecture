package org.denisferreira.cleanarchitecture.designpatterns.decorator;

import org.denisferreira.cleanarchitecture.designpatterns.DesignPatternTest;
import org.denisferreira.cleanarchitecture.designpatterns.template_method.ConcreteClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecoratorTest extends DesignPatternTest {
    @Test
    public void test() {
        ConcreteComponent component = new ConcreteComponent();
        ConcreteDecorator decorator = new ConcreteDecorator(component);
        ConcreteDecoratorA decoratorA = new ConcreteDecoratorA(decorator);
        ConcreteDecoratorB decoratorB = new ConcreteDecoratorB(decoratorA);
        decoratorB.execute();
        assertEquals("ConcreteDecoratorB;ConcreteDecoratorA;ConcreteDecorator;ConcreteComponent;", outputStreamCaptor.toString()
                .trim());
    }

}