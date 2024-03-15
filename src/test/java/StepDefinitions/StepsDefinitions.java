package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepsDefinitions {

    @Given("existen artículos en la base de datos con descripción {string}")
    public void existen_artículos_en_la_base_de_datos_con_descripción(String descripcion) {
    }

    @When("se hace una petición al endpoint con la descripción {string}")
    public void se_hace_una_petición_al_endpoint_con_la_descripción(String descripcion) {
    }

    @Then("se devuelve en el body de la respuesta los artículos que coiciden con la descripción {string}")
    public void se_devuelve_en_el_body_de_la_respuesta_los_artículos_que_coinciden_con_la_descripción(String descripcion) {
    }
}
