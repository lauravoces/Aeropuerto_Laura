/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import utils.Temperaturas;

/**
 *
 * @author laura
 */
public class AEMET_API {
    private static final String API_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsYS52by5ncmFAZ21haWwuY29tIiwianRpIjoiNDAxZmM1MDgtYzRiNi00OTQ2LWFkNGYtMjlhNDllNjBlZTQ3IiwiaXNzIjoiQUVNRVQiLCJpYXQiOjE3MDE5OTMyMDMsInVzZXJJZCI6IjQwMWZjNTA4LWM0YjYtNDk0Ni1hZDRmLTI5YTQ5ZTYwZWU0NyIsInJvbGUiOiIifQ.1i5plmEU3B44LqUSyp5gYyrh-mArWRQtMXofclP4Ej0";
    private static final String URL_AEMET = "https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/{municipio}";

public static Temperaturas getTemperaturas(String aeropCodigo, String codigoMunicipio) {
        try {
            String apiUrl = URL_AEMET.replace("{municipio}", codigoMunicipio);
            HttpResponse<JsonNode> jsonResponse = Unirest.get(apiUrl)
                    .header("accept", "application/json")
                    .queryString("api_key", API_KEY)
                    .asJson();

            int statusCode = jsonResponse.getStatus();
            if (statusCode == 200) {
                JSONObject temperaturaObj = jsonResponse.getBody().getObject().getJSONObject("temperatura");

                if (temperaturaObj != null && temperaturaObj.has("minima") && temperaturaObj.has("maxima")) {
                    double minTemperature = temperaturaObj.getDouble("minima");
                    double maxTemperature = temperaturaObj.getDouble("maxima");
                    return new Temperaturas(aeropCodigo, codigoMunicipio, minTemperature, maxTemperature);
                } else {
                    System.out.println("La respuesta no contiene información de temperatura.");
                    return null;
                }
            } else {
                System.out.println("Error en la solicitud HTTP. Código de estado: " + statusCode);
                return null;
            }
        } catch (UnirestException e) {
            System.out.println("Error durante la solicitud HTTP: " + e.getMessage());
            return null;
        }
    }
}
