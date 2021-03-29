package kr.co.sh.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class TestBean1 {

	private int data1;
	private DataBean1 data2;
	
	// �ڵ� ������ ������ ����
	// �����Ϸ� �ڵ����� setter �޼��� �߰��Ǿ� setter �޼��� ���� ����
	// getter �� �߰�
	@Autowired
	private DataBean1 data3;
	
	public DataBean1 getData3() {
		return data3;
	}
	
	// ���� ���� ��ϵǾ����� 
	@Autowired
	@Qualifier("obj4")
	private DataBean2 data4;
	@Autowired
	@Qualifier("obj5")
	private DataBean2 data5;
	
	public DataBean2 getData4() {
		return data4;
	}

	public DataBean2 getData5() {
		return data5;
	}

	@Autowired(required = false) // ������ ����(null), ������ ����
	@Qualifier("obj6")  // ��ϵ� bean(obj5)�� ok -> ���� obj6�����δ� ���� + required = false��  
	private DataBean2 data6;  // �ָ����δ� ���� X
	

	public DataBean2 getData6() {
		return data6;
	}
	
	// ������ �̿��� �ݵ�� ���� ������Ƽ
//	public TestBean1(int data) {
//		this.data1 = data;
//	}


	public int getData1() {
		return data1;
	}

	// �ʼ� ���� ������Ƽ (������ 5.1���� �ڹ� �� ��Ͻ� ����)
	@Required  // �ݵ�� ����
	public void setData1(int data1) {
		this.data1 = data1;
	}

	public DataBean1 getData2() {
		return data2;
	}

	// �ڵ� ����(Ÿ��) - DataBean1
	@Autowired
	public void setData2(DataBean1 data2) {
		this.data2 = data2;
	}

	
}