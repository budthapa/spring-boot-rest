/**
 * 
 */
package com.budthapa.springbootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.budthapa.springbootdemo.domain.Topic;
import com.budthapa.springbootdemo.service.TopicService;

/**
 * @author budthapa
 * Mar 7, 2017
 * 
 */
@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable int id){
		return topicService.getTopic(id);
	}
	
	@RequestMapping(value="/topics", method=RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic){
		topicService.saveTopic(topic);
	}
	
	@RequestMapping(value="/topics/{id}", method=RequestMethod.PUT)
	public void updateTopic(@RequestBody Topic topic, @PathVariable int id){
		topicService.updateTopic(topic, id);
	}
	
	@RequestMapping(value="/topics/{id}", method=RequestMethod.DELETE)
	public boolean deleteTopic(@PathVariable int id){
		return topicService.deleteTopic(id);
	}
}
