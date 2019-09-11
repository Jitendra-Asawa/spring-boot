package com.infoobjects.userlogin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.infoobjects.model.Customer;
import com.infoobjects.model.Student;
import com.infoobjects.model.Teacher;
import com.infoobjects.repositories.StudentRepository;
import com.infoobjects.repositories.TeacherRepository;
import com.infoobjects.services.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CrudController {

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	TeacherRepository teacherRepository;
//	@Autowired
//	CustomerRepository customerRepository;
	@Autowired
	CustomerService customerService;

	@RequestMapping("/")
	public ModelAndView start() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index.jsp");
		return model;
	}
	@RequestMapping(value = "hello")
	public ModelAndView helloPage(@RequestParam("name") String name) {
		System.out.println("Hello " + name);
		ModelAndView model = new ModelAndView();
		model.addObject("name", name);
		model.setViewName("hello");
		return model;
	}

//	@GetMapping("hello")
//	ResponseEntity<String> hello() {
//	    return ResponseEntity.ok("Hello World!");
//	}

	@GetMapping(value = "students")
	public ModelAndView getAllStudents() {
		System.out.println("getAllStudents");
		List<Student> studentList = (List<Student>) studentRepository.findAll();
		System.out.println(studentRepository.count());
		System.out.println(studentList);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("showRecords");
		modelAndView.addObject(studentList);
		return modelAndView;
	}

	@RequestMapping(value = "teachers")
//	@ResponseBody
	public ModelAndView getAllTeachers() {
		System.out.println("getAllTeachers");
		List<Teacher> teacherList = (List<Teacher>) teacherRepository.findAll();
		System.out.println(teacherRepository.count());
//		System.out.println(teacherList.get(0).toString());
		System.out.println(teacherRepository.findById(1).get());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("teacherList", teacherList);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("teacherList", teacherList);
		modelAndView.setViewName("showRecords");
		return modelAndView;
	}

//	@GetMapping(value = "customers")
//	public ModelAndView getAllCustomers() {
//		System.out.println("getAllCustomers");
//		List<Customer> customerList = (List<Customer>) customerService.getAllRecords();
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("showRecords");
//		modelAndView.addObject(customerList);
//		return modelAndView;
//	}

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		System.out.println("getAllCustomers");
		List<Customer> customerList = (List<Customer>) customerService.getAllRecords();
		return customerList;
	}
	
	@PostMapping(value = "createCustomer")
	public String createCustomerRecord(Customer customerObject) {
//		Customer customerObject = new Customer(14, "pohn", Calendar.getInstance().getTimeInMillis(),
//				Calendar.getInstance().getTimeInMillis());
//		customerObject.setId(id);
//		customerObject.setAmount(1200);
		customerObject.setTimeCreate(Calendar.getInstance().getTimeInMillis());
		customerObject.setTimeUpdate(Calendar.getInstance().getTimeInMillis());
		System.out.println(customerObject);
		customerService.createCustomerRecord(customerObject);
		return "index";
	}
	
//	@GetMapping("/customers")
//	public String getAllCustomers() {
//		System.out.println("getAllCustomers");
////		List<Customer> customerList = (List<Customer>) customerService.getAllRecords();
//		return "Hello Customer";
//	}
	
//	@PostMapping(value = "createCustomer")
//	public String createCustomerRecord() {// Customer customerObject) {
//		Customer customerObject = new Customer(14, "pohn", Calendar.getInstance().getTimeInMillis(),
//				Calendar.getInstance().getTimeInMillis());
//		customerObject.setAmount(1200);
//		customerService.createCustomerRecord(customerObject);
//		return "index";
//	}
//
//	@PostMapping(value = "deleteCustomer")
//	public String deleteCustomerRecord() throws IllegalArgumentException {// Customer customerObject) {
//		int id = 14;
//		customerService.deleteCustomerRecord(id);
//		return "index";
//	}

	// File Upload Not Working
	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println(file.getOriginalFilename());
		File newFile = new File("/home/infoobjects/STS/workspace-sts-3.9.8.RELEASE/database-mysql-access-demo/"+file.getOriginalFilename());
		newFile.createNewFile();
		FileOutputStream fileOutputStream = new FileOutputStream(newFile);
		System.out.println(fileOutputStream.toString());
		fileOutputStream.write(file.getBytes());
		fileOutputStream.close();
		return "File Upload successful";
	}
	
	 
	@RequestMapping(value = "/download", method = RequestMethod.GET) 
	public ResponseEntity<Object> downloadFile(@RequestParam(name = "file") String fileName) throws IOException  {
	   String filename = "/home/infoobjects/STS/workspace-sts-3.9.8.RELEASE/database-mysql-access-demo/src/main/resources/"+fileName;
	   File file = new File(filename);
	   InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
	   HttpHeaders headers = new HttpHeaders();
	      
	   headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
	   headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
	   headers.add("Pragma", "no-cache");
	   headers.add("Expires", "0");
	      
	   ResponseEntity<Object> 
	   responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(
	      MediaType.parseMediaType("application/txt")).body(resource);
	      
	   return responseEntity;
	}
	
//	@RequestMapping("/error")
//	public String errorPage() {
//		return "error";
//	}
//	@Override
//	public String getErrorPath() {
//		// TODO Auto-generated method stub
//		return errorPage();
//	}

}
