package imie;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TableAltern extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		Integer i;
		String style = "background-color: #ddd";
		getJspContext().getOut().println("<table border=\"1\">");
		for(i=1; i<=10; i++){
			if(i%2 == 0){
				getJspContext().getOut().println("<tr style=\"" + style + "\">");
			}
			getJspContext().getOut().println("<td>ligne</td><td>" + i + "</td></tr>");
		}
		getJspContext().getOut().println("</table>");
	}
}
