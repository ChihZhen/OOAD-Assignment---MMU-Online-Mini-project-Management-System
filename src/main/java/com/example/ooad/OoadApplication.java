package com.example.ooad;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.example.ooad.controller.LoginController;

import java.awt.*;

@SpringBootApplication
public class OoadApplication {

	public OoadApplication(LoginController loginController) {
		loginController.show();
	}

	public static void main(String[] args) {
		var ctx = new SpringApplicationBuilder(OoadApplication.class)
				.headless(false).run(args);
		// EventQueue.invokeLater(() -> {

		// var ex = ctx.getBean(OoadApplication.class);
		// });
		// if (!ctx.isRunning()) {
		// ctx.;
		// }
		// while (true) {
		// if (!ctx.isRunning()) {
		// ctx.close();
		// }
		// }

	}

}
