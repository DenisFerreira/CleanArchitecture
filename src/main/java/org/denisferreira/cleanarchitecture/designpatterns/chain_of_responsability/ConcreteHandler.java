package org.denisferreira.cleanarchitecture.designpatterns.chain_of_responsability;

public class ConcreteHandler extends BaseHandler {
    @Override
    public void handle(Request request) {
        if (canHandle(request)) {
            process(request);
        } else
            super.handle(request);
    }

    private void process(Request request) {
        System.out.println("Processed by ConcreteHandler");
    }

    private boolean canHandle(Request request) {
        return true;
    }
}
