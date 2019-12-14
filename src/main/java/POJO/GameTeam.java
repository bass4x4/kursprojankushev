package POJO;

public class GameTeam {
    private String won;
    private String headCoach;
    private int goals;
    private int shots;
    private int hits;
    private int gameId;
    private int teamId;

    public GameTeam(String won, String headCoach, int goals, int shots, int hits, int gameId, int teamId) {
        this.won = won;
        this.headCoach = headCoach;
        this.goals = goals;
        this.shots = shots;
        this.hits = hits;
        this.gameId = gameId;
        this.teamId = teamId;
    }

    public String getWon() {
        return won;
    }

    public void setWon(String won) {
        this.won = won;
    }

    public String getHeadCoach() {
        return headCoach;
    }

    public void setHeadCoach(String headCoach) {
        this.headCoach = headCoach;
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

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }
}
