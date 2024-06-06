package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Page {
    private WebDriver driver;
    private WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void acessarMenuAjuda() {
        WebElement menuAjuda = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Ajuda']")));
        menuAjuda.click();
    }

    public void clicarCentralAjuda() {
        WebElement centralAjuda = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Central de ajuda']")));
        centralAjuda.click();
    }

    public void buscarBoleto(String keyword) {
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("faq-search-input")));
        searchBox.sendKeys(keyword);
        searchBox.submit();
    }

    public void selecionarOpcao(String opcao) {
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(opcao)));
        option.click();
    }

    public boolean verificarModalAbertaComMensagem(String expectedText) {
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Eu concluí a negociação, de que forma receberei meu boleto?']")));
        return modal.isDisplayed() && modal.getText().contains(expectedText);
    }
}
