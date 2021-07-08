package org.denisferreira.cleanarchitecture.designpatterns.proxy;

public class Proxy implements Service{
    private Service realService;
    Proxy(Service service){
        this.realService = service;
    }

    @Override
    public void operation() {
        if(checkAccess()) {
            realService.operation();
        }
    }

    private boolean checkAccess() {
        return true;
    }


}
