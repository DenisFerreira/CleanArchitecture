package org.denisferreira.cleanarchitecture.designpatterns.chain_of_responsability;

public abstract class BaseHandler implements Handler {
    private Handler next;

    @Override
    public void setNext(Handler nextHandler) {
        this.next = nextHandler;
    }

    @Override
    public void handle(Request request) {
        if (next != null) {
            next.handle(request);
        }
    }
}
