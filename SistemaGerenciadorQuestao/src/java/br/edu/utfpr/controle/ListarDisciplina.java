/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.controle;

import br.edu.utfpr.beans.Disciplina;
import br.edu.utfpr.model.DaoDisciplina;
import java.util.List;

/**
 *
 * @author popovicz
 */
public class ListarDisciplina {

    DaoDisciplina disc;
    List<Disciplina> disciplinas;

    public ListarDisciplina() {
        disc = new DaoDisciplina();
        disciplinas = disc.listaTodos();
    }

    public List<Disciplina> listar() {
        return disciplinas;
    }
}
