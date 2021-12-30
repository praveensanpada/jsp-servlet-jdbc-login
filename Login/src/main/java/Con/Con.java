package Con;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Con extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Con() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
//		
//		String name = request.getParameter("name");
//		String pass = request.getParameter("pass");
//		
//		out.println(name);
//		out.println(pass);
		
		System.out.println("HJello");
		PrintWriter out = response.getWriter();
		out.println("Hello");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("jhfeg");
		PrintWriter out = response.getWriter();
		out.println("Hello");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		out.println(name);
		out.println(pass);
		
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		int flag = 0;
		
		try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
            System.out.println("\n                Application Started....\n");
            
            
            ps = con.prepareStatement("select pass from info where name = ?");
            ps.setString(1,name);
            rs = ps.executeQuery();
//            System.out.print(rs.next());
            while(rs.next()){
            	
            	if(pass.equals(rs.getString(1))) {
            		flag = 1;
            		break;
            	}
            	
//                System.out.println(rs.getString(1));
//                out.print(rs.getString(1));
//                out.println(" ");
            }
            
            if(flag == 1) {
//            	out.print("Login Success");
            	 HttpSession session=request.getSession();  
                 session.setAttribute("name",name); 
                 response.sendRedirect("/Login/Success.jsp");
//                 RequestDispatcher rd=request.getRequestDispatcher("/Success.jsp");  
//                 rd.forward(request, response); 
            }else {
//            	out.print("Login Not Success");
            	response.sendRedirect("/Login/index.jsp");
//            	RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");  
//                rd.forward(request, response);
            }
            
//            ps = con.prepareStatement("select * from info");
//            rs = ps.executeQuery();
//            
//            while(rs.next()){
//                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
//                out.print(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
//                out.println(" ");
//            }
            
            
            
        }catch(Exception e){
            System.out.println(e);
        }
		
	}

}
