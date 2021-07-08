package org.denisferreira.cleanarchitecture.designpatterns.proxy;

public class ServiceImpl implements Service{
    @Override
    public void operation() {
        System.out.print("Service;");
    }
}
