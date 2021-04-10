package com.galvanize.playlist.service.PlaylistService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("playlist")
public class PlaylistController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createPlaylist(String newPlaylist){
        return "{\"message\": \"Successfully created\"}";
    }
}
