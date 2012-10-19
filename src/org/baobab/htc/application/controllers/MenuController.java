package org.baobab.htc.application.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 
 * Author: Yamiko J. Msosa Date: 06-Jan-2011 Function: This is the main menu
 * controller for the application
 * 
 */
@Controller
public class MenuController {
	protected static final Log logger = LogFactory.getLog(MenuController.class);

	@RequestMapping(value = "mainmenu.html", method = RequestMethod.GET)
	public String showForm(Map model) {
		String view = "mainmenu";
		return view;
	}

	@RequestMapping(value = "siteActivityReport.html", method = RequestMethod.GET)
	public String showSiteActivityReport(HttpServletRequest request) {
		String baseURL = request.getRequestURL().toString().replaceAll(request.getRequestURI(), "");
		logger.info("baseURL    " + baseURL);
		return "redirect:" + baseURL.trim() + "/birt-viewer/run?__report=./report/SiteActivity.rptdesign&__format=pdf";
	}
	
	@RequestMapping(value = "districtActivityReport.html", method = RequestMethod.GET)
	public String showDistrictActivityReport(HttpServletRequest request) {
		String baseURL = request.getRequestURL().toString().replaceAll(request.getRequestURI(), "");
		logger.info("baseURL    " + baseURL);
		return "redirect:" + baseURL.trim() + "/birt-viewer/run?__report=./report/DistrictActivity.rptdesign&__format=pdf";
	}
	
	@RequestMapping(value = "regionActivityReport.html", method = RequestMethod.GET)
	public String showRegionActivityReport(HttpServletRequest request) {
		String baseURL = request.getRequestURL().toString().replaceAll(request.getRequestURI(), "");
		logger.info("baseURL    " + baseURL);
		return "redirect:" + baseURL.trim() + "/birt-viewer/run?__report=./report/RegionActivity.rptdesign&__format=pdf";
	}
	
	@RequestMapping(value = "nationalActivityReport.html", method = RequestMethod.GET)
	public String showNationlActivityReport(HttpServletRequest request) {
		String baseURL = request.getRequestURL().toString().replaceAll(request.getRequestURI(), "");
		logger.info("baseURL    " + baseURL);
		return "redirect:" + baseURL.trim() + "/birt-viewer/run?__report=./report/NationalActivity.rptdesign&__format=pdf";
	}
	
	private String reportViewerLocation;

	public String getReportViewerLocation() {
		return reportViewerLocation;
	}
	
	//Create auto wired property
	@Autowired 
	@Value("${web.viewer.url}")
	public void setReportViewerLocation(String reportViewerLocation) {
		this.reportViewerLocation = reportViewerLocation;
	}	
}