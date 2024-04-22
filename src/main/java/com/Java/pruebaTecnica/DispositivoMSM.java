package com.Java.pruebaTecnica;

import com.fasterxml.jackson.annotation.JsonProperty;

//Esta clase representa el formato del mensaje en la solicitud get
public class DispositivoMSM {
    @JsonProperty("id")
    private String id;
    @JsonProperty("message")
    private String[] message;

    public String getId() {
        return id;
    }

    public String[] getMessage() {
        return message;
    }

}
