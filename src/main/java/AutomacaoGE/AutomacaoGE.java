package AutomacaoGE;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomacaoGE {

    private WebDriver driver;
    private WebDriverWait wait;

    public void executarTeste() {

        try {
            iniciarNavegador();
            abrirSite();
            rolarPagina();
            validarTitulo();
            validarURL();
            verificarPalavra();
            contarLinks();
            contarImagens();
            listarTitulos();
            verificarBotao();
        }

        catch (TimeoutException e) {
            System.out.println("O tempo de carregamento estabelecido foi excedido");
        }

        catch (NoSuchElementException e) {
            System.out.println("Palavra-chave não encontada");
        }

        catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }

        finally {
            fecharNavegador();
        }

    }

    private void iniciarNavegador() {

        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\BrowserDrivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    private void abrirSite() {

        driver.get("https://ge.globo.com/futebol/copa-do-mundo/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
        System.out.println("Site carregado com sucesso.\n");

    }

    private void validarTitulo() {

        System.out.println("Título: COPA DO MUNDO FIFA");
        System.out.println(driver.getTitle());
        System.out.println("Título validado.");

    }

    private void validarURL() {

        if (Objects.requireNonNull(driver.getCurrentUrl()).contains("copa-do-mundo")) {
            System.out.println("Esta URL é válida.\n");
        } else {
            System.out.println("Esta URL é inválida.\n");
        }

    }

    private void verificarPalavra() {

        String texto = driver.findElement(By.tagName("body")).getText();

        if (texto.contains("Brasil")) {
            System.out.println("Palavra \"" + "Brasil" + "\" encontrada.\n");
        } else {
            System.out.println("Palavra não encontrada.\n");
        }

    }

    private void contarLinks() {

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Quantidade de links: " + links.size());

    }

    private void contarImagens() {

        List<WebElement> imagens = driver.findElements(By.tagName("img"));
        System.out.println("Quantidade de imagens: " + imagens.size());

    }

    private void listarTitulos() {

        List<WebElement> titulos = driver.findElements(By.tagName("h2"));
        System.out.println("===== TÍTULOS =====");

        for (WebElement titulo : titulos) {

            if (!titulo.getText().isBlank()) {
                System.out.println(titulo.getText());
                System.out.println("--------------------------------------------------------");
            }
        }

        System.out.println();

    }

    private void verificarBotao() {

        List<WebElement> botoes = driver.findElements(By.tagName("button"));
        System.out.println("Botões encontrados: " + botoes.size());
        System.out.println();

    }

    private void rolarPagina() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        System.out.println("Scroll pela página realizado.\n");

    }

    private void fecharNavegador() {

        if (driver != null) {
            driver.quit();
            System.out.println("O navegador foi encerrado.\n");
        }

    }

}