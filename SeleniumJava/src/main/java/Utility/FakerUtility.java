package Utility;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;

public class FakerUtility {
	public String getFakeFirstName() {

		Faker faker = new Faker();

		String text =faker.name().fullName();

		return text;

	}
	public String getFakeLastName() {

		Faker faker = new Faker();

		Address address = faker.address();

		String text = address.lastName();

		return text;
	}

public String getFakeCityName() {

		Faker faker = new Faker();

		Address address = faker.address();

		String text = address.cityName();

		return text;
	}
}
