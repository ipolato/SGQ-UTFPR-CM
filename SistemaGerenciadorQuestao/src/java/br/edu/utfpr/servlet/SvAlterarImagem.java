/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.servlet;

import br.edu.utfpr.beans.Imagem;
import br.edu.utfpr.beans.Professor;
import br.edu.utfpr.model.DaoImagem;
import br.edu.utfpr.model.DaoProfessor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author popovicz
 */
public class SvAlterarImagem extends HttpServlet {

    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "upload";
    // upload settings
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    /**
     * Upon receiving file upload submission, parses the request to read upload
     * data and saves the file on disk.
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        DaoProfessor daoProfessor = new DaoProfessor();
        Professor professor = new Professor();
        professor = (Professor) request.getSession(true).getAttribute("professor");

        // checks if the request actually contains upload file
        if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            PrintWriter writer = response.getWriter();
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }

        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // constructs the directory path to store upload file
        // this path is relative to application's directory
        String uploadPath = getServletContext().getRealPath("")
                + File.separator + UPLOAD_DIRECTORY;

        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            // parses the request's content to extract file data
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                String caminho = null;
                String nome_do_arquivo = null;
                if (professor.getImagem().getImagem() != null) {
                    File seraApagado = new File(professor.getImagem().getImagem());
                    if (seraApagado.exists()) {
                        seraApagado.delete();
                    }
                }
                for (FileItem item : formItems) {
                    // processes only fields that are not form fields
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + professor.getId() + fileName;
                        File storeFile = new File(filePath);

                        // saves the file on disk
                        item.write(storeFile);
                        System.out.println("Upload has been done successfully!");
                        caminho = filePath;
                        nome_do_arquivo = fileName;
                    }
                }
                //salva no banco o caminho da imagem
                DaoImagem daoImagem = new DaoImagem();
                Imagem imagem = new Imagem();
                imagem = daoImagem.buscarPorId(professor.getImagem().getIdImagem());
                imagem.setImagem(caminho);
                imagem.setNomeArquivo(nome_do_arquivo);
                daoImagem.update(imagem);
                File files = new File(imagem.getImagem());

                /*Mostra o arquivo que está na pasta img onde foi realizado o upload*/
                for (String file : files.list()) {
                    File f = new File(imagem.getImagem() + file);
                    BufferedImage bi = ImageIO.read(f);
                    OutputStream out = response.getOutputStream();
                    ImageIO.write(bi, "jpg", out);
                    out.close();
                }
            }
        } catch (Exception ex) {
            System.out.println("There was an error: " + ex.getMessage());
        }
        // redirects client to message page
        response.sendRedirect("alterarImagem.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}