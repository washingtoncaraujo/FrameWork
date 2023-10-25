package com.framworkii.apirestfull.model;

import com.framworkii.apirestfull.enumeration.TravelTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/*
 * Class that implements the Travel structure.
 * 
 * @author Mariana Azevedo
 * @since 14/09/2019
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Travel {
	
	private Long id;
	private String orderNumber;
	private BigDecimal amount;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private TravelTypeEnum type;
	
	public Travel(TravelTypeEnum type){
		this.type = type;
	}

}
