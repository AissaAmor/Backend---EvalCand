package spring.session.EvalCand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.session.EvalCand.configuration.BCryptManagerUtil;
import spring.session.EvalCand.configuration.JwtTokenUtil;
import spring.session.EvalCand.entities.Candidat;
import spring.session.EvalCand.entities.Coach;
import spring.session.EvalCand.entities.JwtResponse;
import spring.session.EvalCand.repositories.CoachRepository;
import spring.session.EvalCand.services.CandidatService;
import spring.session.EvalCand.services.CoachService;
import spring.session.EvalCand.services.EmailService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/coach")
public class CoachController {
	@Autowired
	CoachRepository coachrepository;

	@Autowired
	CoachService Coachservice;

	@Autowired
	CandidatService candidatservice;

	@Autowired
	EmailService emailservice;

//	@Autowired
//	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

//	@Autowired
//	private JwtUserDetailsService userDetailsService;

	// Ajout d'un coach
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public void addCoach(@RequestBody Coach coach) {
		Coachservice.AjoutCoach(coach);
	}

	// Ajout candidat - coach
	@RequestMapping(path = "/addCandidat", method = RequestMethod.POST)
	public void addCand(@RequestBody Candidat candidat) {
		candidatservice.AjoutCandidat(candidat);

	}

//	@RequestMapping(path = "/all", method = RequestMethod.GET)
//	public List<Coach> getAll() {
//		return Coachservice.getAll();
//	}
//	
//	@RequestMapping(path = "/findcoach/{id}", method = RequestMethod.GET)
//	public Coach getCoach(@PathVariable int id) {
//		return Coachservice.getCoachById(id);
//		}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteCoach(@PathVariable("id") Integer id) {

		Coach coach = Coachservice.getCoachById(id);
		Coachservice.deleteCoach(coach);
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody Coach authenticationRequest) throws Exception {

		Coach coach = Coachservice.loadByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(coach);
		return ResponseEntity.ok(new JwtResponse(token));

	}

	private void send(int id) {
		Coach coach = Coachservice.getCoachById(id);
		try {
			emailservice.sendEmail(coach);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
//		return "Congratulations! Your mail has been send to the Coach.";
	}

	@RequestMapping(value = "/forget-password", method = RequestMethod.POST)
	public String forgetPassword(@RequestBody Coach authenticationRequest) throws Exception {

		Coach coach = Coachservice.loadByEmail(authenticationRequest.getEmail());
		this.send(coach.getId_coach());

		return "Congratulations! Your mail has been send to the Coach.";

	}

	@RequestMapping(value = "/reset-password/{id}", method = RequestMethod.POST)
	public ResponseEntity<?> resetPassword(@PathVariable("id") Integer id, @RequestBody Coach resetPass ) {

		Coach coach = Coachservice.getCoachById(id);
		String pass = resetPass.getPassword();
		System.out.println(id + " / " + resetPass);
		coach.setPassword(pass);

		Coachservice.UpdateCoach(coach);

		final String token = jwtTokenUtil.generateToken(coach);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	
//	@RequestMapping(value = "/update-password/{id}", method = RequestMethod.POST)
//	public void resetPassword(@RequestBody Coach resetPass, @PathVariable("id") Integer id) {
//		
//		Coach coach = Coachservice.getCoachById(id);
//		
//		String oldPass = coach.getPassword();
//		oldPass = BCryptManagerUtil.passwordEncoder().encode(oldPass);
//		
//		String newPass = resetPass.getPassword();
//		System.out.println(id + " / " + oldPass + "/" + newPass);
//		
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		
//		if (passwordEncoder.matches(oldPass,newPass)) {			
//			coach.setPassword(newPass);
//			Coachservice.UpdateCoach(coach);
//		}
//	}
}
