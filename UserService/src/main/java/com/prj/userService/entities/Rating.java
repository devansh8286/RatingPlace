package com.prj.userService.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Rating {

	private String ratingId;
	private String userId;
	private String HotalId;
	private String rating;
	private String remark;

}
