package com.example.ooad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.example.ooad.controller.AdminCreateUserController;
import com.example.ooad.controller.LoginController;
import com.example.ooad.entity.User;
// import com.example.ooad.repository.StudentRepository;
import com.example.ooad.repository.StudentRepository;

import java.awt.*;

@SpringBootApplication
public class OoadApplication {

	@Autowired(required = false)
	private static User loginUser;

	public OoadApplication(LoginController loginController) {
		loginController.show();
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

	public static User getLoginUser() {
		// if (this.loginUser != null) {
		// System.out.println("login user function-------------->" +
		// loginUser.getFullName());
		// }

		return loginUser;
	}

	// @Autowired(required = false)
	public static void setLoginUser(User user) {
		// System.out.println("user--------------->" + user.getFullName());
		loginUser = user;
		// System.out.println("login user-------------->" + this.loginUser);
	}
}
