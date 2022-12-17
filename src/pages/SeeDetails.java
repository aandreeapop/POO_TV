package pages;

import implementation.StartNavigation;
import input.ActionsInput;
import input.MovieInput;

import java.util.ArrayList;

public class SeeDetails extends ActionsInput implements Page {
    private boolean error;

    public SeeDetails(String movie) {
        super(null, movie);
    }

    public SeeDetails() {}

    public SeeDetails (int rate) {
        super(0, rate);
    }

    public boolean isError() {
        return error;
    }

    @Override
    public void action() {
        error = true;
        for (MovieInput movie : StartNavigation.getStartNavigation().getCurrentMoviesList()) {
            if (this.getMovie().equals(movie.getName())) {
                StartNavigation.getStartNavigation().setCurrentMoviesList(new ArrayList<>());
                StartNavigation.getStartNavigation().getCurrentMoviesList().add(movie);
                error = false;
                break;
            }
        }
    }

    public void purchase() {
        int numFreePremiumMovies = StartNavigation.getStartNavigation().getCurrentUser().getNumFreePremiumMovies();
        MovieInput purchasedMovie = StartNavigation.getStartNavigation().getCurrentMoviesList().get(0);
        error = false;
        if (!purchasedMovie.isPurchased()) {
            if (StartNavigation.getStartNavigation().getCurrentUser().getCredentials().getAccountType()
                    .equals("premium") && numFreePremiumMovies != 0) {
                StartNavigation.getStartNavigation().getCurrentUser().setNumFreePremiumMovies(numFreePremiumMovies - 1);
            } else {
                int tokensCount = StartNavigation.getStartNavigation().getCurrentUser().getTokensCount();
                if (tokensCount < 2) {
                    error = true;
                } else {
                    StartNavigation.getStartNavigation().getCurrentUser().setTokensCount(tokensCount - 2);
                }
            }
            StartNavigation.getStartNavigation().getCurrentUser().getPurchasedMovies().add(purchasedMovie);
        } else {
            error = true;
        }
    }

    public void watch() {
        error = false;
        MovieInput watchedMovie = StartNavigation.getStartNavigation().getCurrentMoviesList().get(0);
        if (watchedMovie.isPurchased() && !watchedMovie.isWatched()) {
            StartNavigation.getStartNavigation().getCurrentUser().getWatchedMovies().add(watchedMovie);
        } else {
            error = true;
        }
    }

    public void like() {
        error = false;
        MovieInput likedMovie = StartNavigation.getStartNavigation().getCurrentMoviesList().get(0);
        if (likedMovie.isWatched() && !likedMovie.isLiked()) {
            StartNavigation.getStartNavigation().getCurrentUser().getLikedMovies().add(likedMovie);
            likedMovie.setNumLikes(likedMovie.getNumLikes() + 1);
        } else {
            error = true;
        }
    }

    public void rate() {
        error = false;
        MovieInput ratedMovie = StartNavigation.getStartNavigation().getCurrentMoviesList().get(0);
        if (ratedMovie.isWatched() && !ratedMovie.isRated() && this.getRate() <= 5) {
            ratedMovie.setNumRatings(ratedMovie.getNumRatings() + 1);
            ratedMovie.getRatings().add(this.getRate());
            double rating = 0;
            for (int rate : ratedMovie.getRatings()) {
                rating += rate;
            }
            ratedMovie.setRating(rating/ratedMovie.getNumRatings());
            StartNavigation.getStartNavigation().getCurrentUser().getRatedMovies().add(ratedMovie);
        } else {
            error = true;
        }
    }
}
