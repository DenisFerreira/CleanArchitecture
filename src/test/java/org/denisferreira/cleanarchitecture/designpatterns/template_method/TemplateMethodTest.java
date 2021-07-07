package org.denisferreira.cleanarchitecture.designpatterns.template_method;

import org.denisferreira.cleanarchitecture.designpatterns.DesignPatternTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemplateMethodTest extends DesignPatternTest {

    @Test
    public void test() {
        ConcreteClass concreteClass = new ConcreteClass();
        concreteClass.templateMethod();
        assertEquals("Step1Step4", outputStreamCaptor.toString()
                .trim());
    }
}