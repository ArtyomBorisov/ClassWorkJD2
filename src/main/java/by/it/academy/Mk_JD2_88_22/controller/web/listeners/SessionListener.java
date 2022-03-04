package by.it.academy.Mk_JD2_88_22.controller.web.listeners;

import by.it.academy.Mk_JD2_88_22.view.Counter;
import by.it.academy.Mk_JD2_88_22.view.api.ICounter;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    private final ICounter iCounter;

    public SessionListener() {
        this.iCounter = Counter.getInstance();
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        iCounter.increment();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        iCounter.decrement();
    }
}
