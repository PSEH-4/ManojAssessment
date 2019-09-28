package com.ps.assessment.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class League {

    @JsonAlias("league_id")
    private int leagueId;
    @JsonAlias("league_name")
    private String leagueName;

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

    @Override
    public String toString() {
        return "League{" +
                "leagueId=" + leagueId +
                ", leagueName='" + leagueName + '\'' +
                '}';
    }
}
