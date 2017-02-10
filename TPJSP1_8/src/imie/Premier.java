package imie;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Premier extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		Integer i;
		Integer j;
		Boolean premier = true;
		
		for(i=1; i<=20; i++){			
			if(i != 1){
				premier = true;
				for(j=2; j<=20; j++){
					if(i%j == 0 && i != j){					
						premier = false;
						break;
					}
				}
				if(premier){
					getJspContext().getOut().println(i + " ");
				}
			}
		}
	}
}
