//package spring.session.EvalCand.controller;
//
//import java.util.Map;
//import java.util.Optional;
//
//import java.util.UUID;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.MissingServletRequestParameterException;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import spring.session.EvalCand.entities.Coach;
//import spring.session.EvalCand.services.CoachService;
//import spring.session.EvalCand.services.EmailService;
//
//
//@CrossOrigin(origins = "http://localhost:4200")
//@RestController
//@RequestMapping("/coach")
//public class PasswordController {
//
//	@Autowired
//	private CoachService coachservice;
//
//	@Autowired
//	private EmailService emailService;
//
//}