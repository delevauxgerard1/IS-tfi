package edu.spring.istfi.controller;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Value("${decidir.api.url}")
    private String DECIDIR_API_URL;

    @Value("${decidir.api.key}")
    private String DECIDIR_API_KEY;

    @PostMapping("/processCard")
    public ResponseEntity<String> processCard(@RequestBody Map<String, Object> frontendData) {
        // Descomponer el JSON recibido desde el front-end
        String cardNumber = (String) frontendData.get("card_number");
        String cardExpirationMonth = (String) frontendData.get("card_expiration_month");
        String cardExpirationYear = (String) frontendData.get("card_expiration_year");
        String securityCode = (String) frontendData.get("security_code");
        String cardHolderName = (String) frontendData.get("card_holder_name");
        Map<String, String> cardHolderIdentification = (Map<String, String>) frontendData.get("card_holder_identification");
        String identificationType = cardHolderIdentification.get("type");
        String identificationNumber = cardHolderIdentification.get("number");

        // Construir el JSON para la API externa
        String apiRequestBody = "{" +
                "\"card_number\":\"" + cardNumber + "\"," +
                "\"card_expiration_month\":\"" + cardExpirationMonth + "\"," +
                "\"card_expiration_year\":\"" + cardExpirationYear + "\"," +
                "\"security_code\":\"" + securityCode + "\"," +
                "\"card_holder_name\":\"" + cardHolderName + "\"," +
                "\"card_holder_identification\":{" +
                "\"type\":\"" + identificationType + "\"," +
                "\"number\":\"" + identificationNumber + "\"" +
                "}" +
                "}";

        // Construir el encabezado con la API Key
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "apikey " + DECIDIR_API_KEY);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Construir la entidad HTTP con los datos y el encabezado
        HttpEntity<String> requestEntity = new HttpEntity<>(apiRequestBody, headers);

        // Realizar la petición a la API externa
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                DECIDIR_API_URL,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        // Devolver la respuesta de la API externa al front-end
        return ResponseEntity.status(responseEntity.getStatusCode()).body(responseEntity.getBody());
    }

}
