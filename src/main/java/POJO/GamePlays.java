package POJO;

public class GamePlays {
    private String playId;
    private int playNum;
    private int teamIdFor;
    private int teamIdAgainst;
    private String event;
    private int period;
    private String description;
    private int gameId;

    public GamePlays(String playId, int playNum, int teamIdFor, int teamIdAgainst, String event, int period, String description, int gameId) {
        this.playId = playId;
        this.playNum = playNum;
        this.teamIdFor = teamIdFor;
        this.teamIdAgainst = teamIdAgainst;
        this.event = event;
        this.period = period;
        this.description = description;
        this.gameId = gameId;
    }

    public String getPlayId() {
        return playId;
    }

    public void setPlayId(String playId) {
        this.playId = playId;
    }

    public int getPlayNum() {
        return playNum;
    }

    public void setPlayNum(int playNum) {
        this.playNum = playNum;
    }

    public int getTeamIdFor() {
        return teamIdFor;
    }

    public void setTeamIdFor(int teamIdFor) {
        this.teamIdFor = teamIdFor;
    }

    public int getTeamIdAgainst() {
        return teamIdAgainst;
    }

    public void setTeamIdAgainst(int teamIdAgainst) {
        this.teamIdAgainst = teamIdAgainst;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
}
