package imie;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Somme extends SimpleTagSupport {
	private Integer a;
	private Integer b;
	
	@Override
	public void doTag() throws JspException, IOException {
		this.getJspContext().getOut().println(a+b);
	}

	public void setA(Integer a) {
		this.a = a;
	}

	public void setB(Integer b) {
		this.b = b;
	}
}
