package com.ps.assessment.api.client;

import com.ps.assessment.model.Country;
import com.ps.assessment.model.League;
import com.ps.assessment.model.Team;
import com.ps.assessment.model.TeamStanding;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ApiClient {

    private static final String apiKeyUrl = "&APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978";

    public List<Country> getCountries(){
        RestTemplate restTemplate = new RestTemplate();
        String countryResourceUrl
                = "https://apiv2.apifootball.com/?action=get_countries" + apiKeyUrl;
        return Arrays.asList(restTemplate.getForObject(countryResourceUrl,Country[].class));
    }

    public List<League> getLeagues(String countryId){
        RestTemplate restTemplate = new RestTemplate();
        String countryResourceUrl
                = "https://apiv2.apifootball.com/?action=get_leagues&country_id="+countryId + apiKeyUrl;
        return Arrays.asList(restTemplate.getForObject(countryResourceUrl,League[].class));
    }

    public List<Team> getTeams(String leagueId){
        RestTemplate restTemplate = new RestTemplate();
        String countryResourceUrl
                = "https://apiv2.apifootball.com/?action=get_teams&league_id="+leagueId + apiKeyUrl;
        return Arrays.asList(restTemplate.getForObject(countryResourceUrl,Team[].class));
    }

    public List<TeamStanding> getOverallStanding(String leagueId){
        RestTemplate restTemplate = new RestTemplate();
        String countryResourceUrl
                = "https://apiv2.apifootball.com/?action=get_standings&league_id="+leagueId + apiKeyUrl;
        return Arrays.asList(restTemplate.getForObject(countryResourceUrl,TeamStanding[].class));
    }

}
