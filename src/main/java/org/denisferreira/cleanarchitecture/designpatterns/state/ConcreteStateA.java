package org.denisferreira.cleanarchitecture.designpatterns.state;

public class ConcreteStateA implements State {

    private Context context;

    @Override
    public void doThis() {
        System.out.print("doThisA");
        context.changeState(new ConcreteStateB());
    }

    @Override
    public void doThat() {
        System.out.print("doThatA");
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
