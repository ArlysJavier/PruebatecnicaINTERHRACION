# PruebatecnicaINTERHRACION
Prueba técnica para el cargo desarrollador JAVA.

Se crea un proyecto con sprigboot utilizando la herramienta spring initializr y se agrega la dependencia sprig web
para el manesjo de los servicios REST.

acontinuecion se describe cada uno lo los procesos del la API como respuesta a los servicios solicitados

1.) Se crea el programa con la siguiente extructura para integrar la funcionalidades solicitadas 

![image](https://github.com/ArlysJavier/PruebatecnicaINTERHRACION/assets/114090836/41978b41-241e-4d69-98e5-0bd4a13d11a4)

Se crean las clases OutputMessage, inputMessage y DispositivoMSM para manejar las estrutura de los mensajes en sol servicios pots y get de entradas y salidas de la API.

para probar la intercepcion de los mensajes y la costrucion de los mismo ustilizamos la herramientas postman para interactuar co el controlador de la API.

![image](https://github.com/ArlysJavier/PruebatecnicaINTERHRACION/assets/114090836/e8521db6-24e2-4ce1-a229-f311925f8c8e)

ahora pasaremos los mensajes interceptados por los dipocitivos 1 , 2 y 3 en el formato JSON solicitado para su respectiva intercepcion y procesamiento para obtener el mensaje completo.

![image](https://github.com/ArlysJavier/PruebatecnicaINTERHRACION/assets/114090836/26eecfda-4ed5-44ec-9a02-77f784b2141e)

se realiza la intercepcion de los mensaje y se envia la respuesta que corresponde a la combinacion de los msm de los 3 dispocitivos.

ahora pabramos el nuevo servicio message_split/{Device_id} que recibira doferentes solicitudes post y podra consultar solicitudes get de los msm por dispositivos, enviamos solucitudes post desde cada dispositivos.

![image](https://github.com/ArlysJavier/PruebatecnicaINTERHRACION/assets/114090836/8f319874-788b-42a9-892f-0dea222c6acd)

este controlador el maneja tanto las solicitudes POST como GET a la ruta /message_split/{device_id} Cuando se realiza una solicitud POST, el mensaje se almacena utilizando el ID del dispositivo como clave, Cuando se realiza una solicitud GET, se busca el mensaje correspondiente utilizando el ID del dispositivo. Si se encuentra el mensaje, se devuelve como una respuesta con el código 200 OK. Si no se encuentra el mensaje, se devuelve una respuesta con el código 404 NOT FOUND.

![image](https://github.com/ArlysJavier/PruebatecnicaINTERHRACION/assets/114090836/0c15685a-58e4-4e87-8656-111f71adc819)

ahora consultaremos por get el mesaje del dispositivo 1 reciente mente almecenado.

![image](https://github.com/ArlysJavier/PruebatecnicaINTERHRACION/assets/114090836/3f2094de-978f-4156-9a82-b395e40cb0cc)

ahora consultaremos lo msm del dispositivo 3, el cual aun no ha interceptado ningun mensaje.

![image](https://github.com/ArlysJavier/PruebatecnicaINTERHRACION/assets/114090836/208fadf6-dfb5-4a84-83df-9e644671aac9)

el cual me responde que no fue encontrado y un estado 404 ya que el dispocitivo 3 no ha intercepatdo ningun msm aun.

de esta forma probamos los casos slicitados y podemos probar nuevos mensajes.

saludos.

################################# GRACIAS ###################################



