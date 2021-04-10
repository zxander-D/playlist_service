package com.galvanize.playlist.service.PlaylistService.pojos;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    public PlaylistEntity(String name) {
        this.name = name;
    }
}
