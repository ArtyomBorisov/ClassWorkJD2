package by.it.academy.Mk_JD2_88_22.controller.web.listeners;

import by.it.academy.Mk_JD2_88_22.view.poll.BinaryFilePollLoader;
import by.it.academy.Mk_JD2_88_22.view.poll.PollService;
import by.it.academy.Mk_JD2_88_22.view.api.IPollService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    private static final String FILE_PATH_INIT_PARAM = "fileForSave";
    private final IPollService pollService;

    public ContextListener() {
        this.pollService = PollService.getInstance();
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String fileForSave = servletContextEvent.getServletContext().getInitParameter(FILE_PATH_INIT_PARAM);

        new BinaryFilePollLoader(pollService).load(fileForSave);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        String fileForSave = servletContextEvent.getServletContext().getInitParameter(FILE_PATH_INIT_PARAM);

        new BinaryFilePollLoader(pollService).unload(fileForSave);
    }
}
