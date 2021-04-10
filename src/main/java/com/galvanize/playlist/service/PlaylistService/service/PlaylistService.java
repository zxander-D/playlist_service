package com.galvanize.playlist.service.PlaylistService.service;

import com.galvanize.playlist.service.PlaylistService.Exception.PlaylistExistException;
import com.galvanize.playlist.service.PlaylistService.pojos.PlaylistDto;
import com.galvanize.playlist.service.PlaylistService.pojos.PlaylistEntity;
import com.galvanize.playlist.service.PlaylistService.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    public void create(PlaylistDto playlistDto) throws PlaylistExistException {
        PlaylistEntity entity = playlistRepository.findByName(playlistDto.getName());
        if (entity != null) {
            throw new PlaylistExistException();
        } else {
            playlistRepository.save(new PlaylistEntity(playlistDto.getName()));
        }
    }
}
