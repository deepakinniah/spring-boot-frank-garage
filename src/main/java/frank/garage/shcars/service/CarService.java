package frank.garage.shcars.service;
//Required imports

import java.util.List;
import java.util.Optional;

import frank.garage.shcars.Car;

public interface CarService {

    List<Car> getAllCars();
    
    void loadAllCars();
    
    List<Car> getAllByOrderByVehicleId();
    
    Optional<Car> findById(String id);
    
    Car findByVehicleId(long vehicleId);

    List<Car> findByWarehouseId(long warehouseId);
    
    List<Car> findByVehiclemakeOrVehiclemodel(String vehiclemakeOrvehiclemodel);
    
    List<Car> findAllByOrderByVehicleprice();
    
    List<Car> findAllByOrderByVehiclepriceDesc();
    
    List<Car> findAllByVehiclelicensedTrue();

    List<Car> findAllByOrderByVehicleaddeddateDesc();

    void saveOrUpdateCar(Car car);
    
    void saveAllCars(List<Car> cars);

    void deleteCar(String id);

}