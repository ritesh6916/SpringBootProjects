package com.ritesh.survey.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.ritesh.survey.templates.Question;
import com.ritesh.survey.templates.Survey;

@Service
public class SurveyService {

	public SurveyService() {

	}

	private static List<Survey> surveys = new ArrayList<>();

	static {
		Question q1 = new Question("01", "Most popular Cloud Plateform Today",
				Arrays.asList("AWS", "Azure", "GCP", "Oracle Cloud"), "AWS");
		Question q2 = new Question("02", "Fastest Growing Cloud Platform",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
		Question q3 = new Question("03", "Most Popular DevOps Tool",
				Arrays.asList("Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");
		Question q4 = new Question("04", "Diversed Cloud plateform for learing in terms of module",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Azure");

		List<Question> Cloudquestions = new ArrayList<>(Arrays.asList(q1, q2, q3, q4));

		Survey cloudServey = new Survey("Cloud", "Cloud Plateforms", "Let's Find Most Liked Cloud Plateforms",
				Cloudquestions);

		surveys.add(cloudServey);
	}

	public List<Survey> getAllSurveys() {

		return surveys;
	}

	public Survey getSurveyById(String surveyId) {
		for (Survey s : surveys) {
			if (s.getId().equalsIgnoreCase(surveyId)) {
				return s;
			}
		}
		return null;
	}

	public List<Question> getAllQuestionBySurveyId(String surveyId) {
		Survey survey = getSurveyById(surveyId);
		if (survey == null)
			return null;
		return survey.getQuestions();
	}

	public Question getQuestionBySurveyIdAndQuestionId(String surveyId, String questionId) {
		Survey survey = getSurveyById(surveyId);
		if (survey == null)
			return null;
		List<Question> questions = survey.getQuestions();
		for (Question q : questions) {
			if (q.getId().equalsIgnoreCase(questionId)) {
				return q;
			}
		}
		return null;
	}

	public String addNewQuestionBySurveyId(String surveyId, Question question) {
		List<Question> allQuestions = getAllQuestionBySurveyId(surveyId);
		allQuestions.add(question);
		return question.getId();
	}

	public boolean deleteQuestionBySurveyIdAndQuestionId(String surveyId, String questionId) {
		List<Question> allQuestionBySurveyId = getAllQuestionBySurveyId(surveyId);

		if (allQuestionBySurveyId == null)
			return false;

		Predicate<? super Question> predicate = q -> q.getId().equalsIgnoreCase(questionId);

		return allQuestionBySurveyId.removeIf(predicate);

	}

	public boolean updateQuestionBySurveyIdAndQuestionId(String surveyId, String questionId, Question question) {

		List<Question> allQuestion = getAllQuestionBySurveyId(surveyId);
		boolean removeIf = allQuestion.removeIf(q -> q.getId().equalsIgnoreCase(questionId));
		if(removeIf) {
			return allQuestion.add(question);
		}
		return false;
	}
}
