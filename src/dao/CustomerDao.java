package dao;

import dto.Customer;

public interface CustomerDao {
	/**
	 * ȸ������
	 * : ȸ�� ������ �޾� ȸ�� ����Ʈ�� ����
	 * @param: Customer
	 * @return: Customer
	 * */
	public Customer signup(Customer customer);

	/**
	 * �α���
	 * : �Է¹��� �α��� ������ ȸ�� ������ ���� ���� ��� �α���
	 * @param: Customer
	 * @return: Customer
	 * */
	public Customer login(Customer customer);

	/**
	 * ���̵� ã��
	 * : ȸ�� ������ �Է¹��� ���̵�� ��ġ�ϴ� ������ ���� ��� ����
	 * @param: String id
	 * @return: Customer
	 * */
	public Customer findById(String id);
}
