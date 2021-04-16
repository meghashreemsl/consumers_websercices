package com.wolken.wolkenapp.Consumer_Webservices;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.wolken.wolkenapp.Consumer_Webservices.dto.GetResponse;

public class App {
    public static void main( String[] args )
    {
        post();
    	get();
    	update();
    	delete();
    }
    	static void get(){
    	// to get output from  one application to another
    		
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<GetResponse> entity = new HttpEntity<GetResponse>(headers);
        ResponseEntity<Object[]> responseentity = restTemplate.exchange
        		("http://localhost:8080/garage-webservices/getAll", HttpMethod.GET, entity, Object[].class);
        Object[] ob = responseentity.getBody();
        for(int i=0;i<ob.length;i++) {
        	System.out.println(ob[i]);
        }
       // System.out.println(entity.getBody());
       
    }
    	 static void post() {
    		 RestTemplate restTemplate = new RestTemplate();
    		 
    		 GetResponse getResponse= new GetResponse();
    		 getResponse.setColor("ramagreen");
    		 getResponse.setId(20);
    		 getResponse.setNoOfWheels(4);
    		 getResponse.setType("truck");
    		 
    		 HttpHeaders headers = new HttpHeaders();
    		 headers.setContentType(MediaType.APPLICATION_JSON);
    		 headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    		 
    		 HttpEntity<GetResponse> entity = new HttpEntity<GetResponse>(getResponse,headers);
    	        ResponseEntity responseentity = restTemplate.exchange
    	        		("http://localhost:8080/garage-webservices/save", 
    	        				HttpMethod.POST, 
    	        				entity, 
    	        				String.class);
    	        
    	        System.out.println(responseentity.getBody());
 
         }
    	static void update() {
    		 
    		 RestTemplate restTemplate = new RestTemplate();

    			GetResponse getResponse = new GetResponse();
    			getResponse.setType("truck");
    			getResponse.setColor("black");

    			HttpHeaders headers = new HttpHeaders();
    			headers.setContentType(MediaType.APPLICATION_JSON);
    			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

    			HttpEntity<GetResponse> entity = new HttpEntity<GetResponse>( getResponse,headers);

    			ResponseEntity responseentity = restTemplate.exchange("http://localhost:8080/garage-webservices/update",
    					HttpMethod.PUT, entity, String.class);

    			System.out.println(responseentity.getBody());

    		}
    	
    	 static void delete() {
    		 
    		 RestTemplate restTemplate = new RestTemplate();

    		 GetResponse getResponse = new GetResponse();

    		 getResponse.setNoOfWheels(5);

    			HttpHeaders headers = new HttpHeaders();
    			headers.setContentType(MediaType.APPLICATION_JSON);
    			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

    			HttpEntity<GetResponse> entity = new HttpEntity<GetResponse>(getResponse, headers);

    			ResponseEntity responseentity = restTemplate.exchange("http://localhost:8080/garage-webservices/delete",
    					HttpMethod.DELETE, entity, String.class);

    			System.out.println(responseentity.getBody());

    		}  	
}
