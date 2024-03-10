package edu.spring.istfi.controller;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.ILoggerFactory;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/solicitarToken")
    public ResponseEntity<String> dummyEndpoint(@RequestBody String requestBody) {
        try {
            // Convertir el cuerpo de la solicitud a un objeto JsonNode
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(requestBody);

            // Extraer los datos necesarios del JSON
            String cardNumber = jsonNode.get("datosTarjeta").get("numero").asText();
            String expirationMonth = jsonNode.get("datosTarjeta").get("vencimiento").get("mes").asText();
            String expirationYear = jsonNode.get("datosTarjeta").get("vencimiento").get("año").asText();
             expirationYear = expirationYear.length() >= 2
                    ? expirationYear.substring(expirationYear.length() - 2)
                    : expirationYear;
            String securityCode = jsonNode.get("datosTarjeta").get("cvv").asText();
            String cardHolderName = jsonNode.get("datosCliente").get("nombreCliente").asText();
            JsonNode cardHolderIdentificationNode = jsonNode.get("card_holder_identification");
            String identificationType = "dni";
            String identificationNumber = jsonNode.get("datosTarjeta").get("dni").asText();
            // Construir un nuevo JSON con los datos necesarios
            String nuevoJson = "{"
                    + "\"card_number\": \"" + cardNumber + "\", "
                    + "\"card_expiration_month\": \"" + expirationMonth + "\", "
                    + "\"card_expiration_year\": \"" + expirationYear + "\", "
                    + "\"security_code\": \"" + securityCode + "\", "
                    + "\"card_holder_name\": \"" + cardHolderName + "\", "
                    + "\"card_holder_identification\": {"
                    + "  \"type\": \"" + identificationType + "\", "
                    + "  \"number\": \"" + identificationNumber + "\""
                    + "}"
                    + "}";

            // Construir el encabezado para la API externa
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("apikey", "b192e4cb99564b84bf5db5550112adea");

            // Construir la entidad HTTP con los datos y el encabezado
            HttpEntity<String> externalApiRequestEntity = new HttpEntity<>(nuevoJson, headers);

            // URL de la API externa
            String externalApiUrl = "https://developers.decidir.com/api/v2/tokens";

            // Realizar la petición a la API externa
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> externalApiResponseEntity = restTemplate.postForEntity(
                    externalApiUrl,
                    externalApiRequestEntity,
                    String.class
            );

            // Devolver la respuesta de la API externa al frontend junto con la respuesta original
            String responseBody = "Respuesta de la API externa: " + externalApiResponseEntity.getBody();
            return ResponseEntity.ok(responseBody);

        } catch (Exception e) {
            e.printStackTrace(); // Manejar las excepciones según tus necesidades
            return ResponseEntity.status(500).body("Error al procesar la solicitud");
        }
    }

}
