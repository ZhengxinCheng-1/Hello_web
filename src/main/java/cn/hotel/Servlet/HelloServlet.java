package cn.hotel.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hotel.Utils.DButils;


public class HelloServlet extends HttpServlet {

		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			System.out.println(username + ";"+ password);
			try (Connection conn = DButils.getConnection();){
				System.out.println("Connection successful");
				String sql = "select count(*) from Customer where username =? and password =?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					int count = rs.getInt(1);
					if(count>0) {
						System.out.println("GET info");
					}else {
						System.out.println("NO GET");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
