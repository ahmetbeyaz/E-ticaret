package UserRegistration.dataAcces.concretes;

import java.util.List;

import UserRegistration.dataAcces.abstracts.UserDao;
import UserRegistration.entities.concretes.User;

public class LoginUserDao implements UserDao {
	private List<User> users;

	public LoginUserDao(List<User> users) {
		this.users = users;
	}

	@Override
	public void add(User user) {
		users.add(user);
		System.out.println("Kullanici eklendi::" + user.getEmail());

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getByEmail(String mail) {
		for (User user : users) {
			if (user.getEmail().equals(mail)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		// Veritabani isletim yeri
		// TODO Auto-generated method stub
		return null;
	}

}
