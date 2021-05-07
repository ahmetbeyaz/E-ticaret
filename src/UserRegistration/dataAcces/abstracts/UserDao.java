package UserRegistration.dataAcces.abstracts;

import java.util.List;

import UserRegistration.entities.concretes.User;

public interface UserDao {
	void add(User user);

	void update(User user);

	void delete(User user);

	User getByEmail(String mail);

	List<User> getAll();

}
