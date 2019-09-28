package com.ps.assessment.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class TeamStanding
{
    @JsonAlias("country_id")
    private int countryId;
    @JsonAlias("country_name")
    private String countryName;
    @JsonAlias("league_id")
    private int leagueId;
    @JsonAlias("league_name")
    private String leagueName;
    @JsonAlias("team_id")
    private int teamId;
    @JsonAlias("team_name")
    private String teamName;
    @JsonAlias("overall_league_position")
    private int overallPosition;

    public TeamStanding() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamStanding that = (TeamStanding) o;
        return countryId == that.countryId &&
                leagueId == that.leagueId &&
                teamId == that.teamId &&
                overallPosition == that.overallPosition &&
                Objects.equals(countryName, that.countryName) &&
                Objects.equals(leagueName, that.leagueName) &&
                Objects.equals(teamName, that.teamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, countryName, leagueId, leagueName, teamId, teamName, overallPosition);
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getOverallPosition() {
        return overallPosition;
    }

    public void setOverallPosition(int overallPosition) {
        this.overallPosition = overallPosition;
    }

    @Override
    public String toString() {
        return "TeamStanding{" +
                "countryId=" + countryId +
                ", countryName='" + countryName + '\'' +
                ", leagueId=" + leagueId +
                ", leagueName='" + leagueName + '\'' +
                ", teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", overallPosition=" + overallPosition +
                '}';
    }
}
