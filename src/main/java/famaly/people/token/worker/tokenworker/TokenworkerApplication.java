package famaly.people.token.worker.tokenworker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("famaly.people.token.worker.tokenworker")
@EnableWebMvc
public class TokenworkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TokenworkerApplication.class, args);
    }

}

