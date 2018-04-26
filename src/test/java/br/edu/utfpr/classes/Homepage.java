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
public class Homepage extends BasePage{
    
    @FindBy(xpath = "//*[@id=\"account\"]/ul/li[1]/a")
    WebElement entrar;
    @FindBy(xpath = "//*[@id=\"account\"]/ul/li[2]/a")
    WebElement cadastrar;

    public Homepage(WebDriver driver) {
        super(driver);
    } 
   
    public LoginPage getLogin() {
        entrar.click();
        return new LoginPage(driver);
    }
    
    public CadastrarPage getCadastro(){
        cadastrar.click();
        return new CadastrarPage(driver);
    }
    
}
