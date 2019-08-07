package application.routes;

import application.common.ResourceNotFoundException;
import application.model.User;
import application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserRouter {

    private final UserRepository userRepository;

    private void verifyUserExists(Optional<User> user) {
        if (!user.isPresent()) throw new ResourceNotFoundException("User not found");
    }

    @Autowired
    public UserRouter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(userRepository.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
        Optional<User> user = userRepository.findById(id);
        verifyUserExists(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        User userCreated = userRepository.save(user);
        return new ResponseEntity<>(userCreated, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @Valid @RequestBody User user) {
        Optional<User> userFounded = userRepository.findById(id);
        verifyUserExists(userFounded);

        userFounded.get().setName(user.getName());
        userRepository.save(userFounded.get());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
