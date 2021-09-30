package cn.hotel.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hotel.Utils.DButils;

public class regServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println(username + ";"+ password);
		try (Connection conn = DButils.getConnection();){
			System.out.println("connection");
			String sql = "insert into Customer values(null,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.executeUpdate();
			System.out.println("input info");
			PrintWriter pw = resp.getWriter();
			pw.print("Successful!");
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
