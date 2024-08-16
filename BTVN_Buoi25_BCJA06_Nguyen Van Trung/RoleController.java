package crm06.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm06.config.MySQLConfig;

@WebServlet(name = "RoleController", urlPatterns = "/role-add")
public class RoleController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("role-add.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");

		try {
			String roleName = req.getParameter("roleName");
			String description = req.getParameter("description");

			if (roleName.isBlank()) {
				throw new Exception("Tên quyền không được rỗng!");
			}

			String query = "INSERT INTO roles(roles.name, roles.description) " 
					+ "VALUES  ('" + roleName + "', '" + description + "')";
			
			Connection connection = MySQLConfig.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			int isSuccess = preparedStatement.executeUpdate(query);
			if (isSuccess != 0) {
				resp.getWriter().println("Thêm quyền mới thành công");
			} else {
				resp.getWriter().println("Thêm quyền mới thất bại");
			}
			connection.close();

		} catch (Exception e) {
			resp.getWriter().println("Add Role Error: " + e.getMessage());
			
		}

	}
}
