package POJO;

public class TeamInfo {
    private int teamId;
    private int franchiseId;
    private String shortName;
    private String teamName;
    private String abbreviation;

    public TeamInfo(int teamId, int franchiseId, String shortName, String teamName, String abbreviation) {
        this.teamId = teamId;
        this.franchiseId = franchiseId;
        this.shortName = shortName;
        this.teamName = teamName;
        this.abbreviation = abbreviation;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getFranchiseId() {
        return franchiseId;
    }

    public void setFranchiseId(int franchiseId) {
        this.franchiseId = franchiseId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
