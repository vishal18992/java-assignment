package com.miit.ass3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MainApp {

    public static Optional<Employee> findSecondHighestEmpBySalary(){
        Optional<Employee> emp = null;
        Session session = null;
        try( SessionFactory sessionFactory = new Configuration().configure("hibernate_cgf.xml")
                .buildSessionFactory()) {
            session = sessionFactory.openSession();
            session.beginTransaction();
            List<Employee> employees = session.createQuery("from Employee").list();
            emp = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return emp;
    }

    public static void main(String[] args) {
        Optional<Employee> secondHighestEmployee = MainApp.findSecondHighestEmpBySalary();
        System.out.println("Second Highest Employee " + secondHighestEmployee.get().getSalary());
    }


    public static void createEmployees(){
        Session session = null;
        try {
            SessionFactory sessionFactory = new Configuration().configure("hibernate_cgf.xml")
                    .buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();

            Department departmentIt = new Department(1, "IT");
            Department departmentAccount = new Department(2, "Account");
            Department departmentSales = new Department(3, "Sales");
            Department departmentCEO = new Department(4, "CEO");

            Employee employee100 = new Employee(100, "John", "White", 12000, "Senior");
            Employee employee101 = new Employee(101, "Mary", "Danner", 80000, "junior");
            Employee employee102 = new Employee(102, "Ann", "Lynn", 140000, "Semisenior");
            Employee employee103 = new Employee(103, "Peter", "O'connor", 130000, "Senior");
            Employee employee106 = new Employee(106, "Sue", "Sanchez", 110000, "Junior");
            Employee employee107 = new Employee(107, "Marta", "Doe", 180000, "Senior");
            Employee employee109 = new Employee(109, "Ann", "Danner", 90000, "Senior");
            Employee employee110 = new Employee(100, "Simon", "Yang", 250000, "Senior");
            Employee employee111 = new Employee(111, "Juan", "Graue", 37000, "Junior");

            employee100.setManager(true);
            employee100.setManager_id(employee103);
            employee100.setDepartment_id(departmentIt);

            employee101.setManager(true);
            employee101.setManager_id(employee109);
            employee101.setDepartment_id(departmentAccount);


            employee102.setManager(true);
            employee102.setManager_id(employee107);
            employee102.setDepartment_id(departmentSales);

            employee103.setManager(true);
            employee103.setManager_id(employee110);
            employee103.setDepartment_id(departmentIt);

            employee106.setManager(true);
            employee106.setManager_id(employee107);
            employee106.setDepartment_id(departmentSales);

            employee107.setManager(true);
            employee107.setManager_id(employee110);
            employee107.setDepartment_id(departmentSales);

            employee109.setManager(true);
            employee109.setManager_id(employee110);
            employee109.setDepartment_id(departmentAccount);

            employee110.setManager(true);
            employee110.setManager_id(null);
            employee110.setDepartment_id(departmentCEO);

            employee111.setManager(true);
            employee111.setManager_id(employee102);
            employee111.setDepartment_id(departmentSales);


            session.save(departmentIt);
            session.save(departmentAccount);
            session.save(departmentSales);
            session.save(departmentCEO);

            session.save(employee100);
            session.save(employee101);
            session.save(employee102);
            session.save(employee103);
            session.save(employee106);
            session.save(employee107);
            session.save(employee109);
            session.save(employee110);
            session.save(employee111);
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {
            System.out.println("finally!!!!!");
        }
    }
}
