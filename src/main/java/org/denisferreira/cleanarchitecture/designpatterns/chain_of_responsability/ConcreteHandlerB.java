package org.denisferreira.cleanarchitecture.designpatterns.chain_of_responsability;

public class ConcreteHandlerB extends BaseHandler {
    @Override
    public void handle(Request request) {
        if (canHandle(request)) {
            process(request);
        } else
            super.handle(request);
    }

    private void process(Request request) {
        System.out.println("Concrete Handler B should not process this request");
    }

    private boolean canHandle(Request request) {
        return false;
    }
}
