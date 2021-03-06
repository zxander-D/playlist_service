package com.galvanize.playlist.service.PlaylistService.pojos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class PlaylistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany
    private List<PlayListSongsEntity> songs;

    public PlaylistEntity(String name) {
        this.name = name;
    }
}
