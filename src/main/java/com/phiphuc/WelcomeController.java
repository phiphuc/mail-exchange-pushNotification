package com.phiphuc;

import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/mail")
public class WelcomeController {

	@PostMapping("/incomming")
	public void welcome(HttpServletRequest request) {
		try {
			System.out.println("MAIL COMMING");
			JSONObject xmlJSONObj = XML.toJSONObject(IOUtils.toString(request.getInputStream()));
			String jsonPrettyPrintString = xmlJSONObj.toString(6);
			System.out.println(jsonPrettyPrintString);
		} catch (Exception je) {
			System.out.println("MAIL COME EXCEPTION");
			System.out.println(je.toString());
		}
	}

}