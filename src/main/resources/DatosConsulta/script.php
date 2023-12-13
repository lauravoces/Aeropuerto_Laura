<?php

// URL y clave API
$url = 'https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/33016';
$apiKey = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsYS52by5ncmFAZ21haWwuY29tIiwianRpIjoiNDAxZmM1MDgtYzRiNi00OTQ2-LWFkNGYtMjlhNDllNjBlZTQ3IiwiaXNzIjoiQUVNRVQiLCJpYXQiOjE3MDE5OTMyMDMsInVzZXJJZCI6IjQwMWZjNTA4LWM0YjYtNDk0Ni1hZDRmLTI5YTQ5ZTYwZWU0NyIsInJvbGUiOiIifQ.1i5plmEU3B44LqUSyp5gYyrh-mArWRQtMXofclP4Ej0';

// Encabezados
$headers = [
    'accept' => 'application/json',
    'api_key' => $apiKey,
];

// Configuración de la solicitud
$options = [
    'http' => [
        'header' => "Content-type: application/x-www-form-urlencoded\r\n",
        'method' => 'GET',
    ],
];

// Contexto de flujo con configuración
$context = stream_context_create($options);

// Realizar la solicitud
$response = file_get_contents($url, false, $context);

// Decodificar JSON
$data = json_decode($response, true);

// Imprimir respuesta (adaptado para coherencia en la ejecución desde Java)
echo json_encode($data);

?>
