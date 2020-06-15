package frank.garage.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import frank.garage.cart.Item;
import frank.garage.cart.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;
    
    @GetMapping(value = "/")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping(value = "/orderByVehicleId")
    public List<Item> getAllByOrderByVehicleId() {
        return itemService.getAllByOrderByVehicleId();
    }
    
    @GetMapping(value = "/{vehicleId}")
    public Item findByCarId(@PathVariable("vehicleId") Long vehicleId) {
        return itemService.findByVehicleId(vehicleId);
    }

    @GetMapping(value = "/wh/{warehouseId}")
    public List<Item> findByWarehouseId(@PathVariable("warehouseId") Long warehouseId) {
        return itemService.findByWarehouseId(warehouseId);
    }
    
    @GetMapping(value = "/orderByPrice")
    public List<Item> findAllByOrderByVehicleprice() {
        return itemService.findAllByOrderByVehicleprice();
    }
    
    @GetMapping(value = "/orderByPriceDesc")
    public List<Item> findAllByOrderByVehiclepriceDesc() {
        return itemService.findAllByOrderByVehiclepriceDesc();
    }
    
    @GetMapping(value = "/filterByLicensed")
    public List<Item> findAllByVehiclelicensedTrue() {
        return itemService.findAllByVehiclelicensedTrue();
    }

    @GetMapping(value = "/orderByDateDesc")
    public List<Item> findAllByOrderByVehicleaddeddateDesc() {
        return itemService.findAllByOrderByVehicleaddeddateDesc();
    }
    
    /*@GetMapping(value = "/update/{vehicleId}")
    public Car updateCar(@PathVariable("warehouseId") Long vehicleId) {
    	itemService.updateCar(vehicleId);
    	return itemService.findByCarId(vehicleId);
    }*/

    @PostMapping(value = "/")
    public ResponseEntity<?> saveOrUpdateItem(@RequestBody Item item) {
    	itemService.saveOrUpdateCar(item);
        return new ResponseEntity("Car added successfully", HttpStatus.OK);
    }
    
    @PostMapping(value = "/saveAll")
    public ResponseEntity<?> saveAllCars(@RequestBody List<Item> items) {
    	itemService.saveAllCars(items);
        return new ResponseEntity("Cars added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{vehicleId}")
    public void deleteCar(@PathVariable("vehicleId") Long vehicleid) {
    	itemService.deleteItem(itemService.findByVehicleId(vehicleid).getId());
    	 //return new ResponseEntity("Car deleted successfully", HttpStatus.OK);
    }

}