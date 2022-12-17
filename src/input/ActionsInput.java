package input;

public class ActionsInput {
    private String type;
    private String page;
    private String movie;
    private String feature;
    private CredentialsInput credentials;
    private String startsWith;
    private Filters filters;
    private int count;
    private int rate;

    public ActionsInput() {
    }

    public ActionsInput(final CredentialsInput credentials) {
        this.credentials = credentials;
    }

    public ActionsInput(final String startsWith, final String movie) {
        this.startsWith = startsWith;
        this.movie = movie;
    }

    public ActionsInput(final Filters filters) {
        this.filters = filters;
    }

    public ActionsInput(final int count, final int rate) {
        this.count = count;
        this.rate = rate;
    }

    /** Method that gets the type of an action*/
    public String getType() {
        return type;
    }

    /** Method that gets the page of an action*/
    public String getPage() {
        return page;
    }

    /** Method that gets the movie of an action*/
    public String getMovie() {
        return movie;
    }

    /** Method that gets the feature of an action*/
    public String getFeature() {
        return feature;
    }

    /** Method that gets the credentials of an action*/
    public CredentialsInput getCredentials() {
        return credentials;
    }

    /** Method that gets the 'startsWith' field of an action*/
    public String getStartsWith() {
        return startsWith;
    }

    /** Method that gets the filters of an action*/
    public Filters getFilters() {
        return filters;
    }

    /** Method that gets the 'count' field of an action*/
    public int getCount() {
        return count;
    }

    /** Method that gets the rate of an action*/
    public int getRate() {
        return rate;
    }
}
