package com.migudel.staycore.api.hotels.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // Devuelve un 404 cuando se lanza la excepción
public class HotelNotFoundException extends RuntimeException {
    public HotelNotFoundException(int id) {
        super("Hotel not found with id: " + id);
    }
}
