package com.atguigu.security.java8;

public class FilterEmployeebyAge implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee e) {
        return e.getAge()>=35;
    }
}
