package Backend;

public class DBQueries {
    private static final String GAME_ID = "GAME_ID";
    private static final String SEASON = "SEASON";
    private static final String TYPE = "TYPE";
    private static final String AWAY_TEAM_ID = "AWAY_TEAM_ID";
    private static final String HOME_TEAM_ID = "HOME_TEAM_ID";
    private static final String AWAY_GOALS = "AWAY_GOALS";
    private static final String HOME_GOALS = "HOME_GOALS";


    private static String insertIntoGame = "INSERT  into game (game_id, season, type, away_team_id, home_team_id, away_goals, home_goals)\n" +
            "values" +
            "(2, 1, 'P', 1, 2, 1, 3);";
}
