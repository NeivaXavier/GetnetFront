package Steps;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import Utils.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Page;

public class BuscarBoletoSteps {

    private WebDriver driver;
    private Page page;

    @Before
    public void setup() {
        driver = WebDriverFactory.createWebDriver();
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Given("que eu acesso o site {string}")
    public void que_eu_acesso_o_site(String url) {
        driver.get(url);
        page = new Page(driver);
    }

    @When("eu clico em {string} no menu")
    public void eu_clico_em_no_menu(String menuOption) {
        page.acessarMenuAjuda();
    }

    @And("eu clico em {string}")
    public void eu_clico_em(String subMenuOption) {
        page.clicarCentralAjuda();
    }

    @And("eu busco por {string}")
    public void eu_busco_por(String keyword) {
        page.buscarBoleto(keyword);
    }

    @And("eu seleciono a opção {string}")
    public void eu_seleciono_a_opcao(String optionText) {
        page.selecionarOpcao(optionText);
    }

    @Then("eu verifico se a modal foi aberta com a mensagem explicativa")
    public void eu_verifico_se_a_modal_foi_aberta_com_a_mensagem_explicativa() {
        String expectedText = "Eu concluí a negociação, de que forma receberei meu boleto?";
        assertTrue(page.verificarModalAbertaComMensagem(expectedText));
        driver.quit();
    }
    }

