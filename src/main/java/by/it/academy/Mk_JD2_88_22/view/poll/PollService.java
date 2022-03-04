package by.it.academy.Mk_JD2_88_22.view.poll;

import by.it.academy.Mk_JD2_88_22.view.api.IPollService;
import by.it.academy.Mk_JD2_88_22.model.Poll;
import by.it.academy.Mk_JD2_88_22.model.SavedPoll;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PollService implements IPollService {
    private List<String> artists = new ArrayList<>();
    private List<String> genres = new ArrayList<>();
    private List<SavedPoll> pools = new ArrayList<>();
    public static final PollService instance = new PollService();

    private PollService() {
        this.artists.add("Ария");
        this.artists.add("Queen");
        this.artists.add("Баста");
        this.artists.add("AC/DC");

        this.genres.add("Поп");
        this.genres.add("Рок");
        this.genres.add("Джаз");
        this.genres.add("Классика");
        this.genres.add("Рэп");
        this.genres.add("Эстрадная");
        this.genres.add("Народная");
        this.genres.add("Хип-хоп");
        this.genres.add("Инди");
        this.genres.add("Шансон");
    }

    @Override
    public List<String> getArtists() {
        return Collections.unmodifiableList(artists);
    }

    @Override
    public List<String> getGenres() {
        return Collections.unmodifiableList(genres);
    }

    @Override
    public List<SavedPoll> getPolls() {
        return Collections.unmodifiableList(pools);
    }

    @Override
    public void createPoll(Poll poll) {
        SavedPoll saved = new SavedPoll(LocalDateTime.now(), poll);
        this.createPoll(saved);
    }

    void createPoll(SavedPoll savedPoll){
        this.pools.add(savedPoll);
    }

    @Override
    public void addPools(List<SavedPoll> pools) {
        this.pools.add((SavedPoll) pools);
    }

    public static PollService getInstance() {
        return instance;
    }
}
