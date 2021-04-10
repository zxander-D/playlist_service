package com.galvanize.playlist.service.PlaylistService.controller;

import com.galvanize.playlist.service.PlaylistService.Exception.PlaylistExistException;
import com.galvanize.playlist.service.PlaylistService.pojos.PlaylistDto;
import com.galvanize.playlist.service.PlaylistService.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("playlist")
public class PlaylistController {

    @Autowired
    PlaylistService playlistService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createPlaylist(PlaylistDto playlistDto) throws PlaylistExistException {
        playlistService.create(playlistDto);
        return "{\"message\": \"Successfully created\"}";
    }
}
