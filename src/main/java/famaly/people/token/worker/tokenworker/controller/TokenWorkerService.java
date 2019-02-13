package famaly.people.token.worker.tokenworker.controller;

import famaly.people.token.worker.tokenworker.auth.models.request.AuthRequest;
import famaly.people.token.worker.tokenworker.auth.models.request.SessionCookies;
import famaly.people.token.worker.tokenworker.auth.models.response.AuthorisationViewCredintailes;
import famaly.people.token.worker.tokenworker.auth.models.response.SessionValidationResponse;
import famaly.people.token.worker.tokenworker.exception.SessionIsNotValidException;
import famaly.people.token.worker.tokenworker.services.generate.SessionGenerators;
import famaly.people.token.worker.tokenworker.services.generate.SessionValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api")
public class TokenWorkerService {

    @Autowired
    private SessionGenerators sessionGenerators;

    @Autowired
    private SessionValidation sessionValidation;

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(path ="/session/authorisation", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<AuthorisationViewCredintailes> getAuthorisation(@RequestBody AuthRequest userAuthData){
        AuthorisationViewCredintailes authCredentiales =
                sessionGenerators.startSessionAuthorisation(userAuthData);
        return new ResponseEntity<>(authCredentiales, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(path = "session/validation", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<SessionValidationResponse> getValidationSession(@RequestBody SessionCookies request){
        try {
            SessionValidationResponse authorisationCredintailes = sessionValidation.validationSession(request);
            return new ResponseEntity<>(authorisationCredintailes, HttpStatus.OK);
        } catch (SessionIsNotValidException ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
