package mk.ukim.finki.lab.service.impl;

import mk.ukim.finki.lab.model.User;
import mk.ukim.finki.lab.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.lab.model.exceptions.InvalidUserCredentialException;
import mk.ukim.finki.lab.model.exceptions.PasswordsDoNotMatchException;
import mk.ukim.finki.lab.model.exceptions.UsernameExistsException;
import mk.ukim.finki.lab.repository.jpa.UserRepository;
import mk.ukim.finki.lab.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User login(String username, String password) {
        if(username == null || password == null || username.isEmpty() || password.isEmpty())
            throw new InvalidArgumentsException();
        return userRepository.findByUsernameAndPassword(username,password)
                .orElseThrow(InvalidUserCredentialException::new);
    }

    @Override
    public User register(String username, String password, String repeatpassword, String firstName, String lastName) {
        if(username == null || password == null || repeatpassword == null || firstName == null || lastName == null)
            throw new InvalidArgumentsException();
        if(!password.equals(repeatpassword))
            throw new PasswordsDoNotMatchException();

        if(this.userRepository.findByUsername(username).isPresent() ||
                !this.userRepository.findByUsername(username).isEmpty())
            throw new UsernameExistsException(username);

        User user=new User(username,password,firstName,lastName);

        userRepository.save(user);
        return user;
    }
}
