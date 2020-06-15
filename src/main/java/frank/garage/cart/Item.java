package frank.garage.cart;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "cart")
public class Item {
    @Id
    private String id;
    
    private String warehousename;
    private long warehouseId;
    private float lattitude;
    private float longitude;
    private String location;
    
    private long vehicleId;
    private String vehiclemake;
    private String vehiclemodel;
    private String vehicleyear;
    private float vehicleprice;
    private boolean vehiclelicensed;
    
	@JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate vehicleaddeddate;

    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWarehousename() {
		return warehousename;
	}
	public void setWarehousename(String warehousename) {
		this.warehousename = warehousename;
	}
	public long getWarehouseId() {
		return warehouseId;
	}
	public void setWarehouseId(long warehouseId) {
		this.warehouseId = warehouseId;
	}
	public float getLattitude() {
		return lattitude;
	}
	public void setLattitude(float lattitude) {
		this.lattitude = lattitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehiclemake() {
		return vehiclemake;
	}
	public void setVehiclemake(String vehiclemake) {
		this.vehiclemake = vehiclemake;
	}
	public String getVehiclemodel() {
		return vehiclemodel;
	}
	public void setVehiclemodel(String vehiclemodel) {
		this.vehiclemodel = vehiclemodel;
	}
	public String getVehicleyear() {
		return vehicleyear;
	}
	public void setVehicleyear(String vehicleyear) {
		this.vehicleyear = vehicleyear;
	}
	public float getVehicleprice() {
		return vehicleprice;
	}
	public void setVehicleprice(float vehicleprice) {
		this.vehicleprice = vehicleprice;
	}
	public boolean isVehiclelicensed() {
		return vehiclelicensed;
	}
	public void setVehiclelicensed(boolean vehiclelicensed) {
		this.vehiclelicensed = vehiclelicensed;
	}
	public LocalDate getVehicleaddeddate() {
		return vehicleaddeddate;
	}
	public void setVehicleaddeddate(LocalDate vehicleaddeddate) {
		this.vehicleaddeddate = vehicleaddeddate;
	}
   
}