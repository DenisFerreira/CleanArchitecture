package org.denisferreira.cleanarchitecture.designpatterns.facade;

import org.denisferreira.cleanarchitecture.designpatterns.DesignPatternTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacadeTest extends DesignPatternTest {

    @Test
    public void test() {
        AdditionalFacade additionalFacade = new AdditionalFacade();
        Facade facade = new Facade(additionalFacade);
        assertEquals(1, facade.facadeFun1());
        assertEquals(2, facade.getOptionalAdditionalFacade().additionalFun2());
    }
}