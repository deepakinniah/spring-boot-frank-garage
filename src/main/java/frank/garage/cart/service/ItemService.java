package frank.garage.cart.service;
//Required imports

import java.util.List;

import frank.garage.cart.Item;

public interface ItemService {

    List<Item> getAllItems();
    
    List<Item> getAllByOrderByVehicleId();
    
    Item findByVehicleId(long vehicleId);

    List<Item> findByWarehouseId(long warehouseId);
    
    List<Item> findAllByOrderByVehicleprice();
    
    List<Item> findAllByOrderByVehiclepriceDesc();
    
    List<Item> findAllByVehiclelicensedTrue();

    List<Item> findAllByOrderByVehicleaddeddateDesc();

    void saveOrUpdateCar(Item item);
    
    void saveAllCars(List<Item> items);

    void deleteItem(String id);

}