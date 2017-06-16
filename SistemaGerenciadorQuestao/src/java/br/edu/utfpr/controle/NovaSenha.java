/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.controle;

import java.util.UUID;

/**
 *
 * @author popovicz
 */
public class NovaSenha {

    public String gerar() {
        UUID uuid = UUID.randomUUID();
        String myRandom = uuid.toString();
        return myRandom.substring(0, 8);
    }
}
