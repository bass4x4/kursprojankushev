package POJO;

public class GamePlaysPlayer {
    private String playId;
    private int gameId;
    private int playerId;

    public GamePlaysPlayer(String playId, int gameId, int playerId) {
        this.playId = playId;
        this.gameId = gameId;
        this.playerId = playerId;
    }

    public String getPlayId() {
        return playId;
    }

    public void setPlayId(String playId) {
        this.playId = playId;
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
}
