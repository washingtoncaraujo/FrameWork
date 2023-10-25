package com.framworkii.apirestfull.controller;

import com.framworkii.apirestfull.model.Statistic;
import com.framworkii.apirestfull.model.Travel;
import com.framworkii.apirestfull.service.StatisticService;
import com.framworkii.apirestfull.service.TravelService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



/*
 * SpringBoot RestController that creates all service end-points related to the statistics.
 * 
 * @author Mariana Azevedo
 * @since 14/09/2019
 */
@RestController
@RequestMapping("/api-travels/statistics")
public class StatisticController {
	
	private static final Logger logger = Logger.getLogger(StatisticController.class);
	
	@Autowired
	private TravelService tripsService;
	
	@Autowired
	private StatisticService statisticsService;
	
	
	/*
	 * Method that returns the statistics based on the trips
	 * 
	 * @author Mariana Azevedo
	 * @since 14/09/2019
	 * 
	 * @return ResponseEntity - 200
	 */
	@GetMapping(produces = { "application/json" })
	public ResponseEntity<Statistic> getStatistics() {
		
		List<Travel> trips = tripsService.find();
		Statistic statistics = statisticsService.create(trips);
		
		logger.info(statistics);
		
		return ResponseEntity.ok(statistics);
	}

}
