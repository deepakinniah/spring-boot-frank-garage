package frank.garage.shcars.springbootfrankgarage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import frank.garage.shcars.repository.CarRepository;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringBootFrankGarageApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private CarRepository carRepository;

	@BeforeEach
	public void deleteAllBeforeTests() throws Exception {
		carRepository.deleteAll();
	}

	@Test
	public void shouldReturnRepositoryIndex() throws Exception {

		mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
			.andExpect(jsonPath("$._links.cars").exists())
	}

	@Test
	public void shouldCreateEntity() throws Exception {

		mockMvc.perform(post("/cars").content(
				"{\"warehouseId\":\"1\",\"warehousename\":\"Warehouse A\",\"lattitude\":\"47.13111\",\"longitude\":\"-61.54801\",\"location\":\"West wing\",\"vehicleId\":2,\"vehiclemake\":\"Chevrolet\",\"vehiclemodel\":\"Chevrolet\",\"vehicleyear\":2004,\"vehicleprice\":20019.64,\"vehiclelicensed\":true,\"vehicleaddeddate\":\"2018-01-27\"}")).andExpect(
						status().isCreated()).andExpect(
								header().string("Location", containsString("cars")));
	}
}