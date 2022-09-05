package service;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import dto.Customer;
import exception.DiscrepancyException;
import exception.DuplicationException;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao = new CustomerDaoImpl();
	
	/**
	 * ȸ������
	 * : ȸ�� ������ �޾� ȸ�� ����Ʈ�� ����
	 * @param: Customer, String checkPwd
	 * @return: Customer
	 * */
	@Override
	public Customer signup(Customer customer, String checkPwd) throws DuplicationException, DiscrepancyException {
		if (customerDao.findById(customer.getId()) != null) {
			throw new DuplicationException("���̵� �ߺ��Ǿ����ϴ�.\n�ٸ� ���̵� �Է����ּ���.");
		}
		
		if (!customer.getPassword().equals(checkPwd)) {
			throw new DiscrepancyException("��й�ȣ�� ��й�ȣ Ȯ���� ��ġ���� �ʽ��ϴ�.\n�ٽ� �Է����ּ���.");
		}
		
		return customerDao.signup(customer);
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

}
