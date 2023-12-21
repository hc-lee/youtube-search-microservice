package com.hansol.youtubesearchmicroservice.configs;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.youtube.YouTube;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Configuration
public class YouTubeConfig {

    // YouTube API Client
    @Bean
    public YouTube youTube() throws GeneralSecurityException, IOException {
        return new YouTube.Builder(GoogleNetHttpTransport.newTrustedTransport(), getJsonFactory(), null)
                .setApplicationName("youtube-search-microservice")
                .build();
    }

    private JsonFactory getJsonFactory() {
        return GsonFactory.getDefaultInstance();
    }
}