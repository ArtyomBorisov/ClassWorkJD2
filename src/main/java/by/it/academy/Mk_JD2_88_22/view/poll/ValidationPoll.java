package by.it.academy.Mk_JD2_88_22.view.poll;

import by.it.academy.Mk_JD2_88_22.view.api.IPollService;

import javax.servlet.http.HttpServletRequest;

public class ValidationPoll {
    private String GENRE_PARAMETER = "genre";
    private String ARTIST_PARAMETER = "artist";
    private String ABOUT_PARAMETER = "about";

    public boolean validate(HttpServletRequest req) {
        IPollService service = PollService.getInstance();
        String[] genres = req.getParameterMap().get(GENRE_PARAMETER);
        String[] artists = req.getParameterMap().get(ARTIST_PARAMETER);
        String[] about_ = req.getParameterMap().get(ABOUT_PARAMETER);

        if (genres == null || artists == null || about_ == null) {
            return false;
        }

        if (genres.length < 3  || genres.length > 5 || about_.length != 1 || artists.length != 1) {
            return false;
        }

        try {
            for (String genre : genres) {
                Integer.parseInt(genre);
            }
            for (String artist : artists) {
                Integer.parseInt(artist);
            }
        } catch (NumberFormatException e) {
            return false;
        }

        if (Integer.parseInt(req.getParameter("artist")) < 1 ||
                Integer.parseInt(req.getParameter("artist")) > service.getArtists().size()) {
            return false;
        }

        for (String genre : genres) {
            if (Integer.parseInt(genre) < 1 ||
                    Integer.parseInt(genre) > service.getGenres().size()) {
                return false;
            }
        }

        return true;
    }
}
