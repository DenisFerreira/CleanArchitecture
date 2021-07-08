package org.denisferreira.cleanarchitecture.designpatterns.decorator;

public class ConcreteDecorator extends BaseDecorator{
    ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void execute() {
        System.out.print("ConcreteDecorator;");
        super.execute();
    }
}
