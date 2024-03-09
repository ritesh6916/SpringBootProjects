package com.ritesh.survey.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ritesh.survey.service.SurveyService;
import com.ritesh.survey.templates.Survey;

@RestController
public class SurveyController {

	@Autowired
	SurveyService surveyService;

	@GetMapping("/surveys")
	public List<Survey> getAllSurveys() {
		List<Survey> surveys = surveyService.getAllSurveys();
		return surveys;
	}

	@GetMapping("/surveys/{surveyId}")
	public Survey getSurveyById(@PathVariable String surveyId) {
		Survey survey = surveyService.getSurveyById(surveyId);
		return survey;
	}

}
