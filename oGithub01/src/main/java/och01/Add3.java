package och01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add3
 */
@WebServlet("/Add3")
public class Add3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add3() {		//생성자
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet 여기 왔나");
		// Parameter 받기
		int num = Integer.parseInt(request.getParameter("num"));	//request에 num, loc 값 들어있음, 문자열을 대신 숫자로 바꿔줘야 함
		String loc = request.getParameter("loc");
		System.out.println("num -> " + num);
		System.out.println("loc -> " + loc);
		// 목표: 1부터 누적값 전달
		int sum = 0;
		for(int i = 1; i <= num; i++) {
			sum += i;
		}
		System.out.println("sum -> " + sum);
		
		
		// Encoding 적용
		//request.setCharacterEncoding("utf-8"); 없어도 안 깨짐 -> get방식일 때 request 엔코딩 필수 아님
		//response.setContentType("text/html;charset=utf-8");		//한글 깨지지 않게, get방식에 response 엔코딩은 꼭 필요
		
		// 공식 ->  사용자 Browser 에 보여주는 객체
		PrintWriter out = response.getWriter();		//response: 화면에 보여주는 객체, 공식
		out.println("<html><body>");		//콘솔이 아니라 브라우저까지 보여주는 out 객체
		out.printf("<h1>1부터 %d까지 합계</h1>", num);		//%d에 num 입력
		out.printf("<h4>LOC--> %s</h4>", loc);			//%s에 loc 입력
		out.println(sum);
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost 여기 왔네");
		
		// 시기 --> request parameter 받기 전 Encoding 적용		파라미터 받기 전에 엔코딩 해줘야 한글이 안 깨진다
		request.setCharacterEncoding("utf-8");
		
		// Parameter 받기
		int num = Integer.parseInt(request.getParameter("num"));	//request에 num, loc 값 들어있음, 문자열을 대신 숫자로 바꿔줘야 함
		String loc = request.getParameter("loc");
		System.out.println("num -> " + num);
		System.out.println("loc -> " + loc);
		// 목표: 1부터 누적값 전달
		int sum = 0;
		for(int i = 1; i <= num; i++) {
			sum += i;
		}
		System.out.println("sum -> " + sum);
		
		
		// Encoding 적용		파라미터 받기 전에 엔코딩 해줘야 한글이 안 깨진다 response도 마찬가지
		response.setContentType("text/html;charset=utf-8");		//한글 깨지지 않게
		
		// 공식 ->  사용자 Browser 에 보여주는 객체
		PrintWriter out = response.getWriter();		//response: 화면에 보여주는 객체, 공식
		out.println("<html><body>");		//콘솔이 아니라 브라우저까지 보여주는 out 객체
		out.printf("<h1>1부터 %d까지 Post 합계</h1>", num);		//%d에 num 입력
		out.printf("<h4>LOC--> %s</h4>", loc);			//%s에 loc 입력
		out.println(sum);
		out.println("</body></html>");
		out.close();
	}

}
