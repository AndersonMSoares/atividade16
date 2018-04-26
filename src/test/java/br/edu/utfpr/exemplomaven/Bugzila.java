package br.edu.utfpr.exemplomaven;

import br.edu.utfpr.classes.*;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author renil
 */
public class Bugzila {

    private static String CHROMEDRIVER_LOCATION = "driver/chromedriver.exe";

    private static int scId = 0;

    WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_LOCATION);
    }
    @Before
    public void before() {
        ChromeOptions chromeOptions = new ChromeOptions();

        //chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=1200x600");
        chromeOptions.addArguments("start-maximized");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.redmine.org/");
    }

    @After
    public void after() {
        driver.close();
    }
    @Test
    public void loginValido() {
        Homepage homeP = new Homepage(driver);
        
        LoginPage loginP = homeP.getLogin();
        MainPage mainP = loginP.setLogin("papu")
                .setPassword("123asd")
                .addValid();
        assertEquals("Acessando como: papu", mainP.getUser());
    }
    @Test
    public void loginInvalido() {
        Homepage homeP = new Homepage(driver);
        
        LoginPage loginP = homeP.getLogin();
        MainPage mainP = loginP.setLogin("testeinvalido")
                .setPassword("123asd1")
                .addValid();
        assertEquals("Usuário ou senha inválido.", mainP.getErro());
    }
    @Test
    public void cadastrarConta(){
        Homepage homeP = new Homepage(driver);
        GerarStringAleatoria ga = new GerarStringAleatoria();
        String login = ga.getStringAleatoria();
        String email = ga.getStringAleatoria()+"@"+ga.getStringAleatoria()+".com";
        CadastrarPage cadP = homeP.getCadastro();
        MainPage mainP = cadP.setLogin(login)
                .setPassword("123asd")
                .setConfirma("123asd")
                .setNome("teste12")
                .setSobrenome("teste2")
                .setEmail(email) 
                .addValid();
        assertEquals("Acessando como: "+login, mainP.getUser());
    }
    @Test
    public void cadastrarUsuarioExistente(){
        Homepage homeP = new Homepage(driver);
        CadastrarPage cadP = homeP.getCadastro();
        MainPage mainP = cadP.setLogin("abcde")
                .setPassword("123asd")
                .setConfirma("123asd")
                .setNome("teste12")
                .setSobrenome("teste2")
                .setEmail("teste2142121241@hotmail.com")
                .addValid();
        assertEquals("Usuário não está disponível", mainP.getErroConta());
    }
    @Test
    public void cadastrarEmailExistente(){
        Homepage homeP = new Homepage(driver);
        CadastrarPage cadP = homeP.getCadastro();
        MainPage mainP = cadP.setLogin("abcdefg")
                .setPassword("123asd")
                .setConfirma("123asd")
                .setNome("teste12")
                .setSobrenome("teste2")
                .setEmail("teste0@hotmail.com")
                .addValid();
        assertEquals("E-mail não está disponível", mainP.getErroConta());
    }
    @Test
    public void cadastrarEmailInvalio(){
        Homepage homeP = new Homepage(driver);
        CadastrarPage cadP = homeP.getCadastro();
        MainPage mainP = cadP.setLogin("abcdeeokeopeqrer")
                .setPassword("123asd")
                .setConfirma("123asd")
                .setNome("teste12")
                .setSobrenome("teste2")
                .setEmail("214e21dwqrwqrwewq@wqedwqfqewwqqf.com") 
                .addValid();
        assertEquals("Email invalido", mainP.getErroConta());
    }    
}
