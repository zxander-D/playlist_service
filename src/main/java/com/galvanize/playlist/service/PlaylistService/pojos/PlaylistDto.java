package com.galvanize.playlist.service.PlaylistService.pojos;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistDto {
    String name;
    List<PlaylistDto> songs;

    public PlaylistDto(String name) {
        this.name = name;
    }
}
