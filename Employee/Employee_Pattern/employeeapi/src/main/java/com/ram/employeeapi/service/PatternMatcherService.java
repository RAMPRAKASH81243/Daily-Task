package com.ram.employeeapi.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import com.ram.employeeapi.dto.PatternRequest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
@Service
public class PatternMatcherService {
 
	private static final Logger
	log = LoggerFactory.getLogger(PatternMatcherService.class);
    /**
     * Method to match a pattern with an input string
     *
     * @param pattern The regular expression pattern as a string
     * @param input   The input string to match against the pattern
     * @return true if the pattern matches the input string, false otherwise
     */
	public boolean isVaildPattern(String pattern) {
		if(pattern == null || pattern.isEmpty()) {
			log.error("Pattern is null or empty.");
			return false;
		}
		boolean isValid = Pattern.matches("^[A-Za-z0-9?]+$", pattern);
		log.info("pattern validation result for '{}':{}",pattern,isValid);
		return isValid;
	}	
	
	
    public boolean matchPattern(PatternRequest request) {
        
    	log.info("Pattern matching started for pattern: {} input: {}", request.getInput(), request.getPattern());
    	if(! isVaildPattern(request.getPattern())) {
    		log.error("Invaild pattern: '{}'",request.getPattern());
    		return false;
    	}
    	try {
    		String regex = request.getPattern().replace("?","[A-Za-z0-9]");
            Pattern patternGenerated = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = patternGenerated.matcher(request.getInput());
            boolean isMatch = matcher.matches();
            log.info("Pattern matching result: {}", isMatch);
            return isMatch;
        } catch (Exception e) {
            log.error("Error occurred during pattern matching", e);
            return false;
        }
       
    }

}
