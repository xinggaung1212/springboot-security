package com.atguigu.security.java8;

import org.junit.Test;

import java.util.*;

public class TestLamdba {
    @Test
    public void test01(){
        Comparator<Integer> com=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> ts=new TreeSet<Integer>(com);
    }
    @Test
    public void test02(){
        Comparator<Integer> com=(x,y)->Integer.compare(x,y);
        TreeSet<Integer> ts=new TreeSet<Integer>(com);
    }
    List<Employee> employees= Arrays.asList(
            new Employee("zhangsan",18,6666.99),
            new Employee("lisi",38,33333.33),
            new Employee("wangwu",50,9999.99),
            new Employee("lill",16,77777.99),
            new Employee("zhaoba",19,8888.99),
            new Employee("xujiu",8,5555.99)
    );
    @Test
    public void test03(){
        List<Employee> emps=fiterempley(employees);
        System.out.println(emps);
    }
    public List<Employee> fiterempley(List<Employee> lists){
        List<Employee> emps=new ArrayList<>();
        for(Employee emp:lists){
            if(emp.getAge()>35){
                emps.add(emp);
            }

        }
        return emps;
    }
    @Test
    public void test04(){
        List<Employee> emps=fiterempley(employees);
        System.out.println(emps);
    }
}
