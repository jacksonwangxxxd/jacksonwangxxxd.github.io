import java.util.ArrayList;

public class User {
	
	private ArrayList<String> username;
	private ArrayList<String> password;
	private ArrayList<String> userKind;

	public User() {
		username = new ArrayList<String>();
		password = new ArrayList<String>();
		userKind = new ArrayList<String>();
	}

	public void add(String uk, String name, String pw) throws  PasswordError, UserError {
		if (name.length() == 0)
			throw new UserError("請填寫名稱");
		if (pw.length() != 10)
			throw new PasswordError("密碼須為10個字");
		userKind.add(uk);
		username.add(name);
		password.add(pw);
		return;
	}
	public void checkUserKind() throws UserKindError{
		
	}
	public void checkUserExist(String name) throws UserError {
		
		if (username.contains(name))
			return;
		throw new UserError("查無使用者");
	}

	public void checkPassword(String name, String PW) throws PasswordError {
		int id = username.indexOf(name);
		if (password.get(id).equals(PW))
			return;
		throw new PasswordError("密碼錯誤");
	}
}

class UserError extends Exception {
	public UserError(String Error) {
		super(Error);
	}
}

class PasswordError extends Exception {
	public PasswordError(String Error) {
		super(Error);
	}
}
class UserKindError extends Exception{
	public UserKindError(String Error) {
		super(Error);
	}
}
