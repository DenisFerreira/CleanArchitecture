package org.denisferreira.cleanarchitecture.designpatterns.facade;

public class Facade {
    private SubSystem linkToSubSystem = new SubSystem();
    private AdditionalFacade optionalAdditionalFacade;
    public Facade(AdditionalFacade optionalAdditionalFacade){
        this.optionalAdditionalFacade= optionalAdditionalFacade;
    }

    public int facadeFun1() {
        return linkToSubSystem.fun1();
    }


    public AdditionalFacade getOptionalAdditionalFacade() {
        return optionalAdditionalFacade;
    }
}
