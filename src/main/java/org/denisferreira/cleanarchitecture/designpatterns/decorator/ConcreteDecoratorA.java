package org.denisferreira.cleanarchitecture.designpatterns.decorator;

public class ConcreteDecoratorA extends BaseDecorator{
    ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void execute() {
        System.out.print("ConcreteDecoratorA;");
        super.execute();
    }
}
