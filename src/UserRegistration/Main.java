package UserRegistration;

import java.util.ArrayList;

import UserRegistration.businnes.abstracts.UserService;
import UserRegistration.businnes.concretes.UserManager;
import UserRegistration.core.GoogleAuthAdapter;
import UserRegistration.dataAcces.concretes.LoginUserDao;
import UserRegistration.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<User> users = new ArrayList<>();
		UserService userService = new UserManager(new LoginUserDao(users), new GoogleAuthAdapter());
		User user = new User(1, "Ahmet", "Beyaz", "ahmetbeyaz1285", "1234567");
		userService.register(user);
		userService.verify(user);
		userService.login(user);
		users.add(user);
		userService.signUpWithGoogle("beyazahmet2584@gmail.com", "12345678");

	}

}
