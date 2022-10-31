package br.com.geekhunter.demo.Controller;

import br.com.geekhunter.demo.DTO.Token.TokenDto;
import br.com.geekhunter.demo.Model.Company;
import br.com.geekhunter.demo.Model.User;
import br.com.geekhunter.demo.Service.TokenService;
import br.com.geekhunter.demo.form.LoginForm;
import br.com.geekhunter.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/authenticade")
public class AuthenticadeController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;
    @PostMapping
    public ResponseEntity<TokenDto> authenticadeLogin(@RequestBody LoginForm form) {
        UsernamePasswordAuthenticationToken dadosLogin = form.converter();
        try {
            Authentication authenticate = authenticationManager.authenticate(dadosLogin);
            String token = tokenService.gerarToken(authenticate);
            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/{id}")
    public User DetailsUser(@PathVariable Long id) {
        Optional<User> company = userRepository.findById(id);

        return company.get();
    }
}
