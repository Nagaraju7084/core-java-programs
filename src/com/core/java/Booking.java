package com.core.java;
class Booking{
		private String roomId;
		private String date;
		
		public Booking(String roomId, String date) {
			this.roomId = roomId;
			this.date = date;
		}
		public String getRoomId() {
			return roomId;
		}
	}