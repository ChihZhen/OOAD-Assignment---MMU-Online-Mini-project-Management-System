package com.example.ooad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.example.ooad.controller.CreateUserController;
import com.example.ooad.controller.LoginController;
import com.example.ooad.model.UserModel;
// import com.example.ooad.repository.StudentRepository;
import com.example.ooad.repository.StudentRepository;

import java.awt.*;

@SpringBootApplication
public class OoadApplication {

	@Autowired(required = false)
	private static UserModel loginUser;

	public OoadApplication(CreateUserController createUserController) {
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
		// if (this.loginUser != null) {
		// System.out.println("login user function-------------->" +
		// loginUser.getFullName());
		// }

		return loginUser;
	}

	public static void setLoginUser(UserModel user) {
		System.out.println("user--------------->" + user.getFullName());
		loginUser = user;
		// System.out.println("login user-------------->" + this.loginUser);
	}
}
