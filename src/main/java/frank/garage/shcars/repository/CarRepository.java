package frank.garage.shcars.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import frank.garage.shcars.Car;

public interface CarRepository extends MongoRepository<Car, String> {

	List<Car> getAllByOrderByVehicleId();
	
	Car findByVehicleId(long vehicleId);
	
	Optional<Car> findById(String id);
	
	List<Car> findByWarehouseId(long warehouseId);
	
	List<Car> findByVehiclemakeOrVehiclemodel(String vehiclemakeOrvehiclemodel);
	
	List<Car> findAllByOrderByVehicleprice();
	
	List<Car> findAllByOrderByVehiclepriceDesc();
	
	List<Car> findAllByVehiclelicensedTrue();
	
	List<Car> findAllByOrderByVehicleaddeddateDesc();
}