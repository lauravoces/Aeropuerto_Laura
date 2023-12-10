package api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;

import org.json.JSONObject;
import utils.Temperaturas;

public class AEMET_API {
//Me rindo, llevo dias intentando que funcione la api, pero no consigo leer bien el JSON, en teoria, EN TEORIA, campos deberia ser el primero y me lo da como not found
    //lo intente para OVD 33016. tienes las respuestas de la consulta en otros archivos, junto a los csv.
    //seguramente esto se debe a que me he olvidado de algo, posiblemente algo muy tonto, pero no se que estoy haciendo mal, al principio el codigo era simple y en teoria tenia sentido
    //pero este monstruo no hace nada.
    
    //KEY y URL de consulta proporcionada en opendata
    private static final String API_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsYS52by5ncmFAZ21haWwuY29tIiwianRpIjoiNDAxZmM1MDgtYzRiNi00OTQ2LWFkNGYtMjlhNDllNjBlZTQ3IiwiaXNzIjoiQUVNRVQiLCJpYXQiOjE3MDE5OTMyMDMsInVzZXJJZCI6IjQwMWZjNTA4LWM0YjYtNDk0Ni1hZDRmLTI5YTQ5ZTYwZWU0NyIsInJvbGUiOiIifQ.1i5plmEU3B44LqUSyp5gYyrh-mArWRQtMXofclP4Ej0";
    private static final String URL_AEMET = "https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/diaria/{municipio}";

    
    //metodo que en teoria daria las temperaturas max y minimas a un obj temperatura, no lo hace
    public static Temperaturas getTemperaturas(String aeropuertoCodigo, String codigoMunicipio) {
        String temperaturaMaxima = null;
        String temperaturaMinima = null;
        try {
            String apiUrl = URL_AEMET.replace("{municipio}", codigoMunicipio);
            HttpResponse<JsonNode> jsonResponse = Unirest.get(apiUrl)
                    .header("accept", "application/json")
                    .queryString("api_key", API_KEY)
                    .asJson();

            int statusCode = jsonResponse.getStatus();
            if (statusCode == 200) {
                JSONArray jsonArray = jsonResponse.getBody().getArray();

               //porque la iteracion sobre el array falla.... ??? misterios de la vida, lo intente con muchas combinaciones ya.
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject item = jsonArray.getJSONObject(i);

                   
                    JSONArray camposArray = item.getJSONArray("campos");
                    for (int j = 0; j < camposArray.length(); j++) {
                        JSONObject camposItem = camposArray.getJSONObject(j);

                        
                        JSONArray prediccionArray = camposItem.getJSONArray("prediccion");
                        for (int k = 0; k < prediccionArray.length(); k++) {
                            JSONObject prediccionItem = prediccionArray.getJSONObject(k);

                          
                            JSONArray diaArray = prediccionItem.getJSONArray("dia");
                            for (int l = 0; l < diaArray.length(); l++) {
                                JSONObject diaItem = diaArray.getJSONObject(l);

                             
                                JSONArray temperaturaArray = diaItem.getJSONArray("temperatura");
                                for (int m = 0; m < temperaturaArray.length(); m++) {
                                    JSONObject temperaturaItem = temperaturaArray.getJSONObject(m);

                                  
                                    temperaturaMaxima = temperaturaItem.getString("maxima");
                                    temperaturaMinima = temperaturaItem.getString("minima");

                                   
                                    JSONArray datoArray = temperaturaItem.getJSONArray("dato");
                                    for (int n = 0; n < datoArray.length(); n++) {
                                        JSONObject datoItem = datoArray.getJSONObject(n);

                                    
                                        String horaDato = datoItem.getString("hora");
                                        String valorDato = datoItem.getString("value");

                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                System.out.println("Error en la solicitud: " + statusCode);
                return null;
            }
            //si esto devolviera algo se lo daria al constructor y entonces el elemento de UI que cree serviría de algo, pero no.
            Temperaturas temperaturas = new Temperaturas(aeropuertoCodigo, codigoMunicipio, temperaturaMaxima, temperaturaMinima);
            return temperaturas;
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnirestException ex) {
            Logger.getLogger(AEMET_API.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
