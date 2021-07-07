package org.denisferreira.cleanarchitecture.designpatterns.chain_of_responsability;

public interface Handler {
    void setNext(Handler nextHandler);

    void handle(Request request);
}
