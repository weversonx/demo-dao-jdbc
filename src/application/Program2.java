package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();		
		System.out.println("\n=== TEST 1: department insert =====");
		Department newDepartment = new Department(null, "Food");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		
		System.out.println("=== TEST 2: department findById =====");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		
		System.out.println("\n=== TEST 3: department update =====");
		department = departmentDao.findById(5);
		department.setName("Ifood");
		departmentDao.update(department);
		System.out.println("update completed!");
		
		
		System.out.println("\n=== TEST 4: department delete =====");
		System.out.println("Enter id for delete test");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		List<Department> list = departmentDao.findAll();
		System.out.println("\n=== TEST 5: seller findAll =====");
		list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
	}


}
