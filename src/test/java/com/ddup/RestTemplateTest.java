package com.ddup;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTest {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<HashMap> resultMap = restTemplate.postForEntity(
				"http://192.168.50.107/frdsyst/www/app.php/frd/fOpt/checkout_frds/?uid=9630784b72346d85832ab759cc093b828216e21b",
				null, HashMap.class);
		System.out.println(resultMap);

	}

}
