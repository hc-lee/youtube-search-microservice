package com.hansol.youtubesearchmicroservice.dtos;

public class SearchParams {

    private String songName;
    private String artistName;

    public SearchParams(String songName, String artistName) {
        this.songName = songName;
        this.artistName = artistName;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtistName() {
        return artistName;
    }

}
