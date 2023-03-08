package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ActiveProfiles("test") //Indicates it's a test profile so will not run DataLoader
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskyFrom2018(){
		List<Whisky> found = whiskyRepository.findByYear(2018);
		assertEquals(6, found.size());
	}

	@Test
	public void canFindWhiskyByDistilleryAndAge(){
		List<Whisky> found = whiskyRepository.findByAgeAndDistilleryName( 15, "Glendronach");
		assertTrue(found.size()>0);
	}

	@Test
	public void canFindDistilleryWithWhiskiesAged12(){
		List<Distillery> found = distilleryRepository.findByWhiskiesAge(12);
		assertEquals(6, found.size());
	}


}
