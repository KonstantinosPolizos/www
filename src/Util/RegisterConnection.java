package Util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import Entity.Member;

/**
 * Servlet implementation class RegisterConnection
 */
@WebServlet("/RegisterConnection")
public class RegisterConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterConnection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF\\Register.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String barcode = request.getParameter("barcode");
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String description = request.getParameter("description");
		
		Member member = new Member(barcode, name, color, description);
		
		try {
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Member.class)
					.buildSessionFactory();

			Session sess = factory.getCurrentSession();
			sess.beginTransaction();
			
			sess.save(member);
			
			RequestDispatcher rd;
			try {
				sess.getTransaction().commit();
			}
			catch(javax.persistence.PersistenceException exc) {
				rd = request.getRequestDispatcher("Register2.jsp");
				rd.forward(request, response);
				factory.close();
			}
			
			//83.212.79.112
			factory.close();
			rd = request.getRequestDispatcher("Register.jsp");
			rd.forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
