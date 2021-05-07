package UserRegistration.businnes.abstracts;

import UserRegistration.entities.concretes.User;

public interface UserService {
	void register(User user);

	void verify(User user);

	void login(User user);

	void signUpWithGoogle(String email, String password);

	User getByEmail(String mail);

}
