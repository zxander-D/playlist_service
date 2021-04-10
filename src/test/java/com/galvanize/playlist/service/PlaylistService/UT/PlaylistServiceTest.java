package com.galvanize.playlist.service.PlaylistService.UT;

import com.galvanize.playlist.service.PlaylistService.pojos.PlaylistDto;
import com.galvanize.playlist.service.PlaylistService.pojos.PlaylistEntity;
import com.galvanize.playlist.service.PlaylistService.repository.PlaylistRepository;
import com.galvanize.playlist.service.PlaylistService.service.PlaylistService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class PlaylistServiceTest {

    @Mock
    PlaylistRepository repository;

    @InjectMocks
    PlaylistService subject;
    @Test
    void createPlaylistTest() throws Exception {
        PlaylistDto playlistDto = new PlaylistDto("myPlaylist");
        subject.create(playlistDto);
        verify(repository).save(
                new PlaylistEntity("myPlaylist")
        );
    }

}
