package com.vd.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vd.model.Employee;
import com.vd.service.FileUploadService;


@Controller
public class MainController {
	@Autowired
	private ServletContext sctx;
	@Autowired
	private FileUploadService service;
	@Value("${upload.file.location}")
	private String location;
	
	@RequestMapping(value = "/upload",method = RequestMethod.GET)
	public String generateHomePage(@ModelAttribute("employee") Employee employee, ModelAndView model) {
		
		return "upload";
	}
	@PostMapping("/upload")
	public String uploadFile(@ModelAttribute("employee")Employee model,RedirectAttributes map,BindingResult error) throws IOException {
		String msg=null;
		String location="E:/upload";
		msg=service.upload( model);
		map.addFlashAttribute("msg", msg);
		return "redirect:upload";
	}
	
	@GetMapping("/downloadlist")
	public String downloadPageGen(Model model) {
		List<String> nameList= service.getAllFile();
		model.addAttribute("list", nameList);
		return "downloadres";
	}
	@GetMapping("/download")
	public String DownloadFile(@RequestParam("name") String fileName,HttpServletResponse  res) throws IOException {
		
		File file= new File(location+"/"+fileName);
		String mimetype=null;
		res.setContentLengthLong(file.length());
		mimetype=sctx.getMimeType(location+"/"+fileName);
		res.setContentType(mimetype==null?"application/octet-stream":mimetype);
		InputStream is=new FileInputStream(file);
		OutputStream os=res.getOutputStream();
		res.addHeader("Content-Disposition", "attachment:fileName="+fileName);
		IOUtils.copy(is, os);
		return null;
	}
	
}
