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
public class MainPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"loggedas\"]")
    WebElement user;
    WebElement flash_error;
    @FindBy(xpath = "//*[@id=\"errorExplanation\"]/ul/li")
    WebElement erro;
  

    public MainPage(WebDriver driver) {
        super(driver);
    }
    
    public String getUser() {
        return user.getText();
    }
    public String getErro(){
        return flash_error.getText();
    }
    public String getErroConta(){
        return erro.getText();
    }
   


}
