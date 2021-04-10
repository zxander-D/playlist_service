package com.galvanize.playlist.service.PlaylistService.controller;

import com.galvanize.playlist.service.PlaylistService.Exception.PlaylistExistException;
import com.galvanize.playlist.service.PlaylistService.pojos.PlaylistDto;
import com.galvanize.playlist.service.PlaylistService.pojos.PlaylistSongsDTO;
import com.galvanize.playlist.service.PlaylistService.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("playlist")
public class PlaylistController {

    @Autowired
    PlaylistService playlistService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createPlaylist(@RequestBody PlaylistDto playlistDto) throws PlaylistExistException {
        playlistService.create(playlistDto);
        return "{\"message\": \"Successfully created\"}";
    }

    @GetMapping
    public List<PlaylistDto> getPlaylist() {
       List<PlaylistDto> dtos = playlistService.fetchAll();
       return dtos;
    }

    @PostMapping("{name}/addSong")
    @ResponseStatus(HttpStatus.CREATED)
    public void addSong(@PathVariable String name, @RequestBody PlaylistSongsDTO songDTO) {
        playlistService.addSong(name, songDTO);
    }

    @GetMapping("{name}")
    public List<PlaylistSongsDTO> findSongs(@PathVariable String name) {
        return playlistService.findSongs(name);
    }
}
