package com.ps.assessment.service;

import com.ps.assessment.Exception.MatchNotFoundException;
import com.ps.assessment.api.client.ApiClient;
import com.ps.assessment.model.Country;
import com.ps.assessment.model.League;
import com.ps.assessment.model.TeamStanding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class FootballApiService {

    @Autowired
    private ApiClient apiClient;
    public TeamStanding getOverallPosition(String countryName, String leagueName, String teamName) throws MatchNotFoundException{
        Predicate<Country> countryPredicate =
                country -> country.getCountryName().equals(countryName);
        Predicate<League> leaguePredicate =
                league -> league.getLeagueName().equals(leagueName);
        Predicate<TeamStanding> teamPredicate =
                teamStanding -> teamStanding.getTeamName().equals(teamName);
        TeamStanding teamStanding = new TeamStanding();
        List<Country> country = apiClient.getCountries().stream().filter(countryPredicate).collect(Collectors.toList());
        if (country != null && country.size()>0) {
            List<League> league = apiClient.getLeagues(String.valueOf(country.get(0).getCountryId())).stream().filter(leaguePredicate)
                    .collect(Collectors.toList());
            if (league != null && league.size()>0) {
                teamStanding = apiClient.getOverallStanding(String.valueOf(league.get(0).getLeagueId()))
                        .stream().filter(teamPredicate).collect(Collectors.toList()).get(0);
                teamStanding.setCountryId(country.get(0).getCountryId());
            }
            else{
                throw new MatchNotFoundException("League doesn't exist");
            }
        }
        else{
            throw new MatchNotFoundException("Country doesn't exist");
        }
        return teamStanding;
    }
}
