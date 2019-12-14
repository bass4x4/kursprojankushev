package POJO;

public class Game {
    private int gameId;
    private String season;
    private String type;
    private int awayTeamId;
    private int homeTeamId;
    private int awayGoals;
    private int homeGoals;

    public Game(int gameId, String season, String type, int awayTeamId, int homeTeamId, int awayGoals, int homeGoals) {
        this.gameId = gameId;
        this.season = season;
        this.type = type;
        this.awayTeamId = awayTeamId;
        this.homeTeamId = homeTeamId;
        this.awayGoals = awayGoals;
        this.homeGoals = homeGoals;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAwayTeamId() {
        return awayTeamId;
    }

    public void setAwayTeamId(int awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public int getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(int homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }
}
