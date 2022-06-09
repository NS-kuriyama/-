package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import jp.co.aforce.bean.Bean;

public class RegisterDAO extends DAO {
	public Bean insert(String last_name, String first_name, String sex,String birth_year, String birth_month, String birth_day,
			String job, String phone_number, String mail_address)throws Exception{

		String INSERT_MEMBERS_SQL="INSERT INTO MEMBER_INFO"+
		"(MEMBER_ID,LAST_NAME,FIRST_NAME,SEX,BIRTH_YEAR,BIRTH_MONTH,BIRTH_DAY,JOB,PHONE_NUMBER,MAIL_ADDRESS) VALUES"+
				"(?,?,?,?,?,?,?,?,?,?);";

		Random rand = new Random();
		int id = rand.nextInt(100000000)+100;

		Bean bean = new Bean();
		int result = 0;

		try (Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(INSERT_MEMBERS_SQL)){
		st.setString(1,"KURIYAMA"+id);
		st.setString(2, last_name);
		st.setString(3, first_name);
		st.setString(4, sex);
		st.setString(5, birth_year);
		st.setString(6, birth_month);
		st.setString(7, birth_day);
		st.setString(8, job);
		st.setString(9, phone_number);
		st.setString(10,mail_address);

		result = st.executeUpdate();

		System.out.println(result + "行追加されました");

		}catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e1) {

			e1.printStackTrace();
		}
		return bean;
	}
}




