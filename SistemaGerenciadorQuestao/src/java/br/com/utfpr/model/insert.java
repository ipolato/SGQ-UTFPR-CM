/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utfpr.model;

import java.io.File;

/**
 *
 * @author popovicz
 */
public class insert {

    public static void main(String[] args) {
        DaoProfessor prof = new DaoProfessor();
        DaoProfessor prof1 = new DaoProfessor();
        DaoProfessor prof2 = new DaoProfessor();
        DaoDisciplina disc1 = new DaoDisciplina();
        DaoDisciplina disc2 = new DaoDisciplina();
        DaoImagem img0 = new DaoImagem();
        DaoImagem img1 = new DaoImagem();
        DaoImagem img2 = new DaoImagem();
        DaoImagem img3 = new DaoImagem();
        DaoImagem img4 = new DaoImagem();
        DaoMonitor mon = new DaoMonitor();
        DaoMonitor mon1 = new DaoMonitor();
        String path = "img/";

        prof.getProfessor().setNome("Igor");
        prof1.getProfessor().setNome("Ivanilton");
        prof2.getProfessor().setNome("Rafael");
        mon.getMonitor().setNome("Willian");
        mon1.getMonitor().setNome("Michele");

        prof.getProfessor().setRA("igor");
        prof1.getProfessor().setRA("ivanilton");
        prof2.getProfessor().setRA("rafael");
        mon.getMonitor().setRA("willian");
        mon1.getMonitor().setRA("michele");

        prof.getProfessor().setSenha("@123mudar");
        prof1.getProfessor().setSenha("@123mudar");
        prof2.getProfessor().setSenha("@123mudar");
        mon.getMonitor().setSenha("08487724906");
        mon1.getMonitor().setSenha("@123mudar");

        prof.getProfessor().setSexo(true);
        prof1.getProfessor().setSexo(true);
        prof2.getProfessor().setSexo(true);
        mon.getMonitor().setSexo(true);
        mon1.getMonitor().setSexo(false);

        File arq1 = new File(path + "userHomem.png");
        byte[] bFile1 = new byte[(int) arq1.length()];
        img0.getImagem().setNomeArquivo("userHomem.png");
        //img0.getImagem().setImagem(bFile1);
        img0.adiciona(img0.getImagem());
        prof.getProfessor().setImagem(img0.getImagem());
        prof.adiciona(prof.getProfessor());

        File arq2 = new File(path + "userHomem.png");
        byte[] bFile2 = new byte[(int) arq2.length()];
        img1.getImagem().setNomeArquivo("userHomem.png");
        // img1.getImagem().setImagem(bFile2);
        img1.adiciona(img1.getImagem());
        prof1.getProfessor().setImagem(img1.getImagem());
        prof1.adiciona(prof1.getProfessor());

        File arq3 = new File(path + "userHomem.png");
        byte[] bFile3 = new byte[(int) arq3.length()];
        img2.getImagem().setNomeArquivo("userHomem.png");
        // img2.getImagem().setImagem(bFile3);
        img2.adiciona(img2.getImagem());
        prof2.getProfessor().setImagem(img2.getImagem());
        prof2.adiciona(prof2.getProfessor());

        File arq4 = new File(path + "userHomem.png");
        byte[] bFile4 = new byte[(int) arq4.length()];
        img3.getImagem().setNomeArquivo("userHomem.png");
        //img3.getImagem().setImagem(bFile4);
        img3.adiciona(img3.getImagem());
        mon.getMonitor().setImagem(img3.getImagem());
        mon.adiciona(mon.getMonitor());

        File arq5 = new File(path + "userMulher.png");
        byte[] bFile5 = new byte[(int) arq5.length()];
        img4.getImagem().setNomeArquivo("userMulher.png");
        //img4.getImagem().setImagem(bFile5);
        img4.adiciona(img4.getImagem());
        mon1.getMonitor().setImagem(img4.getImagem());
        mon1.adiciona(mon1.getMonitor());

        disc1.getDisciplina().setNome("Algoritmo");
        disc1.getDisciplina().setMonitor(mon.getMonitor());
        disc1.getDisciplina().setProfessor(prof1.getProfessor());
        disc2.getDisciplina().setNome("Algoritmo1");
        disc2.getDisciplina().setMonitor(mon.getMonitor());
        disc2.getDisciplina().setProfessor(prof2.getProfessor());
        disc1.adiciona(disc1.getDisciplina());
        disc2.adiciona(disc2.getDisciplina());
    }
}
