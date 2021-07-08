package org.denisferreira.cleanarchitecture.designpatterns.decorator;

public class ConcreteComponent implements Component{
    @Override
    public void execute() {
        System.out.print("ConcreteComponent;");
    }
}
