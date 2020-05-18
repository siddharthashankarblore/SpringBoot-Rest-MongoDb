package com.mongodb.starter;

import com.mongodb.starter.models.Address;
import com.mongodb.starter.models.Car;
import com.mongodb.starter.models.Person;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;
/* 
 * author : Rajesh Thokala
 * date : 17/05/2020
 */
@Component
class TestHelper {

    Person getRaj() {
        return new Person().setFirstName("Rajesh")
                           .setLastName("Thokala")
                           .setAddress(new Address().setCity("Tirupati")
                                                    .setCountry("India")
                                                    .setNumber(1)
                                                    .setPostcode("517502")
                                                    .setStreet("The Best Street"))
                           .setAge(28)
                           .setInsurance(true)
                           .setCars(asList(new Car().setBrand("Hundai")
                                                    .setMaxSpeedKmH(339f)
                                                    .setModel("Active i20")));
    }

    Person getPawan() {
        return new Person().setFirstName("Pawan")
                           .setLastName("Kalyan")
                           .setAddress(new Address().setCity("Vizag")
                                                    .setCountry("India")
                                                    .setNumber(2)
                                                    .setPostcode("517130")
                                                    .setStreet("Another Street"))
                           .setAge(27)
                           .setInsurance(false)
                           .setCars(asList(new Car().setBrand("Mercedes").setMaxSpeedKmH(355f).setModel("Project One")));
    }

    List<Person> getListRajPawan() {
        return asList(getRaj(), getPawan());
    }
}
