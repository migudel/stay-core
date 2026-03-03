package com.migudel.staycore.api.bookings.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // Devuelve un 404 cuando se lanza la excepción
public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(int id) {
        super("Booking not found with id: " + id);
    }
}
