package br.com.geekhunter.demo.Model.Curriculum;

import br.com.geekhunter.demo.Model.Technologies;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Skills {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "curriculum")
    @JsonIgnore
    private Curriculum curriculum;
    @Enumerated(EnumType.STRING)
    private Level level;
    @OneToOne
    @JoinColumn(name = "technologies")
    private Technologies technologies;

}