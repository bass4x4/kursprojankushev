package Backend;

import POJO.*;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DBQueries {
    private static final String GAME_ID = "GAME_ID";
    private static final String SEASON = "SEASON";
    private static final String TYPE = "TYPE";
    private static final String AWAY_TEAM_ID = "AWAY_TEAM_ID";
    private static final String HOME_TEAM_ID = "HOME_TEAM_ID";
    private static final String AWAY_GOALS = "AWAY_GOALS";
    private static final String HOME_GOALS = "HOME_GOALS";

    private static final String PLAY_ID = "PLAY_ID";
    private static final String PLAY_NUM = "PLAY_NUM";
    private static final String TEAM_ID_FOR = "TEAM_ID_FOR";
    private static final String TEAM_ID_AGAINST = "TEAM_ID_AGAINST";
    private static final String EVENT = "EVENT";
    private static final String PERIOD = "PERIOD";
    private static final String DESCRIPTION = "DESCRIPTION";

    private static final String PLAYER_ID = "PLAYER_ID";
    private static final String FIRST_NAME = "FIRST_NAME";
    private static final String LAST_NAME = "LAST_NAME";
    private static final String NATIONALITY = "NATIONALITY";
    private static final String BIRTH_CITY = "BIRTH_CITY";
    private static final String PRIMARY_POSITION = "PRIMARY_POSITION";

    private static final String TEAM_ID = "TEAM_ID";
    private static final String FRANCHISE_ID = "FRANCHISE_ID";
    private static final String SHORT_NAME = "SHORT_NAME";
    private static final String TEAM_NAME = "TEAM_NAME";
    private static final String ABBREVIATION = "ABBREVIATION";

    private static final String ASSISTS = "ASSISTS";
    private static final String GOALS = "GOALS";
    private static final String SHOTS = "SHOTS";
    private static final String HITS = "HITS";
    private static final String PENALTY_MINUTES = "PENALTY_MINUTES";

    private static final String WON = "WON";
    private static final String HEAD_COACH = "HEAD_COACH";

    private static final String NUMBER_OF_GOALS = "NUMBER_OF_GOALS";
    private static final String NUMBER_OF_TOP_TEAMS = "NUMBER_OF_TOP_TEAMS";

    private static final SQLServerDataSource serverDataSource = getSqlServerDataSource();

    private static Connection connection;
    private static Statement statement;

    static {
        try {
            connection = getSqlServerDataSource().getConnection();
            statement = connection.createStatement();
        } catch (SQLServerException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String insertIntoGame = "INSERT  into game (game_id, season, type, away_team_id, home_team_id, away_goals, home_goals)\n" +
            "VALUES" +
            "(" + GAME_ID + "," + SEASON + "," + TYPE + "," + AWAY_TEAM_ID + "," + HOME_TEAM_ID + "," + AWAY_GOALS + "," + HOME_GOALS + ");";

    private static String insertIntoGamePlays = "INSERT INTO game_plays (play_id, play_num, team_id_for, team_id_against, event, period, description, game_id) \n" +
            "VALUES " +
            "(" + PLAY_ID + "," + PLAY_NUM + "," + TEAM_ID_FOR + "," + TEAM_ID_AGAINST + "," + EVENT + "," + PERIOD + "," + DESCRIPTION + "," + GAME_ID + ");";

    private static String insertIntoPlayerInfo = "INSERT INTO player_info (player_id, firstName, lastName, nationality, birthCity, primaryPosition) \n" +
            "VALUES " +
            "(" + PLAYER_ID + "," + FIRST_NAME + "," + LAST_NAME + "," + NATIONALITY + "," + BIRTH_CITY + "," + PRIMARY_POSITION + ")";

    private static String insertIntoTeam = "INSERT INTO team_info (team_id, franchiseId, shortName, teamName, abbreviation) \n" +
            "VALUES " +
            "(" + TEAM_ID + "," + FRANCHISE_ID + "," + SHORT_NAME + "," + TEAM_NAME + "," + ABBREVIATION + ");";

    private static String insertIntoGamePlaysPlayers = "INSERT INTO game_plays_players (play_id, game_id, player_id) \n" +
            "VALUES" +
            "(" + PLAY_ID + "," + GAME_ID + "," + PLAYER_ID + ")";

    private static String insertIntoGameSkaterStats = "INSERT INTO game_skater_stats(assists, goals, shots, hits, penaltyMinutes, game_id, player_id, team_id) \n" +
            "VALUES" +
            "(" + ASSISTS + "," + GOALS + "," + SHOTS + "," + HITS + "," + PENALTY_MINUTES + "," + GAME_ID + "," + PLAYER_ID + "," + TEAM_ID + ")";

    private static String insertIntoGameTeamsStats = "INSERT INTO game_teams_stats(won, head_coach, goals, shots, hits, game_id, team_id) \n" +
            "VALUES" +
            "(" + WON + "," + HEAD_COACH + "," + GOALS + "," + SHOTS + "," + HITS + "," + GAME_ID + "," + TEAM_ID + ");";

    private static String selectAllGames = "SELECT TOP(100) * " +
            "FROM game;";

    private static String selectAllGamePlays = "SELECT TOP(100) * " +
            "FROM game_plays;";

    private static String selectAllGamePlaysPlayers = "SELECT TOP(100) * " +
            "FROM game_plays_players;";

    private static String selectAllGameSkater = "SELECT TOP(100) * " +
            "FROM game_skater_stats;";

    private static String selectAllGameTeams = "SELECT TOP(100) * " +
            "FROM game_teams_stats;";

    private static String selectAllPlayers = "SELECT TOP(100) * " +
            "FROM player_info;";

    private static String selectAllTeams = "SELECT TOP(100) * " +
            "FROM team_info;";

    private static String selectPlayersWithNumberOfGoals = "exec NumberOfGoalsMoreThan ";

    private static String selectTopTeams = "exec TopTeams ";

    public static void fillGames() {
        SQLServerDataSource serverDataSource = getSqlServerDataSource();
        Connection connection = null;
        try {
            connection = serverDataSource.getConnection();
            Statement statement = connection.createStatement();
            String csvFile = "C:\\Users\\bass4x4\\Documents\\Учеба\\7 семестр\\Базы данных\\Курсовой проект\\nhl-game-data\\game.csv";
            CSVReader reader = new CSVReader(new FileReader(csvFile));
            String[] csvLine;

            while ((csvLine = reader.readNext()) != null) {
                if (!csvLine[0].equals("game_id")) {
                    String query = insertIntoGame.replace(GAME_ID, csvLine[0])
                            .replace(SEASON, addSingleQuotes(csvLine[1]))
                            .replace(TYPE, addSingleQuotes(csvLine[2]))
                            .replace(AWAY_TEAM_ID, csvLine[5])
                            .replace(HOME_TEAM_ID, csvLine[6])
                            .replace(AWAY_GOALS, csvLine[7])
                            .replace(HOME_GOALS, csvLine[8]);
                    statement.executeUpdate(query);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fillPlayerInfo() {
        SQLServerDataSource serverDataSource = getSqlServerDataSource();
        Connection connection = null;
        try {
            connection = serverDataSource.getConnection();
            Statement statement = connection.createStatement();
            String csvFile = "C:\\Users\\bass4x4\\Documents\\Учеба\\7 семестр\\Базы данных\\Курсовой проект\\nhl-game-data\\player_info.csv";
            CSVReader reader = new CSVReader(new FileReader(csvFile));
            String[] csvLine;

            while ((csvLine = reader.readNext()) != null) {
                if (!csvLine[0].equals("player_id")) {
                    String query = insertIntoPlayerInfo.replace(PLAYER_ID, csvLine[0])
                            .replace(FIRST_NAME, addSingleQuotes(csvLine[1]))
                            .replace(LAST_NAME, addSingleQuotes(csvLine[2]))
                            .replace(NATIONALITY, addSingleQuotes(csvLine[3]))
                            .replace(BIRTH_CITY, addSingleQuotes(csvLine[4]))
                            .replace(PRIMARY_POSITION, addSingleQuotes(csvLine[5]));
                    statement.executeUpdate(query);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fillTeamInfo() {
        SQLServerDataSource serverDataSource = getSqlServerDataSource();
        Connection connection = null;
        try {
            connection = serverDataSource.getConnection();
            Statement statement = connection.createStatement();
            String csvFile = "C:\\Users\\bass4x4\\Documents\\Учеба\\7 семестр\\Базы данных\\Курсовой проект\\nhl-game-data\\team_info.csv";
            CSVReader reader = new CSVReader(new FileReader(csvFile));
            String[] csvLine;

            while ((csvLine = reader.readNext()) != null) {
                if (!csvLine[0].equals("team_id")) {
                    String query = insertIntoTeam.replace(TEAM_ID, csvLine[0])
                            .replace(FRANCHISE_ID, csvLine[1])
                            .replace(SHORT_NAME, addSingleQuotes(csvLine[2]))
                            .replace(TEAM_NAME, addSingleQuotes(csvLine[3]))
                            .replace(ABBREVIATION, addSingleQuotes(csvLine[4]));
                    statement.executeUpdate(query);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fillGamePlays() {
        SQLServerDataSource serverDataSource = getSqlServerDataSource();
        Connection connection = null;
        try {
            connection = serverDataSource.getConnection();
            Statement statement = connection.createStatement();
            String csvFile = "C:\\Users\\bass4x4\\Documents\\Учеба\\7 семестр\\Базы данных\\Курсовой проект\\nhl-game-data\\game_plays.csv";
            CSVReader reader = new CSVReader(new FileReader(csvFile));
            String[] csvLine;
            while ((csvLine = reader.readNext()) != null) {
                if (!csvLine[0].equals("play_id")) {
                    String query = insertIntoGamePlays.replace(PLAY_ID, addSingleQuotes(csvLine[0]))
                            .replace(PLAY_NUM, csvLine[2])
                            .replace(TEAM_ID_FOR, csvLine[3].equals("NA") ? "0" : csvLine[3])
                            .replace(TEAM_ID_AGAINST, csvLine[4].equals("NA") ? "0" : csvLine[4])
                            .replace(EVENT, addSingleQuotes(csvLine[5]))
                            .replace(PERIOD, csvLine[9])
                            .replace(DESCRIPTION, addSingleQuotes(csvLine[16]))
                            .replace(GAME_ID, csvLine[1]);
                    try {
                        statement.executeUpdate(query);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SQLServerException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fillGamePlaysPlayers() {
        SQLServerDataSource serverDataSource = getSqlServerDataSource();
        Connection connection = null;
        try {
            connection = serverDataSource.getConnection();
            Statement statement = connection.createStatement();
            String csvFile = "C:\\Users\\bass4x4\\Documents\\Учеба\\7 семестр\\Базы данных\\Курсовой проект\\nhl-game-data\\game_plays_players.csv";
            CSVReader reader = new CSVReader(new FileReader(csvFile));
            String[] csvLine;
            while ((csvLine = reader.readNext()) != null) {
                if (!csvLine[0].equals("play_id")) {
                    String query = insertIntoGamePlaysPlayers.replace(PLAY_ID, addSingleQuotes(csvLine[0]))
                            .replace(GAME_ID, csvLine[1])
                            .replace(PLAYER_ID, csvLine[3]);
                    try {
                        statement.executeUpdate(query);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SQLServerException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fillGameSkaterStats() {
        SQLServerDataSource serverDataSource = getSqlServerDataSource();
        Connection connection = null;
        try {
            connection = serverDataSource.getConnection();
            Statement statement = connection.createStatement();
            String csvFile = "C:\\Users\\bass4x4\\Documents\\Учеба\\7 семестр\\Базы данных\\Курсовой проект\\nhl-game-data\\game_skater_stats.csv";
            CSVReader reader = new CSVReader(new FileReader(csvFile));
            String[] csvLine;
            while ((csvLine = reader.readNext()) != null) {
                if (!csvLine[0].equals("game_id")) {
                    String query = insertIntoGameSkaterStats.replace(ASSISTS, csvLine[4])
                            .replace(GOALS, csvLine[5])
                            .replace(SHOTS, csvLine[6])
                            .replace(HITS, csvLine[7])
                            .replace(PENALTY_MINUTES, csvLine[10])
                            .replace(GAME_ID, csvLine[0])
                            .replace(PLAYER_ID, csvLine[1])
                            .replace(TEAM_ID, csvLine[2]);
                    try {
                        statement.executeUpdate(query);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SQLServerException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fillGameTeamsStats() {
        SQLServerDataSource serverDataSource = getSqlServerDataSource();
        Connection connection = null;
        try {
            connection = serverDataSource.getConnection();
            Statement statement = connection.createStatement();
            String csvFile = "C:\\Users\\bass4x4\\Documents\\Учеба\\7 семестр\\Базы данных\\Курсовой проект\\nhl-game-data\\game_teams_stats.csv";
            CSVReader reader = new CSVReader(new FileReader(csvFile));
            String[] csvLine;
            while ((csvLine = reader.readNext()) != null) {
                if (!csvLine[0].equals("game_id")) {
                    String query = insertIntoGameTeamsStats.replace(WON, csvLine[3].toLowerCase().equals("true") ? "1" : "0")
                            .replace(HEAD_COACH, addSingleQuotes(csvLine[5]))
                            .replace(GOALS, csvLine[6])
                            .replace(SHOTS, csvLine[7])
                            .replace(HITS, csvLine[8])
                            .replace(GAME_ID, csvLine[0])
                            .replace(TEAM_ID, csvLine[1]);
                    try {
                        statement.executeUpdate(query);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SQLServerException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Game> getAllGames() {
        try {
            ResultSet rs = statement.executeQuery(selectAllGames);
            ArrayList<Game> games = new ArrayList<>();
            while (rs.next()) {
                int gameId = rs.getInt("game_id");
                String season = rs.getString("season").trim();
                String type = rs.getString("type").trim();
                int awayTeamId = rs.getInt("away_team_id");
                int homeTeamId = rs.getInt("home_team_id");
                int awayGoals = rs.getInt("away_goals");
                int homeGoals = rs.getInt("home_goals");
                games.add(new Game(gameId, season, type, awayTeamId, homeTeamId, awayGoals, homeGoals));
            }
            return games;
        } catch (SQLServerException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public static List<GamePlays> getAllGamePlays() {
        try {
            ResultSet rs = statement.executeQuery(selectAllGamePlays);
            ArrayList<GamePlays> gamePlays = new ArrayList<>();
            while (rs.next()) {
                String play_id = rs.getString("play_id").trim();
                int play_num = rs.getInt("play_num");
                int team_id_for = rs.getInt("team_id_for");
                int team_id_against = rs.getInt("team_id_against");
                String event = rs.getString("event").trim();
                int period = rs.getInt("period");
                String description = rs.getString("description").trim();
                int game_id = rs.getInt("game_id");
                gamePlays.add(new GamePlays(play_id, play_num, team_id_for, team_id_against, event, period, description, game_id));
            }
            return gamePlays;
        } catch (SQLServerException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public static List<GamePlaysPlayer> getAllGamePlaysPlayers() {
        try {
            ResultSet rs = statement.executeQuery(selectAllGamePlaysPlayers);
            ArrayList<GamePlaysPlayer> gamePlaysPlayers = new ArrayList<>();
            while (rs.next()) {
                String play_id = rs.getString("play_id").trim();
                int game_id = rs.getInt("game_id");
                int player_id = rs.getInt("player_id");
                gamePlaysPlayers.add(new GamePlaysPlayer(play_id, game_id, player_id));
            }
            return gamePlaysPlayers;
        } catch (SQLServerException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public static List<GameSkater> getAllGameSkaters() {
        try {
            ResultSet rs = statement.executeQuery(selectAllGameSkater);
            ArrayList<GameSkater> gameSkaters = new ArrayList<>();
            while (rs.next()) {
                int assists = rs.getInt("assists");
                int goals = rs.getInt("goals");
                int shots = rs.getInt("shots");
                int hits = rs.getInt("hits");
                int penaltyMinutes = rs.getInt("penaltyMinutes");
                int game_id = rs.getInt("game_id");
                int player_id = rs.getInt("player_id");
                int team_id = rs.getInt("team_id");
                gameSkaters.add(new GameSkater(assists, goals, shots, hits, penaltyMinutes, game_id, player_id, team_id));
            }
            return gameSkaters;
        } catch (SQLServerException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public static List<GameTeam> getAllGameTeams() {
        try {
            ResultSet rs = statement.executeQuery(selectAllGameTeams);
            ArrayList<GameTeam> gameTeams = new ArrayList<>();
            while (rs.next()) {
                String won = rs.getString("won").trim();
                String head_coach = rs.getString("head_coach").trim();
                int goals = rs.getInt("goals");
                int shots = rs.getInt("shots");
                int hits = rs.getInt("hits");
                int game_id = rs.getInt("game_id");
                int team_id = rs.getInt("team_id");
                gameTeams.add(new GameTeam(won, head_coach, goals, shots, hits, game_id, team_id));
            }
            return gameTeams;
        } catch (SQLServerException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public static List<TeamInfo> getAllTeamsInfo() {
        try {
            ResultSet rs = statement.executeQuery(selectAllTeams);
            ArrayList<TeamInfo> gameTeams = new ArrayList<>();
            while (rs.next()) {
                int team_id = rs.getInt("team_id");
                int franchiseId = rs.getInt("franchiseId");
                String shortName = rs.getString("shortName");
                String teamName = rs.getString("teamName").trim();
                String abbreviation = rs.getString("abbreviation").trim();
                gameTeams.add(new TeamInfo(team_id, franchiseId, shortName, teamName, abbreviation));
            }
            return gameTeams;
        } catch (SQLServerException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public static Query getPlayersWithNumberOfGoals(Integer numberOfGoals) {
        return getRandomQuery(selectPlayersWithNumberOfGoals + numberOfGoals);
    }

    public static Query getTopTeams(Integer numberOfTopTeams) {
        return getRandomQuery(selectTopTeams + numberOfTopTeams);
    }

    public static Query getRandomQuery(String query) {
        try {
            ResultSet rs = statement.executeQuery(query);
            int columnCount = rs.getMetaData().getColumnCount();
            String[] columnNames = new String[columnCount];
            List<Object[]> objects = new ArrayList<>();
            while (rs.next()) {
                Object[] object = new Object[columnCount];
                for (int i = 1; i < columnCount + 1; i++) {
                    object[i - 1] = rs.getObject(i);
                    columnNames[i - 1] = rs.getMetaData().getColumnName(i);
                }
                objects.add(object);
            }
            return new Query(columnNames, objects);
        } catch (SQLServerException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Query(new String[0], Collections.EMPTY_LIST);
    }



    private static SQLServerDataSource getSqlServerDataSource() {
        SQLServerDataSource serverDataSource = new SQLServerDataSource();
        serverDataSource.setServerName("192.168.56.1");
        serverDataSource.setPortNumber(1337);
        serverDataSource.setDatabaseName("ankushev_kp");
        serverDataSource.setIntegratedSecurity(true);
        return serverDataSource;
    }

    private static String addSingleQuotes(String s) {
        return String.format("'%s'", s);
    }
}