package famaly.people.token.worker.tokenworker.controller;

import famaly.people.token.worker.tokenworker.auth.models.request.AuthRequest;
import famaly.people.token.worker.tokenworker.auth.models.response.SessionModel;
import famaly.people.token.worker.tokenworker.token.service.SessionGenerators;
import famaly.people.token.worker.tokenworker.token.service.SessionReturning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api")
public class TokenWorkerService {


    @Autowired
    private SessionReturning sessionReturning;

    @RequestMapping(path ="/session/authorisation", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<SessionModel> getAuthorisation(@RequestBody AuthRequest userAuthData){
        SessionModel sessionModel = ((SessionGenerators)sessionReturning).startSessinAuthorisation(userAuthData);
        return new ResponseEntity<>(sessionModel, HttpStatus.OK);
    }

}
