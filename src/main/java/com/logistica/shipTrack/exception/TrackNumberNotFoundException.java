package com.logistica.shipTrack.exception;

public class TrackNumberNotFoundException extends RuntimeException {

    public TrackNumberNotFoundException(String mensaje) {
        super(mensaje);
    }

}
