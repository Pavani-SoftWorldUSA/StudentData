package com.lwl.course.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class PlacementCountDTO {

		private int placedCount;
		private int notPlacedCount;
		
		public int getPlacedCount() {
			return placedCount;
		}
		public void setPlacedCount(int placedCount) {
			this.placedCount = placedCount;
		}
		public int getNotPlacedCount() {
			return notPlacedCount;
		}
		public void setNotPlacedCount(int notPlacedCount) {
			this.notPlacedCount = notPlacedCount;
		}
		
		
		
}
