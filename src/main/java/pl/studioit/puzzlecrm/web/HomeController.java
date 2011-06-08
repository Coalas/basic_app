/**
 * 
 */
package pl.studioit.puzzlecrm.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;


/**
 * @author K.O.
 * k.olszewski@o2.pl
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(HttpServletRequest request){
		//String restOfTheUrl = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		logger.info("");
		return "home";
	}
	
	//@RequestMapping("/category/**/{id}")
	/*public String handlePreview(HttpServletRequest request, @PathVariable String id, Model model) {
		String restOfTheUrl = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		
		System.out.println(request.getRequestURI()+id);
		return "home";
	}*/
	
}
