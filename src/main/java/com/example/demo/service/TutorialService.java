package com.example.demo.service;

import com.example.demo.exeptions.TutorialNotFoundExeption;
import com.example.demo.model.Tutorial;
import com.example.demo.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialService {
    @Autowired
    TutorialRepository tutorialRepository;
    public List<Tutorial> getAllTutorialByTitle(String title){

        List<Tutorial> tutorialList = tutorialRepository.findByTitleContaining(title);
        return  tutorialList;
    }

    public Tutorial CreateTutorial(Tutorial tutorial){

       Tutorial SavedTutorial =tutorialRepository.save(tutorial);

       return SavedTutorial;
    }

    public Tutorial GetByID(Long id){

        Tutorial NewTutorial = tutorialRepository.findById(id).orElseThrow(()->new TutorialNotFoundExeption("ID not found"));
        return NewTutorial;

    }

    public List<Tutorial> GetAll(){

        List<Tutorial> NewTutorial = tutorialRepository.findAll();

        return  NewTutorial;

    }

    public void deleteTutorial(Long id){
        Tutorial tutorial = tutorialRepository.findById(id).orElseThrow(()->
                new TutorialNotFoundExeption("Sorry unable to find the tutorial"));

        tutorialRepository.delete(tutorial);
    }

    public Tutorial updateTutorial(Long id, Tutorial tutorial){
        Tutorial tut = tutorialRepository.findById(id).orElseThrow(()->
                new TutorialNotFoundExeption("Sorry unable to find the tutorial"));

        tut.setTitle(tutorial.getTitle());
        tut.setDescription(tutorial.getDescription());
        tut.setPublished(tutorial.isPublished());
         return tutorialRepository.save(tut);

    }

}
