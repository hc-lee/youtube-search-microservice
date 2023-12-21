package com.hansol.youtubesearchmicroservice.controllers;

import com.hansol.youtubesearchmicroservice.dtos.SearchParams;
import com.hansol.youtubesearchmicroservice.services.YouTubeSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/youtube")
public class YouTubeSearchController {
    @Autowired
    YouTubeSearchService youTubeSearchService;

    @PostMapping("/search")
    public ResponseEntity<String> search(@RequestBody SearchParams searchParams) {
        return youTubeSearchService.performSearch(searchParams.getSongName(), searchParams.getArtistName());
    }
}