package Inheritance.Pr05OnlineRadioDatabase.models;

import Inheritance.Pr05OnlineRadioDatabase.exceptions.*;

public class Song {
    private String artistName;
    private String songName;
    private Integer seconds;
    private Integer minutes;

    public Song(String artistName, String songName, String duration) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.serDuration(duration);
    }

    public Integer getSeconds() {
        return this.seconds;
    }

    private void setSeconds(Integer seconds) {
        if (seconds < 0 || seconds > 59) {
            throw new InvalidSongSecondsException();
        }

        this.seconds = seconds;
    }

    public Integer getMinutes() {
        return this.minutes;
    }

    private void setMinutes(Integer minutes) {
        if (minutes < 0 || minutes > 14) {
            throw new InvalidSongMinutesException();
        }

        this.minutes = minutes;
    }

    private void setArtistName(String artistName) {
        if (artistName == null
                || artistName.length() < 3
                || artistName.length() > 20) {
            throw new InvalidArtistNameException();
        }

        this.artistName = artistName;
    }

    private void setSongName(String songName) {
        if (songName == null
                || songName.length() < 3
                || songName.length() > 30) {
            throw new InvalidSongNameException();
        }

        this.songName = songName;
    }

    private void serDuration(String duration) {
        String[] durationParams = duration.split(":");
        int minutes;
        int seconds;
        try {
            minutes = Integer.parseInt(durationParams[0]);
            seconds = Integer.parseInt(durationParams[1]);
        } catch (NumberFormatException ex) {
            throw new InvalidSongLengthException();
        }

        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }
}
