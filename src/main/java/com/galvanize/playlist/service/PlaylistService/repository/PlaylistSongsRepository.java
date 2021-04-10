package com.galvanize.playlist.service.PlaylistService.repository;

import com.galvanize.playlist.service.PlaylistService.pojos.PlayListSongsEntity;
import com.galvanize.playlist.service.PlaylistService.pojos.PlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistSongsRepository extends JpaRepository<PlayListSongsEntity,Long> {

    List<PlayListSongsEntity> findByPlaylistEntity(PlaylistEntity entity);
}
