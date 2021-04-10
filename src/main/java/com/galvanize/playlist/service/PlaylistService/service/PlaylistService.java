package com.galvanize.playlist.service.PlaylistService.service;

import com.galvanize.playlist.service.PlaylistService.Exception.PlaylistExistException;
import com.galvanize.playlist.service.PlaylistService.pojos.PlayListSongsEntity;
import com.galvanize.playlist.service.PlaylistService.pojos.PlaylistDto;
import com.galvanize.playlist.service.PlaylistService.pojos.PlaylistEntity;
import com.galvanize.playlist.service.PlaylistService.pojos.PlaylistSongsDTO;
import com.galvanize.playlist.service.PlaylistService.repository.PlaylistRepository;
import com.galvanize.playlist.service.PlaylistService.repository.PlaylistSongsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private PlaylistSongsRepository playlistSongsRepository;

    public void create(PlaylistDto playlistDto) throws PlaylistExistException {
        PlaylistEntity entity = playlistRepository.findByName(playlistDto.getName());
        if (entity != null) {
            throw new PlaylistExistException();
        } else {
            playlistRepository.save(new PlaylistEntity(playlistDto.getName()));
        }
    }

    public List<PlaylistDto> fetchAll() {
        List<PlaylistEntity> entities = playlistRepository.findAll();
        return playlistRepository.findAll()
                .stream()
                .map(playlistEntity -> new PlaylistDto(playlistEntity.getName()))
                .collect(Collectors.toList());
    }

    public void addSong(String name, PlaylistSongsDTO songDTO) {
        PlaylistEntity entity = playlistRepository.findByName(name);
        PlayListSongsEntity songsEntity = new PlayListSongsEntity(songDTO.getName());
        songsEntity.setPlaylistEntity(entity);
        playlistSongsRepository.save(songsEntity);

    }

    public List<PlaylistSongsDTO> findSongs(String name) {
        PlaylistEntity entity = playlistRepository.findByName(name);
        return playlistSongsRepository.findByPlaylistEntity(entity).stream()
                .map(playlistEntity -> new PlaylistSongsDTO(playlistEntity.getName()))
                .collect(Collectors.toList());
    }
}
