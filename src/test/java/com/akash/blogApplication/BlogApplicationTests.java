package com.akash.blogApplication;

import com.akash.blogApplication.repositories.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {

   @Autowired
	private UserRepo userRepo;
   //Implementation class is created Dynamically.

	@Test
	void contextLoads() {
	}
	@Test
	public void repoTest()
	{
		String className= this.userRepo.getClass().getName();
		String packName= this.userRepo.getClass().getPackageName();
		System.out.printf("ClassName : %s PackageName: %s",className,packName);
	}

}
