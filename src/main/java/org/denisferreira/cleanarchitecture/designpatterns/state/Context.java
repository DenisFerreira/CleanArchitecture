package org.denisferreira.cleanarchitecture.designpatterns.state;

public class Context {
    private State state;

    public Context(State state) {
        changeState(state);
    }

    public void changeState(State newState) {
        this.state = newState;
    }

    public void doThis() {
        state.doThis();
    }

    public void doThat() {
        state.doThat();
    }

}
