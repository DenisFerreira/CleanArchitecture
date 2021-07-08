package org.denisferreira.cleanarchitecture.designpatterns.proxy;

import org.denisferreira.cleanarchitecture.designpatterns.DesignPatternTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProxyTest extends DesignPatternTest {

    @Test
    public void test() {
        ServiceImpl service = new ServiceImpl();
        Proxy proxy = new Proxy(service);
        proxy.operation();
        assertEquals("Service;", outputStreamCaptor.toString()
                .trim());
    }
}