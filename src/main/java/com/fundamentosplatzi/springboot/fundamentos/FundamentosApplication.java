package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;

	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
								  MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties,
								  UserPojo userPojo, UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {

		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplosAnteriores();
		saveUsersInDataBase();
	}

	private void saveUsersInDataBase(){
		User user1 = new User("Robert", "robert@email.com", LocalDate.of(2023, 03, 20));
		User user2 = new User("Juan", "juan@email.com", LocalDate.of(2023, 05, 21));
		User user3 = new User("Daniela", "daniela@email.com", LocalDate.of(2023, 05, 01));
		User user4 = new User("user4", "user4@email.com", LocalDate.of(2023, 06, 11));
		User user5 = new User("user5", "user5@email.com", LocalDate.of(2023, 05, 05));
		User user6 = new User("user6", "user6@email.com", LocalDate.of(2023, 04, 07));
		User user7 = new User("user7", "user7@email.com", LocalDate.of(2023, 03, 04));
		User user8 = new User("user8", "user8@email.com", LocalDate.of(2023, 02, 22));
		User user9 = new User("user9", "user9@email.com", LocalDate.of(2023, 01, 29));
		User user10 = new User("user10", "user10@email.com", LocalDate.of(2023, 12, 28));
		User user11 = new User("user11", "user11@email.com", LocalDate.of(2023, 11, 23));
		User user12 = new User("user12", "user12@email.com", LocalDate.of(2023, 10, 03));
		List<User> userList = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12);
		userList.stream().forEach(userRepository::save);
	}


	private void ejemplosAnteriores(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.toString());
		try {
			int value = 10/0;
			LOGGER.debug("El valor es" + value);
		} catch (Exception e){
			LOGGER.error("Esto es un error del aplicativo " + e.getStackTrace());
		}
	}
}
