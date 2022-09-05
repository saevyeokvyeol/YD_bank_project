package service;

import dto.Customer;
import exception.DiscrepancyException;
import exception.DuplicationException;

public interface CustomerService {
	/**
	 * ȸ������
	 * : ȸ�� ������ �޾� ȸ�� ����Ʈ�� ����
	 * @param: Customer, String checkPwd
	 * @return: Customer
	 * */
	public Customer signup(Customer customer, String checkPwd) throws DuplicationException, DiscrepancyException;

	/**
	 * �α���
	 * : �Է¹��� �α��� ������ ȸ�� ������ ���� ���� ��� �α���
	 * @param: Customer
	 * @return: Customer
	 * */
	public Customer login(Customer customer);
}
