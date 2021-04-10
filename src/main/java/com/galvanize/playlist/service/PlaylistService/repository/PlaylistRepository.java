package com.galvanize.playlist.service.PlaylistService.repository;

import com.galvanize.playlist.service.PlaylistService.pojos.PlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<PlaylistEntity, Long> {
}
