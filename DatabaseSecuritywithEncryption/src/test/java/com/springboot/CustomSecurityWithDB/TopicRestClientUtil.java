package com.springboot.CustomSecurityWithDB;

import java.net.URI;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.springboot.CustomSecurityWithDB.entities.Topic;


public class TopicRestClientUtil {

    public void getTopicByIdDemo() {

   	HttpHeaders headers = getHeaders();
       RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/topic/{id}";
       HttpEntity<String> requestEntity = new HttpEntity<String>(headers);

       ResponseEntity<Topic> responseEntity = restTemplate.
    		   exchange(url,
    		   HttpMethod.GET, requestEntity, Topic.class, 37);

       Topic topic = responseEntity.getBody();
       System.out.println("Id:"+topic.getTopicId()+", Title:"+topic.getTitle()
                +", Category:"+topic.getCategory());
   }

	public void getAllTopicsDemo() {
   	HttpHeaders headers = getHeaders();
       RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/topics";
       HttpEntity<String> requestEntity = new
    		   HttpEntity<String>(headers);
       ResponseEntity<Topic[]> responseEntity =
    		   restTemplate.exchange(url, HttpMethod.GET,
    		   requestEntity, Topic[].class);
      System.out.println(responseEntity.getStatusCode());
       Topic[] topics = responseEntity.getBody();
       for(Topic topic : topics) {
             System.out.println("Id:"+topic.getTopicId()+", Title:"+topic.getTitle()
                     +", Category: "+topic.getCategory());
       }
   }

   public void addTopicDemo() {
   	HttpHeaders headers = getHeaders();
       RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/topic";


	    Topic topic = new Topic();
	    topic.setTitle("Security-Topic");
	    topic.setCategory("SpringBoot");



       HttpEntity<Topic> requestEntity = new HttpEntity<Topic>(topic, headers);
       URI uri = restTemplate.postForLocation(url, requestEntity);


       System.out.println(uri.getPath());
   }

   public void updateTopicDemo() {
   	HttpHeaders headers = getHeaders();
       RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/topic";
	    Topic topic = new Topic();
	    topic.setTopicId(37);
	    topic.setTitle("Update:Security-Topic");
	    topic.setCategory("Update:SpringBoot");
       HttpEntity<Topic> requestEntity = new HttpEntity<Topic>(topic, headers);
       restTemplate.put(url, requestEntity);
   }

   public void deleteTopicDemo() {
   	HttpHeaders headers = getHeaders();
       RestTemplate restTemplate = new RestTemplate();


	    String url = "http://localhost:8080/user/topic/{id}";
       HttpEntity<Topic> requestEntity = new HttpEntity<Topic>(headers);
       restTemplate.exchange(url, HttpMethod.DELETE, requestEntity,
    		   Void.class, 37);
   }

   private HttpHeaders getHeaders() {
  // String credential="naresh:naresh";
   	String credential="Swetha:Swetha";


   	String encodedCredential = new String
   			(Base64.encodeBase64(credential.getBytes()));


       HttpHeaders headers = new HttpHeaders();
       headers.setContentType(MediaType.APPLICATION_JSON);
    	headers.add("Authorization", "Basic " + encodedCredential);
   	return headers;
   }


   public static void main(String args[]) {
   	TopicRestClientUtil topicRestClientUtil = new TopicRestClientUtil();

   //	topicRestClientUtil.getAllTopicsDemo();

	//topicRestClientUtil.addTopicDemo();
 //topicRestClientUtil.updateTopicDemo();

 //topicRestClientUtil.getTopicByIdDemo();

topicRestClientUtil.deleteTopicDemo();

topicRestClientUtil.getAllTopicsDemo();
   }
}
