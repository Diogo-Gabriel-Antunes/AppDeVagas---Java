package br.com.geekhunter.demo.Controller;


import br.com.geekhunter.demo.Model.Curse;
import br.com.geekhunter.demo.repository.CurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/curse")
public class CurseController {

    @Autowired
    private CurseRepository curseRepository;

    @GetMapping
    public List<Curse> listAll() {
        List<Curse> curses = curseRepository.findAll();
        return curses;
    }
}
