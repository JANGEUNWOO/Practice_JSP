package com.javalec.ex;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet(urlPatterns= {"/InitP"},initParams= {@WebInitParam(name="id",value="aaaaa"),@WebInitParam(name="pw", value="99999")})
public class InitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public InitParam() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=getInitParameter("id");
		String pw=getInitParameter("pw");
		
		System.out.println("id= "+id);
		System.out.println("pw= "+pw                                                                                                                                                                                                                                                                     );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
