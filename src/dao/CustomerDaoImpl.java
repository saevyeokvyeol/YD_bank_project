package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Customer;

public class CustomerDaoImpl implements CustomerDao {
	private List<Customer> customers = new ArrayList<Customer>();

	/**
	 * ȸ������
	 * : ȸ�� ������ �޾� ȸ�� ����Ʈ�� ����
	 * @param: Customer
	 * @return: Customer
	 * */
	@Override
	public Customer signup(Customer customer) {
		customers.add(customer);
		return customer;
	}

	/**
	 * �α���
	 * : �Է¹��� �α��� ������ ȸ�� ������ ���� ���� ��� �α���
	 * @param: Customer
	 * @return: Customer
	 * */
	@Override
	public Customer login(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findById(String id) {
		Customer customer = null;
		
		for (Customer C : customers) {
			if(id.equals(C.getId())) customer = C;
		}
		
		return customer;
	}
	
}
