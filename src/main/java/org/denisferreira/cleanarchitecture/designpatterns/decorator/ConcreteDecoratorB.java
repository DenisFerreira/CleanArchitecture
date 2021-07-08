package org.denisferreira.cleanarchitecture.designpatterns.decorator;

public class ConcreteDecoratorB extends BaseDecorator{
    ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void execute() {
        System.out.print("ConcreteDecoratorB;");
        super.execute();
    }
}
