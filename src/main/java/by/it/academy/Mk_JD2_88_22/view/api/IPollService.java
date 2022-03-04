package by.it.academy.Mk_JD2_88_22.view.api;

import by.it.academy.Mk_JD2_88_22.model.Poll;
import by.it.academy.Mk_JD2_88_22.model.SavedPoll;

import java.util.List;

public interface IPollService {
    List<String> getArtists();

    List<String> getGenres();

    List<SavedPoll> getPolls();

    void createPoll(Poll poll);

    void addPools(List<SavedPoll> pools);
}
