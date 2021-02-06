package mapstruct;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class CarMapperTest {

	@Test
	void test() {
		// given
//		Car car = new Car("Morris", 5, CarType.SEDAN);
//		Car car = new Car("Morris", 5);

		// @formatter:off
		Car car = Car.builder()
				.make("Morris")
				.numberOfSeats(5)
				.build();
		// @formatter:on

		// when
		CarDto carDto = CarMapper.INSTANCE.carToCarDto(car);

		// then
//		assertThat(carDto).isNotNull();
//		assertThat(carDto.getMake()).isEqualTo("Morris");
//		assertThat(carDto.getSeatCount()).isEqualTo(5);
//		assertThat(carDto.getType()).isEqualTo("SEDAN");

		log.debug("carDto: {}", carDto);
		log.debug("getMake: {}", carDto.getMake());
		log.debug("getSeatCount: {}", carDto.getSeatCount());
	}

}
