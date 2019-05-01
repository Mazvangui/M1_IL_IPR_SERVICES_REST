package fr.istic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

@WebServlet("/client")
public class HelloServlet extends HttpServlet {

	// TODO : Adapter l'URL en fonction de votre resource (si vous utilisez un
	// runner par exemple)
	public static final String URL = "http://localhost:8080/pr.tp.services/api";

	@XmlRootElement(name = "message")
	public static class SomeMessage {
		public String name;
		public String greetings;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Ceci n'est utile que pour JAXB 2.3.1 et disparaitra plus tard :
		System.setProperty("com.sun.xml.bind.v2.bytecode.ClassTailor.noOptimize",
				"true");

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/plain");
		try {
			Client client = ClientBuilder.newClient();
			String name = "Toto";
			SomeMessage serverResponse = client.target(URL).path("hello").path(name)
					.request(MediaType.APPLICATION_JSON_TYPE).get(SomeMessage.class);
			out.println(serverResponse.greetings + " " + serverResponse.name);

		} catch (Exception e) {
			out.println("No server response");
		}

	}
}