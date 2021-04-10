package com.galvanize.playlist.service.PlaylistService.UT;

import com.galvanize.playlist.service.PlaylistService.Exception.PlaylistExistException;
import com.galvanize.playlist.service.PlaylistService.pojos.PlaylistDto;
import com.galvanize.playlist.service.PlaylistService.pojos.PlaylistEntity;
import com.galvanize.playlist.service.PlaylistService.repository.PlaylistRepository;
import com.galvanize.playlist.service.PlaylistService.service.PlaylistService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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

    @Test
    void createDuplicatePlaylistTest() throws Exception {

        when(repository.findByName("myPlaylist")).thenReturn(
                new PlaylistEntity("myPlaylist")
        );
        PlaylistDto playlistDto = new PlaylistDto("myPlaylist");

        assertThatThrownBy(() -> subject.create(playlistDto)).isInstanceOf(PlaylistExistException.class);

        verify(repository, never()).save(any());
    }

    @Test
    public void fetchAllTest() {
        PlaylistEntity entity1 = new PlaylistEntity("samplepl1");
        PlaylistEntity entity2 = new PlaylistEntity("samplepl2");
        when(repository.findAll()).thenReturn(
                List.of(
                       entity1,
                        entity2
                )
        );

        List<PlaylistDto> actual = subject.fetchAll();
        assertThat(actual).isEqualTo(
                List.of(
                        new PlaylistDto("samplepl1"),
                        new PlaylistDto("samplepl2")
                )
        );
    }

}
