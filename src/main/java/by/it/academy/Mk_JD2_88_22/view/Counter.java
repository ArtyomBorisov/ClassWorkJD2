package by.it.academy.Mk_JD2_88_22.view;

import by.it.academy.Mk_JD2_88_22.view.api.ICounter;

public class Counter implements ICounter {

    private static final Counter instance = new Counter();
    private int count;

    private Counter() {
        this.count = 0;
    }

    @Override
    public void increment() {
        this.count++;
    }

    @Override
    public void decrement() {
        this.count--;
    }

    @Override
    public int getCount() {
        return this.count;
    }

    public static Counter getInstance() {
        return instance;
    }
}
