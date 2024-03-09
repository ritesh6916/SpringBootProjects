package com.ritesh.survey.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ritesh.survey.service.SurveyService;
import com.ritesh.survey.templates.Question;
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
		if (survey == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return survey;
	}

	@GetMapping("/surveys/{surveyId}/questions")
	public List<Question> getAllQuestionBySurveyId(@PathVariable String surveyId) {
		List<Question> questions = surveyService.getAllQuestionBySurveyId(surveyId);
		if (questions == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return questions;
	}

	@GetMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question getQuestionBySurveyIdAndQuestionId(@PathVariable String surveyId, @PathVariable String questionId) {
		Question question = surveyService.getQuestionBySurveyIdAndQuestionId(surveyId, questionId);
		if (question == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return question;
	}

	@PostMapping("/surveys/{surveyId}/questions")
	public ResponseEntity<Object> addNewQuestionBySurveyId(@PathVariable String surveyId,
			@RequestBody Question question) {
		String questionId = surveyService.addNewQuestionBySurveyId(surveyId, question);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{questionId}").buildAndExpand(questionId)
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
