package com.galvanize.playlist.service.PlaylistService;


import com.galvanize.playlist.service.PlaylistService.Exception.PlaylistExistException;
import com.galvanize.playlist.service.PlaylistService.Exception.PlaylistNoNameException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(PlaylistExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody String handlePlaylistExistException() {

        return "{\"message\": \"Playlist Exists\"}";
    }

    @ExceptionHandler(PlaylistNoNameException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody String handlePlaylistNoNameException() {

        return "{\"message\": \"Name cannot be empty\"}";
    }

}
