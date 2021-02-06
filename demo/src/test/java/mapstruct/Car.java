package mapstruct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
//@Setter

@AllArgsConstructor

@Builder
public class Car {
	private String make;
	private int numberOfSeats;
//	private CarType type;

	// constructor, getters, setters etc.

//	public String getMake() {
//		return make;
//	}
//
//	public void setMake(String make) {
//		this.make = make;
//	}
//
//	public int getNumberOfSeats() {
//		return numberOfSeats;
//	}
//
//	public void setNumberOfSeats(int numberOfSeats) {
//		this.numberOfSeats = numberOfSeats;
//	}
}
