package com.galvanize.playlist.service.PlaylistService.IT;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
//@Transactional
//@AutoConfigureRestDocs
public class PlaylistServiceIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    /*    When a playlist is created with a name
        Then a confirmation is returned that it was successful.
        And the playlist is empty.*/
    @Test
    public void createPlaylist_SuccesMessage() throws Exception {

        String playlistDTO = "{\"name\":\"myNewPlaylist\", \"playlist\":[]}";
        mockMvc.perform(post("/playlist")
                .content(playlistDTO)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
//                .andDo(document("AddGuests"));

    }

}
