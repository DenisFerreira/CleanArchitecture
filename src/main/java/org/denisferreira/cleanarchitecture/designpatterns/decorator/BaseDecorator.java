package org.denisferreira.cleanarchitecture.designpatterns.decorator;

public abstract class BaseDecorator implements Component{
    private Component wrappee;
    BaseDecorator(Component component){
        this.wrappee = component;
    }

    @Override
    public void execute() {
        wrappee.execute();
    }
}
