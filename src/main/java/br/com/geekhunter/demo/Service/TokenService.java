package br.com.geekhunter.demo.Service;

import br.com.geekhunter.demo.Model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    @Value("${appDeVagas.jwt.expiration}")
    private String expiration;
    @Value("${appDeVagas.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authenticate) {
        User user = (User) authenticate.getPrincipal();
        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
        return Jwts.builder().setIssuer("Api De Vagas").setSubject(user.getId().toString()).setIssuedAt(hoje)
                .setExpiration(dataExpiracao).signWith(SignatureAlgorithm.HS256, secret).compact();
    }

    public Boolean isTokenValido(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
