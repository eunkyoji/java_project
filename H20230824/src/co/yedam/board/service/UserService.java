package co.yedam.board.service;

import co.yedam.board.vo.User;

public interface UserService {
	public User checkLogin(User user);
	public User checkId(User user);
	public boolean setPassword(User user);
	public boolean userSave();
}
