package com.example.ooad;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.example.ooad.controller.CreateUserController;
import com.example.ooad.controller.LoginController;
import com.example.ooad.model.UserModel;

import java.awt.*;

@SpringBootApplication
public class OoadApplication {

	private static UserModel loginUser;

	public OoadApplication(LoginController loginController, CreateUserController createUserController) {
		// loginController.show();
		// createUserController.show();

	}
	// public void show() {
	// createUserController.show();
	// }

	public static void main(String[] args) {

		var ctx = new SpringApplicationBuilder(OoadApplication.class)
				.headless(false).run(args);
		// EventQueue.invokeLater(() -> {

		// var ex = ctx.getBean(OoadApplication.class);
		// ex.
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

	public static UserModel getLoginUser() {
		return loginUser;
	}

	public static void setLoginUser(UserModel user) {
		loginUser = user;
	}
}
