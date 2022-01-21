package com.example.demo.controller;

import com.example.demo.model.Tutorial;
import com.example.demo.repository.TutorialRepository;
import com.example.demo.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")

public class TutorialController {

    @Autowired
    TutorialService tutorialService;

    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> getTutorials(@RequestParam(required = false) String title) {

        List<Tutorial> tutorialList = tutorialService.getAllTutorialByTitle(title);
        return new ResponseEntity(tutorialList,HttpStatus.OK);

    }

    @GetMapping("/tutorials/all")
    public ResponseEntity<List<Tutorial>> getAllTutorials() {

        List<Tutorial> tutorialList =  tutorialService.GetAll();
        return new ResponseEntity(tutorialList,HttpStatus.OK);

    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {

        Tutorial newTutorial = tutorialService.GetByID(id);
        return  new ResponseEntity(newTutorial,HttpStatus.OK);
    }

    @PostMapping("/tutorials")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
   Tutorial SavedTutorial = tutorialService.CreateTutorial(tutorial);
return new ResponseEntity(SavedTutorial,HttpStatus.CREATED);
    }

    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
      return new ResponseEntity(tutorialService.updateTutorial(id, tutorial), HttpStatus.OK);
    }

    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<String> deleteTutorial(@PathVariable("id") long id) {
        System.out.println(id);
        tutorialService.deleteTutorial(id);
        return new ResponseEntity("Tutorial has been deleted",HttpStatus.OK);

    }

    @DeleteMapping("/tutorials")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
return null;
    }

    @GetMapping("/tutorials/published")
    public ResponseEntity<List<Tutorial>> findByPublished() {
return null;
    }
}