/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.servlet;

import br.edu.utfpr.beans.Imagem;
import br.edu.utfpr.model.DaoImagem;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author popovicz
 */
public class ExibirImagemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoImagem daoImagem = new DaoImagem();
        Imagem imagem = new Imagem();

        /*Obtem o caminho relatorio da pasta img*/
        String id_magem = request.getParameter("imagem_id");

        imagem = daoImagem.buscarPorId(Integer.parseInt(id_magem));

        File files = new File(imagem.getImagem());
        response.setContentType("image/jpeg");

        /*Mostra o arquivo que está na pasta img onde foi realizado o upload*/
        for (String file : files.list()) {
            File f = new File(imagem.getImagem() + file);
            BufferedImage bi = ImageIO.read(f);
            OutputStream out = response.getOutputStream();
            ImageIO.write(bi, "jpg", out);
            out.close();
        }
    }
}
