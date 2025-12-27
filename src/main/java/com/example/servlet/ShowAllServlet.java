package com.example.servlet;

import com.example.util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;

@WebServlet("/show_all")
public class ShowAllServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<String[]> students = new ArrayList<>();

        try (Connection conn = DBUtil.getConnection()) {
            ResultSet rs = conn.createStatement()
                .executeQuery("SELECT name, email, year FROM students");

            while (rs.next()) {
                students.add(new String[]{
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("year")
                });
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }

        request.setAttribute("students", students);
        request.getRequestDispatcher("students.jsp").forward(request, response);
    }
}
