package jp.co.aforce.register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.RegisterCheckDAO;
import jp.co.aforce.dao.RegisterDAO;

@WebServlet(urlPatterns = { "/jp.co.aforce/register" })
public class Register extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");


		String last_name = request.getParameter("last_name");
		String first_name = request.getParameter("first_name");
		String sex = request.getParameter("sex");
		int birth_year = Integer.parseInt(request.getParameter("birth_year"));
		int birth_month = Integer.parseInt(request.getParameter("birth_month"));
		int birth_day = Integer.parseInt(request.getParameter("birth_day"));
		String job = request.getParameter("job");
		String phone_number = request.getParameter("phone_number");
		String mail_address = request.getParameter("mail_address");

		RegisterCheckDAO rcdao = new RegisterCheckDAO();
		try {
			rcdao.check(last_name, first_name, sex, birth_year, birth_month, birth_day, job, phone_number,
					mail_address);

		} catch (Exception e1) {

			e1.printStackTrace();
			System.out.println("会員情報が既に登録されています");
		}

		RegisterDAO rdao = new RegisterDAO();
		try {
			rdao.insert(last_name, first_name, sex, birth_year, birth_month, birth_day, job, phone_number,
					mail_address);

		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher register = request.getRequestDispatcher("../views/register.jsp");
				register.forward(request, response);

	}
}

