package com.prj.userService.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
@NoArgsConstructor
public class Rating {

	private String ratingId;
	private String userId;
	private String HotalId;
	private int rating;
	private String feedback;

}
