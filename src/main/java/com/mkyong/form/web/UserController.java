package com.mkyong.form.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mkyong.form.dao.DataStore;
import com.mkyong.form.model.User;

import com.mkyong.form.service.UserService;
import com.mkyong.form.validator.UserFormValidator;



//import javax.validation.Valid;


//http://www.tikalk.com/redirectattributes-new-feature-spring-mvc-31/
//https://en.wikipedia.org/wiki/Post/Redirect/Get
//http://www.oschina.net/translate/spring-mvc-flash-attribute-example
@Controller
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);


	@Autowired
	UserFormValidator userFormValidator;
	 @Autowired
	  private JavaMailSender mailSender;
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userFormValidator);
	}

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	

	// list page
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String showAllUsers(Model model) {

		logger.debug("showAllUsers()");
		model.addAttribute("users", userService.findAll());
		return "users/NewFile";
	}  
	/*@RequestMapping(value = "/processLogin",method = RequestMethod.POST)
	public ModelAndView processLogin(@ModelAttribute("user") User user) {
 
		String name = user.getName();
		String password = user.getPassword();
 
		if ("admin".equalsIgnoreCase(name)
				&& "admin123".equalsIgnoreCase(password)) {
			ModelAndView mv = new ModelAndView("users/test");
			return mv;
		} else {
			ModelAndView mv = new ModelAndView("users/newFile");
			return mv;
		}
	}
	*/
 
	@RequestMapping(value = "/users/emailfrom")
	public String showEmailFrom(Model model) {

		logger.debug("showEmailFromForm()");
		model.addAttribute("users", userService.findAll());
		return "users/EmailForm";
	}
	@RequestMapping(value = "/userslist")
	public String showAllUserslist(Model model) {

		logger.debug("showAllUserslist()");
		model.addAttribute("users", userService.findAll());
		return "users/list";
	}
	@RequestMapping(value = "/usershome")
	public String showAllUserslist1(Model model) {

		logger.debug("showAllUserslist()");
		model.addAttribute("users", userService.findAll());
		return "users/test";
	}
	
	
	 @RequestMapping(value = "/usershome" ,method = RequestMethod.POST)

	   public String submit(Model model, @ModelAttribute("loginBean") User login) {
		   Model a=null;
		   User b= userService.validateUser(login);
		   if (a!=b ) {
			   model.addAttribute("users",userService.findAll());
			   return "users/test";
		   }
		   else {
             model.addAttribute("msg", "Username or Password is wrong!!");
             return "users/NewFile";
         }
		   
	   }
	
	/*@RequestMapping(value = "/userslist")

	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,

	  @ModelAttribute("user") User user) {

	    ModelAndView mav = null;

	    User a= userService.validateUser(user);

	    if (null != a) {

	    mav = new ModelAndView("list");

	    mav.addObject("name", user.getName());

	    } else {

	    mav = new ModelAndView("NewFile");

	    mav.addObject("message", "Username or Password is wrong!!");

	    }

	    return mav;

	  }
	  */
	  
 

 
  
	
	  
	// save or update user
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("userForm") @Validated User user,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {

		logger.debug("saveOrUpdateUser() : {}", user);

		if (result.hasErrors()) {
			populateDefaultModel(model);
			return "users/userform";
		} else {

			redirectAttributes.addFlashAttribute("css", "success");
			if(user.isNew()){
				redirectAttributes.addFlashAttribute("msg", "User added successfully!");
			}else{
				redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
			}
			
			userService.saveOrUpdate(user);
			
			// POST/REDIRECT/GET
			return "redirect:/users/"+user.getId();

			// POST/FORWARD/GET
			// return "user/list";

		}
		

	}

	// show add user form
	@RequestMapping(value = "/users/add", method = RequestMethod.GET)
	
	public String showAddUserForm(Model model) {
		 

		logger.debug("showAddUserForm()");

		User user = new User();
		// set default value
		//user.setName("Himel123");
		//user.setEmail("test@gmail.com");
		//user.setAddress("abc 88");
		//user.setPassword("123");
		//user.setConfirmPassword("123");
		user.setSex("M");
		user.setFramework(new ArrayList<String>(Arrays.asList("Spring MVC", "GWT")));
		user.setSkill(new ArrayList<String>(Arrays.asList("Spring", "Grails", "Groovy")));
		user.setCountry("SG");
		model.addAttribute("userForm", user);
		populateDefaultModel(model);

		return "users/userform";
	}

	// show update form
	@RequestMapping(value = "/users/{id}/update", method = RequestMethod.GET)
	public String showUpdateUserForm(@PathVariable("id") int id, Model model) {

		logger.debug("showUpdateUserForm() : {}", id);
		User user = userService.findById(id);
		model.addAttribute("userForm", user);
		
		populateDefaultModel(model);
		return "users/userform";

	}




	// delete user
	@RequestMapping(value = "/users/{id}/delete", method = RequestMethod.POST)
	public String deleteUser(@PathVariable("id") int id, final RedirectAttributes redirectAttributes) {

		logger.debug("deleteUser() : {}", id);

		userService.delete(id);
		
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User is deleted!");
		
		return "redirect:/userslist";

	}

	//show user
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public String showUser1(@PathVariable("id") int id, Model model) {

		logger.debug("showUser() id: {}", id);

		User user = userService.findById(id);
		if (user == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		model.addAttribute("user", user);

		return "users/show";

	}
	
	
	/*
	// show user
	@RequestMapping(value = "/userslist/{id}")
	public String showUser(@PathVariable("id") int id, Model model) {

		logger.debug("showUser() id: {}", id);

		User user = userService.findById(id);
		if (user == null) {
			model.addAttribute("css", "danger");
			
			model.addAttribute("msg", "User not found");
		}
		model.addAttribute("users",userService.findAll());
		model.addAttribute("user", user);

		return "users/show";

	}
	*/
	
	private void populateDefaultModel(Model model) {

		List<String> frameworksList = new ArrayList<String>();
		frameworksList.add("Spring MVC");
		frameworksList.add("Struts 2");
		frameworksList.add("JSF 2");
		frameworksList.add("GWT");
		frameworksList.add("Play");
		frameworksList.add("Apache Wicket");
		model.addAttribute("frameworkList", frameworksList);
		List<String> name = new ArrayList<String>();
		name.add("himel");
		name.add("rabby");
		name.add("rafi");
		name.add("ratul");
		name.add("xabir");
		name.add("foysal");
		name.add("shourav");
		name.add("ovi");
	

		Map<String, String> skill = new LinkedHashMap<String, String>();
		skill.put("Hibernate", "Hibernate");
		skill.put("Spring", "Spring");
		skill.put("Struts", "Struts");
		skill.put("Groovy", "Groovy");
		skill.put("Grails", "Grails");
		model.addAttribute("javaSkillList", skill);

		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		model.addAttribute("numberList", numbers);

		Map<String, String> country = new LinkedHashMap<String, String>();
		country.put("US", "United Stated");
		country.put("CN", "China");
		country.put("SG", "Bangladesh");
		country.put("MY", "Malaysia");
		model.addAttribute("countryList", country);

	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ModelAndView handleEmptyData(HttpServletRequest req, Exception ex) {

		logger.debug("handleEmptyData()");
		logger.error("Request: {}, error ", req.getRequestURL(), ex);

		ModelAndView model = new ModelAndView();
		model.setViewName("user/show");
		model.addObject("msg", "user not found");

		return model;

	}
	/*@RequestMapping(value = "/users/emailfrom",method = RequestMethod.POST)
    public String doSendEmail(HttpServletRequest request,Model model,final RedirectAttributes redirectAttributes) {
        // takes input from e-mail form
        String recipientAddress = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
         
        // prints debug info
        System.out.println("To: " + recipientAddress);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
         
        // creates a simple e-mail object
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message);
         
        // sends the e-mail
         mailSender.send(email);
         
        // forwards to the view named "Result"
     	redirectAttributes.addFlashAttribute("css", "success");
     	redirectAttributes.addFlashAttribute("msg", "Msg  sent successfully to "+recipientAddress);
    	return "redirect:/emailfrom";
    }
    */

	@RequestMapping(value = "/users/emailfrom",method = RequestMethod.POST)
    public String doSendEmail(HttpServletRequest request,Model model,final RedirectAttributes redirectAttributes,final @RequestParam CommonsMultipartFile attachFile) {
		 // reads form input
        final String emailTo = request.getParameter("recipient");
        final String emailTo1 = request.getParameter("recipientCc");
        final String subject = request.getParameter("subject");
        final String message = request.getParameter("message");
        final ArrayList<String> list=new ArrayList<String>();
        list.add(emailTo1);
        
 
        // for logging
        System.out.println("emailTo: " + emailTo);
        System.out.println("emailTo: " + emailTo1);
        System.out.println("subject: " + subject);
        System.out.println("message: " + message);
        System.out.println("attachFile: " + attachFile.getOriginalFilename());
 
        mailSender.send(new MimeMessagePreparator() {
 
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(
                        mimeMessage, true, "UTF-8");
                messageHelper.setTo(emailTo);
                messageHelper.setSubject(subject);
                messageHelper.setText(message);
               
            
                final String[] arrayOfCCAddress = emailTo1.split(";");
               
                    messageHelper.setTo(arrayOfCCAddress);
               
                // determines if there is an upload file, attach it to the e-mail
                String attachName = attachFile.getOriginalFilename();
                if (!attachFile.equals("")) {
 
                    messageHelper.addAttachment(attachName, new InputStreamSource() {
                         
                        @Override
                        public InputStream getInputStream() throws IOException {
                            return attachFile.getInputStream();
                        }
                    });
                }
            }
 
        });
 
        redirectAttributes.addFlashAttribute("css", "success");
     	redirectAttributes.addFlashAttribute("msg", "Msg  Sent successfully to "+emailTo);
    	return "redirect:/users/emailfrom";
    }
     
/*
	@RequestMapping(value = "/users/emailfrom",method = RequestMethod.POST)
    public String doSendEmail(HttpServletRequest request,Model model,final RedirectAttributes redirectAttributes,final @RequestParam CommonsMultipartFile attachFile) {
		 // reads form input
        final String emailTo = request.getParameter("recipient");
        final String emailTo1 = request.getParameter("recipientCc");
        final String subject = request.getParameter("subject");
        final String TextMessage = request.getParameter("message");
        
        final String username = "neazahsan65@gmail.com";
        final String password = "tani#@!8264";

                String host = "smtp.gmail.com";
        Properties props = new Properties();
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.ssl.trust", host);
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", host);
                props.put("mail.smtp.port", "587");
                
 
        Session sessionMail = Session.getInstance(props, new javax.mail.Authenticator() {
        	
              protected PasswordAuthentication getPasswordAuthentication() {
                                          return new PasswordAuthentication(username, password);
                                  }
                                });

                          try {                    
                                Message message = new MimeMessage(sessionMail);
                                message.setFrom(new InternetAddress(username));

                                List arraylist = new ArrayList();
                                arraylist.add(emailTo);
                                arraylist.add(emailTo1);
                                
                                String[] recipients = (String[]) arraylist.toArray(new String[arraylist.size()]);
                                InternetAddress[] addressTo = new InternetAddress[recipients.length];
                                
                                for (int i = 0; i < recipients.length; i++) {
                                        addressTo[i] = new InternetAddress(recipients[i]);
                                }
                                   message.setRecipients(Message.RecipientType.TO, addressTo);
                              //     message.addRecipient(Message.RecipientType.CC, new InternetAddress("yourOther@email.com"));



                                   message.setSubject(subject);
                                   message.setText(TextMessage);
                                   Transport.send(message);
                                   
                          }catch(Exception e){
                        	  
                        	  
                          }
                // determines if there is an upload file, attach it to the e-mail
                          
        
        redirectAttributes.addFlashAttribute("css", "success");
     	redirectAttributes.addFlashAttribute("msg", "Msg  Sent successfully to "+emailTo);
    	return "redirect:/users/emailfrom";
    }
    */
    
    /*
	@RequestMapping(value = "/users/{id}/emailfrom",method = RequestMethod.POST)
    public String doSendEmail(HttpServletRequest request,@PathVariable("id") int id,Model model,final RedirectAttributes redirectAttributes,final @RequestParam CommonsMultipartFile attachFile) {
		 // reads form input
		User user = null;
		 User user1= userService.findById(id);
		 
        final String emailTo = user.getEmail();
        //final String emailTo1=user.setEmail(emailTo);
        final String subject = request.getParameter("subject");
        final String message = request.getParameter("message");
 
        // for logging
        System.out.println("emailTo: " + emailTo);
        System.out.println("subject: " + subject);
        System.out.println("message: " + message);
        System.out.println("attachFile: " + attachFile.getOriginalFilename());
 
        mailSender.send(new MimeMessagePreparator() { 
 
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(
                        mimeMessage, true, "UTF-8");
                messageHelper.setTo(emailTo);
                messageHelper.setSubject(subject);
                messageHelper.setText(message);
                 
                // determines if there is an upload file, attach it to the e-mail
                String attachName = attachFile.getOriginalFilename();
                if (!attachFile.equals("")) {
 
                    messageHelper.addAttachment(attachName, new InputStreamSource() {
                         
                        @Override
                        public InputStream getInputStream() throws IOException {
                            return attachFile.getInputStream();
                        }
                    });
                }
            }
 
        });
 
        redirectAttributes.addFlashAttribute("css", "success");
     	redirectAttributes.addFlashAttribute("msg", "Msg  sent successfully to "+emailTo);
    	return "redirect:/emailfrom";
    }
*/
}