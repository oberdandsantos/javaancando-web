package br.com.allianz.servlets;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/documento")
public class ServletDocumento extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletDocumento() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletOutputStream stream = null;
		BufferedInputStream buffer = null;

		String id = request.getParameter("id");
		try {
			stream = response.getOutputStream();
			File pdf = new File("C:\\JavaAvancado\\documentos\\" + id + ".pdf");
			if (!pdf.exists()) {
				pdf = new File("C:\\JavaAvancado\\documentos\\geral.pdf");
			}
			response.setContentType("application/pdf");
			FileInputStream input = new FileInputStream(pdf);
			buffer = new BufferedInputStream(input);
			int bytes = 0;
			while ((bytes = buffer.read()) != -1) {
				stream.write(bytes);
			}

		} catch (Exception e) {
			throw e;
		} finally {
			if (stream != null) {
				stream.close();
			}
			if (buffer != null) {
				buffer.close();
			}

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
