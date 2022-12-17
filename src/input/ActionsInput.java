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

    public ActionsInput(CredentialsInput credentials) {
        this.credentials = credentials;
    }

    public ActionsInput(String startsWith, String movie) {
        this.startsWith = startsWith;
        this.movie = movie;
    }

    public ActionsInput(Filters filters) {
        this.filters = filters;
    }

    public ActionsInput(int count, int rate) {
        this.count = count;
        this.rate = rate;
    }


    public String getType() {
        return type;
    }

    public String getPage() {
        return page;
    }

    public String getMovie() {
        return movie;
    }

    public String getFeature() {
        return feature;
    }

    public CredentialsInput getCredentials() {
        return credentials;
    }

    public String getStartsWith() {
        return startsWith;
    }

    public Filters getFilters() {
        return filters;
    }

    public int getCount() {
        return count;
    }

    public int getRate() {
        return rate;
    }
}
