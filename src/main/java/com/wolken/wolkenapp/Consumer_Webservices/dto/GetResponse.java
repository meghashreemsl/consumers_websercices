package com.wolken.wolkenapp.Consumer_Webservices.dto;

import lombok.Data;

@Data

public class GetResponse {
	  
		private int Id;
	   
		private String type;
	   
		private int noOfWheels;
	   
		private String color;

		@Override
		public String toString() {
			return "GetResponse [Id=" + Id + ", type=" + type + ", noOfWheels=" + noOfWheels + ", color=" + color + "]";
		}
		

}
