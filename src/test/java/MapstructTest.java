import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mapstruct.factory.Mappers;

import dto.CarDto;
import dto.CarInteriorDto;
import mapper.CarDtoMapper;
import model.Car;
import model.Vehicle;

public class MapstructTest {

	@Test
	public void testCanFindMapper() {
		int givenSeats = 4;

		CarDtoMapper mapper = Mappers.getMapper(CarDtoMapper.class);

		CarDto carDto = CarDto.builder()
				.manufacturer("Porsche")
				.numberOfWheels(givenSeats)
				.name("911")
				.interior(CarInteriorDto.builder().trunkExists(true).build())
				.build();

		Vehicle vehicle = mapper.apply(carDto);
		assertEquals(vehicle.getClass(), Car.class);
		Car car = (Car) vehicle;
		assertEquals(car.getInterior().getSeats(), givenSeats);
	}
}
