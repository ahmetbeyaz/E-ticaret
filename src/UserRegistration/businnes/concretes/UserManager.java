package UserRegistration.businnes.concretes;

import java.util.Scanner;
import java.util.regex.Pattern;

import UserRegistration.businnes.abstracts.UserService;
import UserRegistration.core.GoogleAuthService;
import UserRegistration.dataAcces.abstracts.UserDao;
import UserRegistration.entities.concretes.User;

public class UserManager implements UserService {
	private UserDao userdao;
	private GoogleAuthService googleAuthService;

	private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

	public static boolean isEmailValid(String emailInput) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(emailInput).find();
	}

	public UserManager(UserDao userdao, GoogleAuthService googleAuthService) {
		this.userdao = userdao;
		this.googleAuthService = googleAuthService;
	}

	@Override
	public void register(User user) {
		if (user.getFirstName().length() <= 2 && user.getLastName().length() <= 2) {
			System.out.println("Adiniz ve soyadiniz en az uc karakter sayidan olusmalidir");
			return;
		}
		if (user.getPassword().length() <= 6) {
			System.out.println("Parolaniz en az 6 karakterden olusmalidir");
			return;
		}
		if (userdao.getByEmail(user.getEmail()) != null) {
			System.out.println("Bu kullanýcý zaten mevcut");
			return;
		}
		if (!(isEmailValid(user.getEmail()))) {
			System.out.println("Lutfen email adresinizi kontrol ediniz");
			return;
		} else {
			System.out.println("Sistme dogrulama kodu gonderilmistir.");
		}
		userdao.add(user);

	}

	@Override
	public void verify(User user) {
		// Dogrulama Kodu random olarak atandi Kaynak:Discord
		int realCode = (int) (100 * Math.random() * 1000);
		Scanner scan = new Scanner(System.in);
		System.out.println("Dogrulama kodunuz=" + realCode);
		System.out.println("Gönderilen dogrulama kodunu giriniz: ");
		int verify = scan.nextInt();
		if (realCode == verify) {
			System.out.println("Dogrulama basarili");
		} else {
			System.out.println("Lutfen Dogrulama Kodunu Dogru Giriniz:" + realCode);
		}

	}

	@Override
	public void login(User user) {
		if ((user.getEmail().equals(user) == user.getPassword().equals(user))) {
			System.out.println(user.getFirstName() + "       Hosgeldiniz");
		}

	}

	@Override
	public User getByEmail(String mail) {
		// TODO Auto-generated method stub
		return userdao.getByEmail(mail);
	}

	@Override
	public void signUpWithGoogle(String email, String password) {
		// TODO Auto-generated method stub
		googleAuthService.sign(email, password);
		User user = new User(5, "Huseyin", "Lale", email, password);
		user.setEmail(email);

	}

}
