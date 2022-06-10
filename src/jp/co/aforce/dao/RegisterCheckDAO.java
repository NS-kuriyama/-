package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import jp.co.aforce.bean.Bean;

public class RegisterCheckDAO extends DAO {
	public Bean check(String last_name, String first_name, String sex,int birth_year, int birth_month, int birth_day,
			String job, String phone_number, String mail_address)throws Exception{

		String CHECK_MEMBERS_SQL="SELECT * MEMBER_INFO"+
		"WHERE( LAST_NAME = ? OR FIRST_NAME = ? OR SEX = ? OR BIRTH_YEAR = ? OR BIRTH_MONTH = ? OR BIRTH_DAY = ?"
		+ "OR JOB = ? OR PHONE_NUMBER = ? OR MAIL_ADDRESS = ? LIMIT = 1);";

		Bean bean = new Bean();

		try (Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(CHECK_MEMBERS_SQL)){
		st.setString(2, last_name);
		st.setString(3, first_name);
		st.setString(4, sex);
		st.setInt(5, birth_year);
		st.setInt(6, birth_month);
		st.setInt(7, birth_day);
		st.setString(8, job);
		st.setString(9, phone_number);
		st.setString(10,mail_address);

		 Resultset rs = (Resultset) st.executeQuery();

		}catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e1) {

			e1.printStackTrace();
		}
		return bean;

	}

}




