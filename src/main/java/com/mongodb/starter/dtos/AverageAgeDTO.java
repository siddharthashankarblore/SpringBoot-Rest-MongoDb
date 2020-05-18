package com.mongodb.starter.dtos;

import java.util.Objects;
/* 
 * author : Rajesh Thokala
 * date : 17/05/2020
 */
public class AverageAgeDTO {

    private double averageAge;

    public double getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(double averageAge) {
        this.averageAge = averageAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AverageAgeDTO that = (AverageAgeDTO) o;
        return Double.compare(that.averageAge, averageAge) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(averageAge);
    }
}
