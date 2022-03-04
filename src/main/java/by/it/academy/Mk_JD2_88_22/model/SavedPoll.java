package by.it.academy.Mk_JD2_88_22.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SavedPoll implements Serializable {
    private final LocalDateTime time;
    private final Poll poll;

    public SavedPoll(LocalDateTime time, Poll poll) {
        this.time = time;
        this.poll = poll;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Poll getPool() {
        return poll;
    }
}
