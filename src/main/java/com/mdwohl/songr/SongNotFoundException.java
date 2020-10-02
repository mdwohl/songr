package com.mdwohl.songr;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Song not found in database.")
public class SongNotFoundException extends RuntimeException {
}
