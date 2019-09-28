package com.ps.assessment.Controller;

import com.ps.assessment.Exception.MatchNotFoundException;
import com.ps.assessment.model.TeamStanding;
import com.ps.assessment.service.FootballApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FootballApiController {

    @Autowired
    private FootballApiService footballApiService;

    @RequestMapping(value = "/overallStandings/{countryName}/{leagueName}/{teamName}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity getOverallStandings(@PathVariable String countryName,
                                              @PathVariable String leagueName,
                                              @PathVariable String teamName) throws MatchNotFoundException {
        return footballApiService.getOverallPosition(countryName, leagueName, teamName);
    }

}
