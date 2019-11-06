package mapper;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.mapstruct.Mapper;

import dto.CarInteriorDto;
import dto.InteriorDto;
import dto.MotorbikeInteriorDto;
import model.CarInterior;
import model.Interior;
import model.MotorbikeInterior;

@Mapper
public abstract class InteriorDtoMapper implements Function<InteriorDto, Interior> {

	private Map<Class<? extends InteriorDto>, Function<InteriorDto, Interior>> mappingFunctions = new HashMap<Class<? extends InteriorDto>,
			Function<InteriorDto, Interior>>() {{
		put(CarInteriorDto.class, c -> map((CarInteriorDto) c));
		put(MotorbikeInteriorDto.class, c -> map((MotorbikeInteriorDto) c));
	}};

	@Override
	public Interior apply(InteriorDto interiorDto) {
		if (interiorDto == null) {
			return null;
		}

		return mappingFunctions
				.get(interiorDto.getClass())
				.apply(interiorDto);
	}

	abstract CarInterior map(CarInteriorDto carInteriorDto);
	abstract MotorbikeInterior map(MotorbikeInteriorDto motorbikeInteriorDto);
}
