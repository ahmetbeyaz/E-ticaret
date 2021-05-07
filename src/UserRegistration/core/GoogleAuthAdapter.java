package UserRegistration.core;

import UserRegistration.GoogleAuth.GoogleAuth;

public class GoogleAuthAdapter implements GoogleAuthService {

	@Override
	public void sign(String email, String message) {
		GoogleAuth googleAuth = new GoogleAuth();
		googleAuth.sign(email, message);

	}

}
