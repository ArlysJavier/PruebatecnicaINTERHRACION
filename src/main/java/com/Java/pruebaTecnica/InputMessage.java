package com.Java.pruebaTecnica;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

//Esta clase representa el formato del mensaje en la solicitud post
public class InputMessage {
    @JsonProperty("devices")
    private List<DispositivoMSM> devices;

    public List<DispositivoMSM> getDevices() {
        return devices;
    }

}
