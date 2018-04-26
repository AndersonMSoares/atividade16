/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author MarkVII
 */
public class CadastrarPage extends BasePage{

    public CadastrarPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "user_login")
    WebElement user;
    @FindBy(id = "user_password")
    WebElement password;
    @FindBy(id = "user_password_confirmation")
    WebElement confimarpassword;
    @FindBy(id = "user_firstname")
    WebElement name;
    @FindBy(id = "user_lastname")
    WebElement lastname;
    @FindBy(id = "user_mail")
    WebElement email;

    @FindBy(name = "commit")
    WebElement loginButton;

    
    
    public CadastrarPage setLogin(String login) {
        user.clear();
        user.sendKeys(login);
        return this;
    }
    
    public CadastrarPage setPassword(String senha) {
        password.clear();
        password.sendKeys(senha);
        return this;
    }
    public CadastrarPage setConfirma(String senha) {
        confimarpassword.clear();
        confimarpassword.sendKeys(senha);
        return this;
    }
    
    public CadastrarPage setNome(String nome) {
        name.clear();
        name.sendKeys(nome);
        return this;
    }
    
    public CadastrarPage setSobrenome(String sobrenome) {
        lastname.clear();
        lastname.sendKeys(sobrenome);
        return this;
    }
    
    public CadastrarPage setEmail(String mail) {
        email.clear();
        email.sendKeys(mail);
        return this;
    }
    
    public MainPage addValid() {
        loginButton.click();
        return new MainPage(driver);
    }
    public CadastrarPage addInvalid() {
         return this;
    }
    
}
