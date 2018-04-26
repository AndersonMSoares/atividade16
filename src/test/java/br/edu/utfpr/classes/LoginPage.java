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
 * @author andre
 */
public class LoginPage extends BasePage{

    WebElement username;
    WebElement password;

    @FindBy(name = "login")
    WebElement loginButton;

    public LoginPage(WebDriver drive) {
        super(drive);
    }
    
    public LoginPage setLogin(String login) {
        username.clear();
        username.sendKeys(login);
        return this;
    }
    
    public LoginPage setPassword(String senha) {
        password.clear();
        password.sendKeys(senha);
        return this;
    }
    public MainPage addValid() {
        loginButton.click();
        return new MainPage(driver);
    }
    public LoginPage addInvalid() {
         return this;
    }
    
}
