package spring.session.EvalCand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring.session.EvalCand.configuration.JwtTokenUtil;
import spring.session.EvalCand.entities.Coach;
import spring.session.EvalCand.entities.JwtResponse;
import spring.session.EvalCand.repositories.CoachRepository;
import spring.session.EvalCand.services.CoachService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/coach")
public class CoachController {
	@Autowired
	CoachRepository coachrepository;

	@Autowired
	CoachService Coachservice;

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	
//	@Autowired
//	private JwtUserDetailsService userDetailsService;

	@RequestMapping(path = "add", method = RequestMethod.POST)
	public void addCoach(@RequestBody Coach coach) {
		Coachservice.AjoutCoach(coach);
	}

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public List<Coach> getAll() {
		return Coachservice.getAll();
	}

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
	
	
}
