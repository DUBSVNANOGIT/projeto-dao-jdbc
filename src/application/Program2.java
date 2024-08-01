package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Department> list = new ArrayList<>();

        DepartmentDao departmentDao = DaoFactory.createDeparmentDao();

        System.out.println("\n === TEST 1: department insert ===");
        Department department = new Department(null, "Ferramentas");
//        departmentDao.insert(department);
//        System.out.println("Inserted! New Id = " + department.getId());

        System.out.println("\n === TEST 2: department findById ===");
        Department newDep = departmentDao.findById(2);
        System.out.println(newDep);

        System.out.println("\n === TEST 3: seller findAll ===");
        list = departmentDao.findAll();
        for (Department dep: list) {
            System.out.println(dep);
        }

        System.out.println("\n === TEST 3: department update ===");
        department = departmentDao.findById(7);
        department.setName("Obras");
        departmentDao.update(department);
        System.out.println("Update Completed! ");

        System.out.println("\n === TEST 4: department delete ===");
        System.out.println ("Enter id for delete: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();

    }
}
