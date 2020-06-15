package frank.garage.shcars.controller;

import java.util.List;
import java.util.Optional;

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

import frank.garage.shcars.Car;
import frank.garage.shcars.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;
    
    @GetMapping(value = "/")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }
    
    @GetMapping(value = "/getbyid/{id}")
    public Optional<Car> findById(@PathVariable("id") String id) {
        return carService.findById(id);
    }

    @GetMapping(value = "/orderByVehicleId")
    public List<Car> getAllByOrderByVehicleId() {
        return carService.getAllByOrderByVehicleId();
    }
    
    @GetMapping(value = "/findModelOrMake/{vehiclemakeOrvehiclemodel}")
    public List<Car> findByVehiclemakeOrVehiclemodel(@PathVariable("vehiclemakeOrvehiclemodel") String vehiclemakeOrvehiclemodel) {
        return carService.findByVehiclemakeOrVehiclemodel(vehiclemakeOrvehiclemodel);
    }
    
    @GetMapping(value = "/{vehicleId}")
    public Car findByCarId(@PathVariable("vehicleId") Long vehicleId) {
        return carService.findByVehicleId(vehicleId);
    }

    @GetMapping(value = "/wh/{warehouseId}")
    public List<Car> findByWarehouseId(@PathVariable("warehouseId") Long warehouseId) {
        return carService.findByWarehouseId(warehouseId);
    }
    
    @GetMapping(value = "/orderByPrice")
    public List<Car> findAllByOrderByVehicleprice() {
        return carService.findAllByOrderByVehicleprice();
    }
    
    @GetMapping(value = "/orderByPriceDesc")
    public List<Car> findAllByOrderByVehiclepriceDesc() {
        return carService.findAllByOrderByVehiclepriceDesc();
    }
    
    @GetMapping(value = "/filterByLicensed")
    public List<Car> findAllByVehiclelicensedTrue() {
        return carService.findAllByVehiclelicensedTrue();
    }

    @GetMapping(value = "/orderByDateDesc")
    public List<Car> findAllByOrderByVehicleaddeddateDesc() {
        return carService.findAllByOrderByVehicleaddeddateDesc();
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> saveOrUpdateCar(@RequestBody Car car) {
    	carService.saveOrUpdateCar(car);
    	return new ResponseEntity("{\"status\":\"Car added successfully\"}", HttpStatus.OK);
    }
    
    @PostMapping(value = "/saveAll")
    public ResponseEntity<?> saveAllCars(@RequestBody List<Car> cars) {
    	carService.saveAllCars(cars);
        return new ResponseEntity("{\"status\":\"Cars added successfully\"}", HttpStatus.OK);
    }
    
    @GetMapping(value = "/loadAllCars")
    public ResponseEntity<?> loadAllCars() {
    	carService.loadAllCars();
    	return new ResponseEntity("{\"status\":\"Cars added successfully\"}", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{vehicleId}")
    public void deleteCar(@PathVariable("vehicleId") Long vehicleid) {
    	carService.deleteCar(carService.findByVehicleId(vehicleid).getId());
    }

}