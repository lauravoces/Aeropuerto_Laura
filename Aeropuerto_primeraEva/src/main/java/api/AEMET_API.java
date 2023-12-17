package api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;

import org.json.JSONObject;
import utils.Temperaturas;

/**
 *
 * @author laura
 */
public class AEMET_API implements Serializable{
    //Me rindo, llevo dias intentando que funcione la api, pero no consigo leer bien el JSON, en teoria, EN TEORIA, campos deberia ser el primero y me lo da como not found
    //lo intente para OVD 33016. tienes las respuestas de la consulta en otros archivos, junto a los csv.
    //seguramente esto se debe a que me he olvidado de algo, posiblemente algo muy tonto, pero no se que estoy haciendo mal, al principio el codigo era simple y en teoria tenia sentido
    //pero este monstruo no hace nada.

    //KEY y URL de consulta proporcionada en opendata
    private static final String API_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsYS52by5ncmFAZ21haWwuY29tIiwianRpIjoiNDAxZmM1MDgtYzRiNi00OTQ2LWFkNGYtMjlhNDllNjBlZTQ3IiwiaXNzIjoiQUVNRVQiLCJpYXQiOjE3MDE5OTMyMDMsInVzZXJJZCI6IjQwMWZjNTA4LWM0YjYtNDk0Ni1hZDRmLTI5YTQ5ZTYwZWU0NyIsInJvbGUiOiIifQ.1i5plmEU3B44LqUSyp5gYyrh-mArWRQtMXofclP4Ej0";
    private static final String URL_AEMET = "https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/{municipio}";

    //metodo que en teoria daria las temperaturas max y minimas a un obj temperatura, no lo hace
    /**
     * Consulta a la API de AEMET por medio de mi propioa API_KEY. No funciona
     * tal y como esta, pero la logica no deberia estar mal encaminada, creo
     *
     * @param aeropuertoCodigo
     * @param codigoMunicipio
     * @return
     */
    public static Temperaturas getTemperaturas(String aeropuertoCodigo, String codigoMunicipio) throws UnirestException {
        
            String apiUrl = URL_AEMET.replace("{municipio}", codigoMunicipio);
            HttpResponse<JsonNode> firstResponse = Unirest.get(apiUrl)
                    .header("accept", "application/json")
                    .queryString("api_key", API_KEY)
                    .asJson();
            String url = firstResponse.getBody().getObject().getString("datos");

            HttpResponse<JsonNode> jsonResponse = Unirest.get(url)
                    .header("accept", "application/json")
                    .asJson();

            int statusCode = jsonResponse.getStatus();
            if (statusCode == 200) {
                JSONArray jsonArray = jsonResponse.getBody().getArray();

                
                 JSONObject jn = jsonArray.getJSONObject(0);
                 JSONObject prediccion = jn.getJSONObject("prediccion");
                    JSONArray diaArray = prediccion.getJSONArray("dia");
                    JSONObject diaItem = diaArray.getJSONObject(0);
                        JSONObject temperatura = diaItem.getJSONObject("temperatura");
                       String tempMin=Integer.toString(temperatura.getInt("minima"));
                       String tempMax=Integer.toString(temperatura.getInt("maxima"));

Temperaturas temperaturas = new Temperaturas(aeropuertoCodigo, codigoMunicipio, tempMax, tempMin);
          

//porque la iteracion sobre el array falla.... ??? misterios de la vida, lo intente con muchas combinaciones ya.
              
          
            return temperaturas;
       
       
    }
        return null;
}}
