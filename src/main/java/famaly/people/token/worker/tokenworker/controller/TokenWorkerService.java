package famaly.people.token.worker.tokenworker.controller;

import famaly.people.token.worker.tokenworker.auth.models.AuthRequest;
import famaly.people.token.worker.tokenworker.auth.models.response.SessionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/auth")
public class TokenWorkerService {


    @Autowired
    private SessionModel sessionModel;

    @RequestMapping(path ="/session/authorisation", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<SessionModel> getAuthorisation(@RequestBody AuthRequest userAuthData){

        return new ResponseEntity<>(sessionModel, HttpStatus.OK);
    }

}
