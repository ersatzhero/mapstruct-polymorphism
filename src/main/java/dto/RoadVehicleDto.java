package dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public abstract class RoadVehicleDto extends VehicleDto {
	int numberOfWheels;
	InteriorDto interior;
}
