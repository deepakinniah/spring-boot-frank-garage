package frank.garage.shcars.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import frank.garage.shcars.Car;
import frank.garage.shcars.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;
    

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
    
    @Override
    public List<Car> getAllByOrderByVehicleId() {
        return carRepository.getAllByOrderByVehicleId();
    }
    
    @Override
    public Optional<Car> findById(String id) {
        return carRepository.findById(id);
    }
    
    @Override
    public Car findByVehicleId(long vehicleId) {
        return carRepository.findByVehicleId(vehicleId);
    }

    @Override
    public List<Car> findByWarehouseId(long warehouseId) {
        return carRepository.findByWarehouseId(warehouseId);
    }

    @Override
    public List<Car> findByVehiclemakeOrVehiclemodel(String vehiclemakeOrvehiclemodel) {
        return carRepository.findByVehiclemakeOrVehiclemodel(vehiclemakeOrvehiclemodel);
    }
    
    @Override
    public List<Car> findAllByOrderByVehicleprice() {
        return carRepository.findAllByOrderByVehicleprice();
    }
    
    @Override
    public List<Car> findAllByOrderByVehiclepriceDesc() {
        return carRepository.findAllByOrderByVehiclepriceDesc();
    }
    
    @Override
    public List<Car> findAllByVehiclelicensedTrue() {
        return carRepository.findAllByVehiclelicensedTrue();
    }
    
    @Override
    public List<Car> findAllByOrderByVehicleaddeddateDesc() {
        return carRepository.findAllByOrderByVehicleaddeddateDesc();
    }

    @Override
    public void saveOrUpdateCar(Car car) {
    	carRepository.save(car);
    }
    
    @Override
    public void loadAllCars(){
    	ObjectMapper objectMapper = new ObjectMapper();
    	List<Car> cars = new ArrayList<Car>();
    	InputStream resource;
    	String employees;
		try {
			resource = new ClassPathResource("data.json").getInputStream();
    		    try ( BufferedReader reader = new BufferedReader(
    		      new InputStreamReader(resource)) ) {
    		        employees = reader.lines()
    		          .collect(Collectors.joining());
    		    }
    	
			cars = objectMapper.readValue(employees, new TypeReference<List<Car>>(){});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	for(Car car:cars){
    			saveOrUpdateCar(car);
    	}
    }
    
    @Override
    public void saveAllCars(List<Car> cars) {
    	for(Car car:cars)
    		saveOrUpdateCar(car);
    }

    @Override
    public void deleteCar(String id) {
    	carRepository.deleteById(id);
    }
}