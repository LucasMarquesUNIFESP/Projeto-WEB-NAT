package ProjetoWEB;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class VisitCounter {
	private HttpServletRequest request;
	
	public VisitCounter(HttpServletRequest request) {
		// TODO Auto-generated constructor stub
		this.request = request;
	}
	
	public int Value() {
		
		HttpSession session = request.getSession();
		Integer hitsCount =
                  (Integer)session.getAttribute("hitCounter");
        if( hitsCount ==null || hitsCount == 0 ) session.setAttribute("hitCounter", 1);
        else session.setAttribute("hitCounter", (int)session.getAttribute("hitCounter")+1);
                  
		return (Integer)session.getAttribute("hitCounter");
	}

}
