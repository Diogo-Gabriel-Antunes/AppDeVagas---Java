package br.com.geekhunter.demo.Controller;

import br.com.geekhunter.demo.DTO.curriculum.CreateCurriculumDto;
import br.com.geekhunter.demo.DTO.curriculum.UpdateCurriculumDTO;
import br.com.geekhunter.demo.Model.Curriculum.Curriculum;
import br.com.geekhunter.demo.Service.CurriculumService;
import br.com.geekhunter.demo.repository.CurriculumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curriculum")
public class CurriculumController {

    @Autowired
    private CurriculumService curriculumService;

    @Autowired
    private CurriculumRepository curriculumRepository;

    @GetMapping
    public List<Curriculum> listAll(){
        return curriculumRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curriculum> listOne(@PathVariable Long id){
        Optional<Curriculum> curriculum = curriculumRepository.findById(id);
        return curriculumService.listOne(curriculum);
    }

    @PostMapping
    public ResponseEntity<CreateCurriculumDto> register(@RequestBody CreateCurriculumDto createCurriculumDTO){
        Curriculum curriculum = createCurriculumDTO.convert();
        try{
            curriculumRepository.save(curriculum);
            return ResponseEntity.ok(createCurriculumDTO);
        }catch (Throwable t){
            t.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<UpdateCurriculumDTO> update(@PathVariable Long id,@RequestBody UpdateCurriculumDTO updateCurriculumDTO){
        Optional<Curriculum> curriculum = curriculumRepository.findById(id);
        return curriculumService.update(curriculum,updateCurriculumDTO,curriculumRepository);
    }
}
