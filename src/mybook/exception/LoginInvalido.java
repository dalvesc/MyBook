/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybook.exception;

/**
 *
 * @author gabriela
 */
public class LoginInvalido extends Exception{
    
    public LoginInvalido(){
        super("E-mail ou senha invÃ¡lidos!");
    }
}