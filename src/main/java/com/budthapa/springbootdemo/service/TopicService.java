/**
 * 
 */
package com.budthapa.springbootdemo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.budthapa.springbootdemo.domain.Topic;

/**
 * @author budthapa
 * Mar 7, 2017
 * 
 */
@Service
public class TopicService {
	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
			new Topic(1,"course 1","Data Structure & Algorithms"),
			new Topic(2,"course 2","Programming in Java"),
			new Topic(3,"course 3","Aritficial Intelligence"),
			new Topic(4,"course 4","Descrete Maths"),
			new Topic(5,"course 5","Fundamentals of IT")
			
		));
	
	public List<Topic> getAllTopics(){
		return topics;
	}

	/**
	 * @param id
	 * @return
	 */
	public Topic getTopic(int id) {
		return topics.stream().filter(t -> t.getId()==id).findFirst().get(); 
	}

	/**
	 * @param topic
	 */
	public void saveTopic(Topic topic) {
		topics.add(topic);
	}

	/**
	 * @param topic
	 * @param id
	 */
	public void updateTopic(Topic topic, int id) {
		for(Topic t:topics){
			int topicId=t.getId();
			if(id == topicId){
				topics.set(topics.indexOf(t), topic);
			}
		}
	}

	/**
	 * @param topic
	 * @param id
	 */
	public boolean deleteTopic(int id) {
		return topics.removeIf(t -> t.getId()==id);
	}
	
}
