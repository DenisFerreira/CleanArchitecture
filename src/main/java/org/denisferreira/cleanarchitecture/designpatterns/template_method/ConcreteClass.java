package org.denisferreira.cleanarchitecture.designpatterns.template_method;

public class ConcreteClass extends AbstractClass {
    @Override
    protected void step1() {
        System.out.print("Step1");
    }

    @Override
    protected boolean step2() {
        return false;
    }

    @Override
    protected void step3() {

    }

    @Override
    protected void step4() {
        System.out.print("Step4");
    }
}
