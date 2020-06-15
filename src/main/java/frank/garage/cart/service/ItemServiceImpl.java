package frank.garage.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import frank.garage.cart.Item;
import frank.garage.cart.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;
    

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
    
    @Override
    public List<Item> getAllByOrderByVehicleId() {
        return itemRepository.getAllByOrderByVehicleId();
    }
    
    @Override
    public Item findByVehicleId(long vehicleId) {
        return itemRepository.findByVehicleId(vehicleId);
    }

    @Override
    public List<Item> findByWarehouseId(long warehouseId) {
        return itemRepository.findByWarehouseId(warehouseId);
    }
    
    @Override
    public List<Item> findAllByOrderByVehicleprice() {
        return itemRepository.findAllByOrderByVehicleprice();
    }
    
    @Override
    public List<Item> findAllByOrderByVehiclepriceDesc() {
        return itemRepository.findAllByOrderByVehiclepriceDesc();
    }
    
    @Override
    public List<Item> findAllByVehiclelicensedTrue() {
        return itemRepository.findAllByVehiclelicensedTrue();
    }
    
    @Override
    public List<Item> findAllByOrderByVehicleaddeddateDesc() {
        return itemRepository.findAllByOrderByVehicleaddeddateDesc();
    }

    @Override
    public void saveOrUpdateCar(Item item) {
    	itemRepository.save(item);
    }
    
    @Override
    public void saveAllCars(List<Item> items) {
    	for(Item item:items)
    		saveOrUpdateCar(item);
    }

    @Override
    public void deleteItem(String id) {
    	itemRepository.deleteById(id);
    }
}