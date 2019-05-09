package com.eshop.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author float.lu
 */
@Controller
public class HomeController  {

	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

	/* HTML */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String community() {
		return "redirect:/user/login";
	}

    /* HTML */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView community(HttpServletRequest request, HttpServletResponse response) {
		LOG.info("home");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");

    	return modelAndView;
    }

	
}
