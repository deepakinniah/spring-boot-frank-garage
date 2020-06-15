package frank.garage.cart.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import frank.garage.cart.Item;

public interface ItemRepository extends MongoRepository<Item, String> {

	List<Item> getAllByOrderByVehicleId();
	
	Item findByVehicleId(long vehicleId);
	
	List<Item> findByWarehouseId(long warehouseId);
	
	List<Item> findAllByOrderByVehicleprice();
	
	List<Item> findAllByOrderByVehiclepriceDesc();
	
	List<Item> findAllByVehiclelicensedTrue();
	
	List<Item> findAllByOrderByVehicleaddeddateDesc();
}