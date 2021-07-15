package org.denisferreira.cleanarchitecture.designpatterns.facade;

public class AdditionalFacade{
    private SubSystem subSystem = new SubSystem();
    public int additionalFun2() {
        return subSystem.fun2();
    }
}
