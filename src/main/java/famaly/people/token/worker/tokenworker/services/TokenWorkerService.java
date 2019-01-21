package famaly.people.token.worker.tokenworker.services;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/auth/")
public class TokenWorkerService {

    @RequestMapping(path ="/session/authorisation", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String token> getAuthorisation(@RequestBody User userAuthData){
        return null;
    }

}
