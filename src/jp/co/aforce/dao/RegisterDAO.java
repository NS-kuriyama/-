package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import jp.co.aforce.bean.Bean;

public class RegisterDAO extends DAO {
	public Bean insert(String last_name, String first_name, String sex,int birth_year, int birth_month, int birth_day,
			String job, String phone_number, String mail_address)throws Exception{

		String INSERT_MEMBERS_SQL="INSERT INTO MEMBER_INFO"+
		"(MEMBER_ID,LAST_NAME,FIRST_NAME,SEX,BIRTH_YEAR,BIRTH_MONTH,BIRTH_DAY,JOB,PHONE_NUMBER,MAIL_ADDRESS) VALUES"+
				"(?,?,?,?,?,?,?,?,?,?);";

		Random rand = new Random();
		int id = rand.nextInt(100000000)+100;

		LocalDateTime nowDateTime = LocalDateTime.now();
		DateTimeFormatter java11Format = DateTimeFormatter.ofPattern("yyMMddHHmmss");
		String time = nowDateTime.format(java11Format);


		Bean bean = new Bean();

		int result = 0;

		try (Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(INSERT_MEMBERS_SQL)){
		st.setString(1,"A"+time);
		st.setString(2, last_name);
		st.setString(3, first_name);
		st.setString(4, sex);
		st.setInt(5, birth_year);
		st.setInt(6, birth_month);
		st.setInt(7, birth_day);
		st.setString(8, job);
		st.setString(9, phone_number);
		st.setString(10,mail_address);

		result = st.executeUpdate();
		System.out.println("会員情報の登録が完了しました");

		}catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e1) {

			e1.printStackTrace();
		}
		return bean;

	}

}




