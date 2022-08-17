package com.ty.cart;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//       Product p = new Product();
//       p.id=15;
//       p.name="Airtel broad";
//       p.type="Internet";
//       p.cost=50026;
       Product pr=new Product();
       ProductDao dao = new ProductDao();
       //Product p3=dao.findById(15);
      //dao.displayDetails(p3);
       //dao.saveData(p);
//       dao.updateData(pr);
//       pr.id=10;
//       pr.name="Flower pot";
//       pr.type="nature";
//       pr.cost=490;
//        System.out.println("Id is " + p3.id);
//		System.out.println("name is " + p3.name);
//		System.out.println("type is " + p3.type);
//		System.out.println("Cost is " + p3.cost);
       List<Product> al = dao.disp();
       System.out.println(al);
       
      
       
 
	}

}
