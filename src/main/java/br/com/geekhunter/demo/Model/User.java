package br.com.geekhunter.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class User implements UserDetails {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String senha;
    @OneToMany(mappedBy = "userId",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Perfil> perfil;
    @OneToOne(mappedBy = "userId")
    @JsonIgnore
    private Company company;
    @OneToOne(mappedBy = "userId")
    @JsonIgnore
    private Candidate candidate;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.perfil;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
