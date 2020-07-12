package application.routes;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainRouter {
   
    @GetMapping("/")
    public ResponseEntity welcome () {
        HashMap<String, String> responseBody = new HashMap<>();
        responseBody.put("message", "Welcome to my api");
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
}