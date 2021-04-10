package com.galvanize.playlist.service.PlaylistService.pojos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class PlayListSongsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private PlaylistEntity playlistEntity;

    public PlayListSongsEntity(String name) {
        this.name = name;
    }
}
