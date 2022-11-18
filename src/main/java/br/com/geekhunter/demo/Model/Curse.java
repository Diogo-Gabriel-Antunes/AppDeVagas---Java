package br.com.geekhunter.demo.Model;


import br.com.geekhunter.demo.Model.Curriculum.Level;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Curse {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "technologies_id")
    private Technologies technologies;
    @Enumerated(EnumType.STRING)
    private Level level;
    @Column(length = 999999)
    private String img;


}
