package mapper;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.mapstruct.Mapper;

import dto.CarDto;
import dto.MotorbikeDto;
import dto.VehicleDto;
import model.Car;
import model.Motorbike;
import model.Vehicle;

@Mapper(uses = InteriorDtoMapper.class)
public abstract class CarDtoMapper implements Function<VehicleDto, Vehicle> {

	private Map<Class<? extends VehicleDto>, Function<VehicleDto, Vehicle>> mappingFunctions = new HashMap<Class<? extends VehicleDto>,
			Function<VehicleDto, Vehicle>>() {{
		put(CarDto.class, c -> map((CarDto) c));
		put(MotorbikeDto.class, c -> map((MotorbikeDto) c));
	}};

	@Override
	public Vehicle apply(VehicleDto carDto) {
		if (carDto == null) {
			return null;
		}

		return mappingFunctions
				.get(carDto.getClass())
				.apply(carDto);
	}

	abstract Car map(CarDto car);
	abstract Motorbike map(MotorbikeDto car);
}
