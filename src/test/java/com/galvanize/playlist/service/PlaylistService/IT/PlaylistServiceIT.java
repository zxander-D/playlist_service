package com.galvanize.playlist.service.PlaylistService.IT;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.playlist.service.PlaylistService.pojos.PlaylistDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@AutoConfigureRestDocs
@ActiveProfiles("local")
public class PlaylistServiceIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void createPlaylist_SuccessMessage() throws Exception {

        PlaylistDto playlistDTO = new PlaylistDto("myPlaylist");
        mockMvc.perform(post("/playlist")
                .content(objectMapper.writeValueAsString(playlistDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value("Successfully created"))
                .andDo(document("AddPlaylist"));
    }

    @Test
    public void createDuplicatePlaylist_UnSuccessMessage() throws Exception {

        PlaylistDto playlistDTO = new PlaylistDto("myPlaylist");
        mockMvc.perform(post("/playlist")
                .content(objectMapper.writeValueAsString(playlistDTO))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value("Successfully created"))
                .andDo(document("AddPlaylist"));

        PlaylistDto playlistDTO1 = new PlaylistDto("myPlaylist");
        mockMvc.perform(post("/playlist")
                .content(objectMapper.writeValueAsString(playlistDTO1))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.message").value("Playlist Exists"))
                .andDo(document("AddDuplicatePlaylist"));
    }

}
