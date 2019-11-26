package com.example.postgresdemo.controller;

import com.example.postgresdemo.model.Survey;
import com.example.postgresdemo.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

;import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

@RestController
public class SurveyController {

    @Autowired
    private SurveyRepository surveyRepository;

    @GetMapping("/survey/{surveyId}")
    public Optional<Survey> getSurveyById(@PathVariable Long surveyId) {
        return surveyRepository.findById(surveyId);
    }

    @PostMapping("/survey")
    public Survey createProject(@Valid @RequestBody Survey survey) {
        return surveyRepository.save(survey);
    }
}
