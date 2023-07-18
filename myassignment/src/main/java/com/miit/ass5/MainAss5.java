package com.miit.ass5;

import com.miit.ass3.Department;
import com.miit.ass3.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainAss5 {

    public static void main(String[] args) {
        Map<String, Float> highestSalaryBydepartment;
        List<Employee> lastfiveRow = new ArrayList<>();
        try {
            System.out.println("Final Result:- " + MainAss5.getHighestSalaryByDepartment());
            long totalEmp = getEmployees().size();
            getEmployees().stream().skip(totalEmp-5).collect(Collectors.toList()).forEach((emp) -> {
                lastfiveRow.add(emp);
            });
            System.out.println("Last 5 Rows of a Result Set :- " + lastfiveRow);
            System.out.println("The Second Highest Row of a Result Set " + getEmployees().stream().skip(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static List<Employee> getEmployees() throws Exception{
        Session session = null;
        SessionFactory factory = getSession();
        session = factory.openSession();
        List<Employee> employees = new ArrayList<>();
        employees = session.createQuery("from Employee").getResultList();
        session.close();
        factory.close();
        return employees;
    }

    public static Map<String, Float> getHighestSalaryByDepartment(){
        Map<String, Float> departmentListMap = new HashMap<>();
        try {
            getSalaryByDepartment().forEach((department, employees) -> {
                Optional<Employee> emp = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst();
                if(emp.isPresent()){
                    departmentListMap.put(department.getName(), emp.get().getSalary());
                }
                System.out.println("Department :- " + department.getName() + " Employees :- " + emp);
            });
        } catch (Exception e) {
            System.out.println(e);
        }
        return departmentListMap;
    }
    public static Map<Department, List<Employee>> getSalaryByDepartment() throws Exception{
        Map<Department, List<Employee>> departmentByEmployees =
                getEmployees().stream().collect(Collectors.groupingBy((Function<? super Employee, ? extends Department>) Employee::getDepartment_id));
        System.out.println("departmentByEmployees" + departmentByEmployees);
        return departmentByEmployees;
    }

    public static SessionFactory getSession() throws Exception{
        SessionFactory sessionFactory = new Configuration().configure("hibernate_cgf.xml")
                .buildSessionFactory();
        return sessionFactory;
    }
}
