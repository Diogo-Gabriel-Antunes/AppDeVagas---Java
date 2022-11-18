package br.com.geekhunter.demo.Service;

import br.com.geekhunter.demo.DTO.curriculum.UpdateCurriculumDTO;
import br.com.geekhunter.demo.Model.Curriculum.Curriculum;
import br.com.geekhunter.demo.repository.CurriculumRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurriculumService {

    public ResponseEntity listOne(Optional<Curriculum> curriculum){
        if(curriculum.isPresent()){
            return ResponseEntity.ok(curriculum.get());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<UpdateCurriculumDTO> update(Optional<Curriculum> curriculum, UpdateCurriculumDTO updateCurriculumDTO, CurriculumRepository curriculumRepository) {
        if(curriculum.isPresent()){
            Curriculum curriculum1 = updateCurriculumDTO.convert(curriculum.get());
            curriculumRepository.save(curriculum1);
            return ResponseEntity.ok(updateCurriculumDTO);
        }
        return ResponseEntity.badRequest().build();
    }
}
