package POJO;

public class GameSkater {
    private int assists;
    private int goals;
    private int shots;
    private int hits;
    private int penaltyMinutes;
    private int gameId;
    private int playerId;
    private int teamId;

    public GameSkater(int assists, int goals, int shots, int hits, int penaltyMinutes, int gameId, int playerId, int teamId) {
        this.assists = assists;
        this.goals = goals;
        this.shots = shots;
        this.hits = hits;
        this.penaltyMinutes = penaltyMinutes;
        this.gameId = gameId;
        this.playerId = playerId;
        this.teamId = teamId;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getShots() {
        return shots;
    }

    public void setShots(int shots) {
        this.shots = shots;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getPenaltyMinutes() {
        return penaltyMinutes;
    }

    public void setPenaltyMinutes(int penaltyMinutes) {
        this.penaltyMinutes = penaltyMinutes;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
}
