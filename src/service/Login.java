package service;

import dto.Customer;

public interface Login {
	public void login(String id, String password);
	public void logout(String id);
	public void signUp(Customer customer);
}
