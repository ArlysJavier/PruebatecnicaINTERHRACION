PruebatecnicaINTERHRACION
Prueba técnica para el cargo desarrollador JAVA.

Se crea un proyecto con sprigboot utilizando la herramienta spring initializr y se agrega la dependencia sprig web para el manesjo de los servicios REST.

acontinuecion se describe cada uno lo los procesos del la API como respuesta a los servicios solicitados

1.) Se crea el programa con la siguiente extructura para integrar la funcionalidades solicitadas

![1](https://github.com/ArlysJavier/PruebatecnicaINTERHRACION/assets/114090836/c25f662e-dd0d-45e4-a706-fb6d37ef6cb6)


Se crean las clases OutputMessage, inputMessage y DispositivoMSM para manejar las estrutura de los mensajes en sol servicios pots y get de entradas y salidas de la API.

para probar la intercepcion de los mensajes y la costrucion de los mismo ustilizamos la herramientas postman para interactuar co el controlador de la API.

![2](https://github.com/ArlysJavier/PruebatecnicaINTERHRACION/assets/114090836/0e1a50ca-3c58-486c-b7b7-c9acbf97bf87)

ahora pasaremos los mensajes interceptados por los dipocitivos 1 , 2 y 3 en el formato JSON solicitado para su respectiva intercepcion y procesamiento para obtener el mensaje completo.

![3](https://github.com/ArlysJavier/PruebatecnicaINTERHRACION/assets/114090836/041940ce-fdd7-440a-bd5c-261f280d4f3c)

se realiza la intercepcion de los mensaje y se envia la respuesta que corresponde a la combinacion de los msm de los 3 dispocitivos.

ahora pabramos el nuevo servicio message_split/{Device_id} que recibira doferentes solicitudes post y podra consultar solicitudes get de los msm por dispositivos, enviamos solucitudes post desde cada dispositivos.

![4](https://github.com/ArlysJavier/PruebatecnicaINTERHRACION/assets/114090836/20660f4b-0e8b-47d2-b089-11c0f632b83f)

este controlador el maneja tanto las solicitudes POST como GET a la ruta /message_split/{device_id} Cuando se realiza una solicitud POST, el mensaje se almacena utilizando el ID del dispositivo como clave, Cuando se realiza una solicitud GET, se busca el mensaje correspondiente utilizando el ID del dispositivo. Si se encuentra el mensaje, se devuelve como una respuesta con el código 200 OK. Si no se encuentra el mensaje, se devuelve una respuesta con el código 404 NOT FOUND.

![5](https://github.com/ArlysJavier/PruebatecnicaINTERHRACION/assets/114090836/b3357678-5444-47c0-927b-8ecc2ce61c24)

ahora consultaremos por get el mesaje del dispositivo 1 reciente mente almecenado.

![6](https://github.com/ArlysJavier/PruebatecnicaINTERHRACION/assets/114090836/69a199ff-4def-4762-a901-894a3d5dbd77)

ahora consultaremos lo msm del dispositivo 3, el cual aun no ha interceptado ningun mensaje.

![7](https://github.com/ArlysJavier/PruebatecnicaINTERHRACION/assets/114090836/b65447c3-8fc2-4349-a7d0-ab28e776a82a)

el cual me responde que no fue encontrado y un estado 404 ya que el dispocitivo 3 no ha intercepatdo ningun msm aun.

de esta forma probamos los casos slicitados y podemos probar nuevos mensajes.

saludos.

################################# GRACIAS ###################################
