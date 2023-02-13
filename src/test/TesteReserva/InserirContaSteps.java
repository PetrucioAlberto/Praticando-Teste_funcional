package Steps;

import Runner.RunCucumbertestt;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InserirContaSteps  {
    private WebDriver drive = new ChromeDriver();
    @Dado("^que estou acessando a aplicação$")
    public void queEstouAcessandoAAplicação() {
        drive.get("http://seubarriga.wcaquino.me/login");

    }

    @Quando("^informo o usuário \"([^\"]*)\"$")
    public void informoOUsuário(String arg1) {
        drive.findElement(By.id("email")).sendKeys(arg1);
    }

    @Quando("^a senha \"([^\"]*)\"$")
    public void aSenha(String arg1) {
        drive.findElement(By.id("senha")).sendKeys(arg1);
    }

    @Quando("^seleciono entrar$")
    public void selecionoEntrar() {
        drive.findElement(By.cssSelector(".btn.btn-primary")).click();
    }

    @Então("^visualizo a página inicial$")
    public void visualizoAPáginaInicial() {
        String texto = drive.findElement(By.cssSelector(".alert.alert-success")).getText();
        Assert.assertEquals("Bem vindo, petrucio!",texto);
    }

    @Quando("^seleciono Contas$")
    public void selecionoContas() {
        drive.findElement(By.cssSelector(".dropdown-toggle")).click();
    }

    @Quando("^seleciono Adicionar$")
    public void selecionoAdicionar() {
        drive.findElement(By.linkText("Adicionar")).click();
    }

    @Quando("^informo a conta \"([^\"]*)\"$")
    public void informoAConta(String arg1) {
        drive.findElement(By.cssSelector(".form-control")).sendKeys(arg1);
    }

    @Quando("^seleciono Salvar$")
    public void selecionoSalvar() {
        drive.findElement(By.cssSelector(".btn.btn-primary")).click();
    }
    @Então("^a conta é inserida com sucesso$")
    public void aContaÉInseridaComSucesso() {
        String texto = drive.findElement(By.cssSelector(".alert.alert-success")).getText();
        Assert.assertEquals("Conta adicionada com sucesso!",texto);
    }
    @Então("^sou notificar que o nome da conta é obrigatório$")
    public void souNotificarQueONomeDaContaÉObrigatório() {
        String texto = drive.findElement(By.cssSelector(".alert.alert-danger")).getText();
        Assert.assertEquals("Informe o nome da conta",texto);
    }
    @Então("^sou notificado que já existe uma conta com esse nome$")
    public void souNotificadoQueJáExisteUmaContaComEsseNome() {
        String texto = drive.findElement(By.cssSelector(".alert.alert-danger")).getText();
        Assert.assertEquals("Já existe uma conta com esse nome!",texto);
    }
    @After
    public void Inicializar(){
        System.out.println("Começando aqui");
    }

    @After
    public void finalizar(){
        drive.quit();
    }



}
