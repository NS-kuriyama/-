package jp.co.aforce.register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.RegisterDAO;

@WebServlet(urlPatterns = { "/jp.co.aforce/register" })
public class Register extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");


		String last_name = request.getParameter("last_name");
		String first_name = request.getParameter("first_name");
		String sex = request.getParameter("sex");
		String birth_year = request.getParameter("birth_year");
		String birth_month = request.getParameter("birth_month");
		String birth_day = request.getParameter("birth_day");
		String job = request.getParameter("job");
		String phone_number = request.getParameter("phone_number");
		String mail_address = request.getParameter("mail_address");

		RegisterDAO rdao = new RegisterDAO();
		try {
			rdao.insert(last_name, first_name, sex, birth_year, birth_month, birth_day, job, phone_number,
					mail_address);

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("../views/register.jsp").forward(request, response);

	}
}

