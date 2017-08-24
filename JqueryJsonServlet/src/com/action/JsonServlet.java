package com.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@SuppressWarnings("serial")
public class JsonServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String category = request.getParameter("category");
         List<String> result = new ArrayList<String>();

         if (category.equalsIgnoreCase("serial")) {
                 result.add("Game Of Throme");
                 result.add("Prison Break");
                 result.add("Breaking Bad");
                 result.add("Sherlok Home");
                 result.add("Suits");
         } else if (category.equalsIgnoreCase("movies")) {
                 result.add("Inception");
                 result.add("War Horse");
                 result.add("Avatar");
                 result.add("Titanic");
                 result.add("Life is Beautiful");
         } else if (category.equalsIgnoreCase("sports")) {
                 result.add("Basket Ball");
                 result.add("Football");
                 result.add("Tennis");
                 result.add("Rugby");
                 result.add("Cricket");
         }
         
         String json = new Gson().toJson(result);
         response.setContentType("application/json");
         response.getWriter().write(json);
	}
	
}
