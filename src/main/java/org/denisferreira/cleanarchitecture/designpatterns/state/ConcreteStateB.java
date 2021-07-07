package org.denisferreira.cleanarchitecture.designpatterns.state;

public class ConcreteStateB implements State {

    private Context context;

    @Override
    public void doThis() {
        System.out.print("doThisB");
    }

    @Override
    public void doThat() {
        System.out.print("doThatB");
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
