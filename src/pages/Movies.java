package pages;

import implementation.StartNavigation;
import input.ActionsInput;
import input.Filters;
import input.Input;
import input.MovieInput;

import java.util.ArrayList;

public final class Movies extends ActionsInput implements Page {
    private Input input;

    public Movies(final Input input) {
        this.input = input;
    }

    public Movies(final String startsWith, final Input input) {
        super(startsWith, null);
        this.input = input;
    }

    public Movies(final Filters filters, final Input input) {
        super(filters);
        this.input = input;
    }

    /**Method that creates the output for when the pge is changed in 'movies' */
    @Override
    public void action() {
        StartNavigation.getStartNavigation().setCurrentMoviesList(new ArrayList<>());
        for (MovieInput movie : input.getMovies()) {
            boolean isBanned = false;
            for (String country : movie.getCountriesBanned()) {
                String userCountry = StartNavigation.getStartNavigation().getCurrentUser().
                        getCredentials().getCountry();
                if (userCountry.equals(country)) {
                    isBanned = true;
                    break;
                }
            }

            if (!isBanned) {
                StartNavigation.getStartNavigation().getCurrentMoviesList().add(movie);
            }
        }
    }

    /**Method that searches for a movie*/
    public void search() {
        for (int i = 0; i < StartNavigation.getStartNavigation().getCurrentMoviesList().size();
             i++) {
            if (!StartNavigation.getStartNavigation().getCurrentMoviesList().get(i).getName()
                    .startsWith(getStartsWith())) {
                StartNavigation.getStartNavigation().getCurrentMoviesList().remove(i);
                i--;
            }
        }
    }

    /**Method that filters the current movie list*/
    public void filter(final ActionsInput action) {
        this.action();
        if (action.getFilters().getContains() != null) {
            ArrayList<MovieInput> currentMovieList;
            currentMovieList = StartNavigation.getStartNavigation().getCurrentMoviesList();
            if (action.getFilters().getContains().getActors() != null) {
                for (int i = 0; i < currentMovieList.size(); i++) {
                    boolean isGood = true;
                    for (String actor1 : action.getFilters().getContains().getActors()) {
                        boolean found = false;
                        for (String actor2 : currentMovieList.get(i).getActors()) {
                            if (actor1.equals(actor2)) {
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            isGood = false;
                            break;
                        }
                    }
                    if (!isGood) {
                        currentMovieList.remove(i);
                        i--;
                    }
                }
            }

            if (action.getFilters().getContains().getGenre() != null) {
                for (int i = 0; i < currentMovieList.size(); i++) {
                    boolean isGood = true;
                    for (String genre1 : action.getFilters().getContains().getGenre()) {
                        boolean found = false;
                        for (String genre2 : currentMovieList.get(i).getGenres()) {
                            if (genre1.equals(genre2)) {
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            isGood = false;
                            break;
                        }
                    }
                    if (!isGood) {
                        currentMovieList.remove(i);
                        i--;
                    }
                }
            }

        }



        if (action.getFilters().getSort() != null) {
            if (action.getFilters().getSort().getDuration() != null) {
                StartNavigation.getStartNavigation().getCurrentMoviesList().sort((o1, o2) -> {
                    if (o1.getDuration() > o2.getDuration()) {
                        if (action.getFilters().getSort().getDuration().equals("decreasing")) {
                            return -1;
                        } else {
                            return 1;
                        }
                    } else if (o1.getDuration() < o2.getDuration()) {
                        if (action.getFilters().getSort().getDuration().equals("decreasing")) {
                            return 1;
                        } else {
                            return -1;
                        }
                    } else if (action.getFilters().getSort().getRating() != null) {
                        if (action.getFilters().getSort().getRating().equals("increasing")) {
                            return Double.compare(o1.getRating(), o2.getRating());
                        } else {
                            if (o1.getRating() > o2.getRating()) {
                                return -1;
                            } else {
                                return 1;
                            }
                        }
                    } else {
                        return 0;
                    }
                });
            } else {
                StartNavigation.getStartNavigation().getCurrentMoviesList().sort((o1, o2) -> {
                    if (action.getFilters().getSort().getRating().equals("increasing")) {
                        return Double.compare(o1.getRating(), o2.getRating());
                    } else {
                        if (o1.getRating() > o2.getRating()) {
                            return -1;
                        } else {
                            return 1;
                        }
                    }
                });
            }
        }
    }
}
