package com.qa.dfe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.qa.dfe.rest.DFEController;
import com.qa.dfe.service.DFEService;
import com.qa.dfe.service.DFEServiceList;

@SpringBootApplication
public class SpringDfeApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDfeApplication.class, args);

		DFEController controllerBean = context.getBean(DFEController.class);

		System.out.println(controllerBean);

		DFEController myController = new DFEController(new DFEServiceList());

		System.out.println(new DFEServiceList() instanceof DFEService);
	}

}
