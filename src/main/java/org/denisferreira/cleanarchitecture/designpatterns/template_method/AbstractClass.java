package org.denisferreira.cleanarchitecture.designpatterns.template_method;

public abstract class AbstractClass {
    public void templateMethod() {
        step1();
        if (step2())
            step3();
        else
            step4();
    }

    protected abstract void step1();

    protected abstract boolean step2();

    protected abstract void step3();

    protected abstract void step4();

}
