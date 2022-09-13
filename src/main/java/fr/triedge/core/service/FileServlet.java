package fr.triedge.core.service;

import fr.triedge.core.utils.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class FileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String localPath = Config.getInstance().getProperty(Config.APP_IMAGE_PATH);
        String afterPath = request.getRequestURI().substring(request.getContextPath().length());
        if (afterPath.startsWith("/file")){
            afterPath = afterPath.replace("/file","");
        }

        String filePath = localPath + afterPath;

        File file = new File(filePath);

        // Check if file exists
        if (!file.exists()){
            response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
            return;
        }

        String contentType = getServletContext().getMimeType(file.getName());

        response.reset();
        response.setBufferSize(1024);
        response.setContentType(contentType);
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");

        // Prepare streams.
        BufferedInputStream input = null;
        BufferedOutputStream output = null;

        try {
            // Open streams.
            input = new BufferedInputStream(new FileInputStream(file), 1024);
            output = new BufferedOutputStream(response.getOutputStream(), 1024);

            // Write file contents to response.
            byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
        } finally {
            // Gently close streams.
            close(output);
            close(input);
        }
    }

    private static void close(Closeable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
