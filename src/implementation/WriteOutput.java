package implementation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import input.Input;
import input.MovieInput;
import input.UserInput;

public class WriteOutput {
    public WriteOutput(Input input, ArrayNode output, boolean error) {
        ObjectNode write = output.addObject();

        if (error) {
            write.put("error", "Error");
        } else {
            write.put("error", (JsonNode) null);
        }

       if (error) {
            write.putArray("currentMoviesList");
       } else {
           ArrayNode currentMovieList = write.putArray("currentMoviesList");
           for (MovieInput movie : StartNavigation.getStartNavigation().getCurrentMoviesList()) {
               ObjectNode write2 = currentMovieList.addObject();
               movieOutput(movie, write2);
           }
       }


        if (error) {
            write.put("currentUser", (JsonNode) null);
        } else {
            userOutput(StartNavigation.getStartNavigation().getCurrentUser(), write);
        }
    }

    public void movieOutput(MovieInput movie, ObjectNode write) {
        write.put("name", movie.getName());
        write.put("year", movie.getYear());
        write.put("duration", movie.getDuration());
        ArrayNode genres = write.putArray("genres");
        for (String genre : movie.getGenres()) {
            genres.add(genre);
        }
        ArrayNode actors = write.putArray("actors");
        for (String actor : movie.getActors()) {
            actors.add(actor);
        }
        ArrayNode countriesBanned = write.putArray("countriesBanned");
        for (String country : movie.getCountriesBanned()) {
            countriesBanned.add(country);
        }
        write.put("numLikes", movie.getNumLikes());
        write.put("rating", movie.getRating());
        write.put("numRatings", movie.getNumRatings());
    }

    public void userOutput(UserInput user, ObjectNode write) {
        ObjectNode currentUser = write.putObject("currentUser");
        ObjectNode credentials = currentUser.putObject("credentials");
        credentials.put("name",user.getCredentials().getName());
        credentials.put("password", user.getCredentials().getPassword());
        credentials.put("accountType", user.getCredentials().getAccountType());
        credentials.put("country", user.getCredentials().getCountry());
        credentials.put("balance", Integer.toString(user.getCredentials().getBalance()));
        currentUser.put("tokensCount", user.getTokensCount());
        currentUser.put("numFreePremiumMovies", user.getNumFreePremiumMovies());

        ArrayNode purchasedMovies = currentUser.putArray("purchasedMovies");
        if (StartNavigation.getStartNavigation().getCurrentUser().getPurchasedMovies() != null) {
            for (MovieInput movie : StartNavigation.getStartNavigation().getCurrentUser().getPurchasedMovies()) {
                ObjectNode write2 = purchasedMovies.addObject();
                movieOutput(movie, write2);
            }
        }

        ArrayNode watchedMovies = currentUser.putArray("watchedMovies");
        if (StartNavigation.getStartNavigation().getCurrentUser().getWatchedMovies() != null) {
            for (MovieInput movie : StartNavigation.getStartNavigation().getCurrentUser().getWatchedMovies()) {
                ObjectNode write2 = watchedMovies.addObject();
                movieOutput(movie, write2);
            }
        }

        ArrayNode likedMovies = currentUser.putArray("likedMovies");
        if (StartNavigation.getStartNavigation().getCurrentUser().getLikedMovies() != null) {
            for (MovieInput movie : StartNavigation.getStartNavigation().getCurrentUser().getLikedMovies()) {
                ObjectNode write2 = likedMovies.addObject();
                movieOutput(movie, write2);
            }
        }

        ArrayNode ratedMovies = currentUser.putArray("ratedMovies");
        if (StartNavigation.getStartNavigation().getCurrentUser().getRatedMovies() != null) {
            for (MovieInput movie : StartNavigation.getStartNavigation().getCurrentUser().getRatedMovies()) {
                ObjectNode write2 = ratedMovies.addObject();
                movieOutput(movie, write2);
            }
        }

    }
}
