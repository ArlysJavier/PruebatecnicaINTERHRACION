package com.Java.pruebaTecnica;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ComunicacionController {
    //Creamos un objeto tipo map para guardar los mensajes por dispositivos ID
    private Map<String, String[]> messagesMap = new HashMap<>();

    //manejamos la solicitud POST en la siguiente url: /message_split/{device_id}
    @PostMapping("/message_split/{device_id}")
    public ResponseEntity<OutputMessage> getMessageSplit(@PathVariable("device_id") String deviceId, @RequestBody DispositivoMSM request) {
        //Obtenemos el mensaje enviados en la solicitud.
        String[] message = request.getMessage();
        //almacenamos el mensaje en la variable tipo map ustilizando el identificador del dispositivo como calve
        messagesMap.put(deviceId, message);
        //combinamos el mensaje en una sola cadena
        String combinedMessage = String.join(" ", message);
        //devolvemos la respuesta con el mensaje generado y el codigo 200 cono estado OK
        return ResponseEntity.ok(new OutputMessage(combinedMessage));
    }

    //esta funcion maneja las solicitudes GET en /message_split/{device_id}
    @GetMapping("/message_split/{device_id}")
    public ResponseEntity<?> getMessageSplit(@PathVariable("device_id") String deviceId) {
       // Buscamos el mensaje correspondiente al ID del dispositivo enviado en en la solicitud
        String[] message = messagesMap.get(deviceId);
        if (message != null) {
            //si encontramos el mensaje lo combinamos en una sola cadena y devolvemos una respuesta 200 con el mensaje
            String combinedMessage = String.join(" ", message);
            return ResponseEntity.ok(new OutputMessage(combinedMessage));
        } else {
            // si no encuentra el msm devolvemos una respuesta con el codigo 400 Not found y un msm de error
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay suficiente información para el dispositivo con ID: " + deviceId);
        }
    }

    // este metotodo intercepta la solicitud post en (/message) y procesa los mensajes reccibidos para construir en msm completo
    @PostMapping("/message")
    public OutputMessage interceeptor(@RequestBody InputMessage request){
        //Obtenemmos las lista de dispositivos y sus mensajes
        List<DispositivoMSM> devices = request.getDevices();
        // obtenemos los mensajes de cada dispositivo
        List<String[]> messages = devices.stream().map(DispositivoMSM::getMessage).toList();
        //encontramos la longitud maxima entre todos los mensajes
        int maxLength = messages.stream().mapToInt(arr -> arr.length).max().orElse(0);

        //creamos un arreglo de string con la longitus igual a la maxima encontrada
        String[] finalMessage = new String[maxLength];
        // cleamos un ciclo for para iterar cada posicion en el nuevo arreglo
        for (int i = 0; i < maxLength; i++) {
            //recorremos todos los msm recibidos
            for (String[] message : messages) {
                //si la posicion no esta vacia en alguno de los msm atualizamos el nuevo arreglo en esa posicion con la palabra encontrada
                if (i < message.length && !message[i].isEmpty()) {
                    finalMessage[i] = message[i];
                }
            }
        }
        //unimos todas las palabras del nuevo arreglo con un espacio en blanco para formar la oracion completa
        String combinedMessage = String.join(" ", finalMessage);
        //devolvemos el mensaje final en el formato solicitado como un objeto de la clase OutputMessage
        return new OutputMessage(combinedMessage);

    }
}
