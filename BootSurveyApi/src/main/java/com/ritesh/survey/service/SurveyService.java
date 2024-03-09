package com.ritesh.survey.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ritesh.survey.templates.Question;
import com.ritesh.survey.templates.Survey;

@Service
public class SurveyService {

	private static List<Survey> surveys = new ArrayList<>();

	static {
		Question q1 = new Question("01", "Most popular Cloud Plateform Today",
				Arrays.asList("AWS", "Azure", "GCP", "Oracle Cloud"), "AWS");
		Question q2 = new Question("02", "Fastest Growing Cloud Platform",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
		Question q3 = new Question("03", "Most Popular DevOps Tool",
				Arrays.asList("Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");
		Question q4 = new Question("03", "Diversed Cloud plateform for learing in terms of module",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Azure");

		List<Question> Cloudquestions = new ArrayList<>(Arrays.asList(q1, q2, q3, q4));

		Survey cloudServey = new Survey("Cloud", "Cloud Plateforms", "Let's Find Most Liked Cloud Plateforms",
				Cloudquestions);

		surveys.add(cloudServey);
	}
}
