package com.hansol.youtubesearchmicroservice.services;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;

@Service
public class YouTubeSearchService {

    @Value("${youtube.api.key}")
    private String apiKey;

    private final YouTube youTube;

    public YouTubeSearchService(YouTube youTube) {
        this.youTube = youTube;
    }

    // Extracts the video ID from the search response and returns the YouTube URL
    public ResponseEntity<String> performSearch(String songName, String artistName) {
        try {
            // Combine songName and artistName to form the search query and instantiate the search object
            String query = songName + " " + artistName;
            YouTube.Search.List search = youTube.search().list(Collections.singletonList("id,snippet"));

            search.setKey(apiKey);
            search.setQ(query);
            search.setType(Collections.singletonList("video"));
            search.setMaxResults(1L);   // Get only the top result

            // Execute the search and extracts the response
            SearchListResponse searchResponse = search.execute();
            String videoId = extractVideoId(searchResponse);

            if (videoId != null) {
                String youtubeUrl = "https://www.youtube.com/watch?v=" + videoId;
                String jsonResponse = "{\"url\": \"" + youtubeUrl + "\"}";

                return ResponseEntity.ok(jsonResponse);

            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Helper method to extract the video ID from the search response
    private String extractVideoId(SearchListResponse searchResponse) {
        if (searchResponse.getItems() != null && !searchResponse.getItems().isEmpty()) {
            SearchResult topResult = searchResponse.getItems().get(0);
            return topResult.getId().getVideoId();
        }
        return null;
    }
}