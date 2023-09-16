package com.sample;

import org.kie.api.KieServices;
import java.util.Date;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsTest {

    @SuppressWarnings("deprecation")
	public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
            
        	// �������� ��������� �������� ��� �������� ������
            Date d1 = new Date(120, 2, 21);
            Computer c1 = new Computer(1, d1, new int[]{1,0,0,1});
            // ������� ������ � ���� ������
            kSession.insert(c1);
            
            Date d2 = new Date(121, 7, 12);
            Computer c2 = new Computer(2, d2, new int[]{1,1,0,0});
            kSession.insert(c2);
            
            // �������� ������ ������
            kSession.fireAllRules();
            
            // ������� ���������� � �����������
            c1.info();
            c2.info();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    // ����� ���������, �������� ��� (1, 2), ������ 5 ������ (0-���� �� ����������, 1 - ����������)
    // ������ 4 ������� (��� �� �������, ������� �� ������� �� ����), ���� �����������, ���� �����
    public static class Computer {
    	int type;
    	int[] tests = new int[5];
    	int[] func = new int[4];
    	Date releaseDate;
    	Date testDate;
    	
    	// ��������������� ����� - ���. ����������� � ���, ������ ��� �� ������� �� ���������)))
    	private static final long mill_day = 1000 * 60 * 60 * 24;
    	
    	// �����������, �� ��������� ��������� ������� ������, ���� ����������� � ��� ������
    	Computer(int t, Date r, int[] f) {
    		type = t;
    		releaseDate = r;
    		testDate = r;
    		for (int i=0; i<5; i++)
    			tests[i] = 0;
    		for (int i=0; i<4; i++)
    			func[i] = f[i];
    	}
    	// ������� ���������� ������ � ������, �� ���� ��� ������ ���� [1,2,5] - ������ ������
    	// ������� ��������� ������ ������ �� ���� [1,1,0,0,1]
		public void setTests(int[] arr) {
    		for (int i=0; i<arr.length; i++)
    			tests[arr[i]-1] = 1;
    	}
		// ������� ��������� ���� ������, ����� ��� ������ ������
    	public int getType() {
            return this.type;
        }
    	
    	public int[] getFunc() {
            return this.func;
        }
    	
    	public int[] getTests() {
            return this.tests;
        }
    	
    	public Date getTestDate() {
            return this.testDate;
        }
    	
    	public Date getReleaseDate() {
            return this.releaseDate;
        }
    	// ������� �������� ���� ������������, �� ���� ���� �������� � ���. ����
    	// ����� - ����, ���������� �� ���� �������� + ���. ����������� � ���� * ���. ����
    	public void setTestDate(int d) {
    		testDate = new Date(releaseDate.getTime() + mill_day * d);
    	}
    	// �������� ����� ���� ��� ���������
    	public void info() {
    		System.out.println("������ ��������� "+this.type+"-��� ����");
    		String[] tmp = {"DDNS", "DNS", "Gateway", "Router"};
    		System.out.print("�� ��������� ������� ");
    		for (int i=0; i<4; i++)
    			if (this.func[i] == 1)
    				System.out.print(tmp[i]+" ");
    		System.out.println();
    		System.out.print("�����, ���������� ��� ������� ���������� - ");
    		for (int i=0; i<5; i++)
    			if (this.tests[i] == 1)
    				System.out.print((i+1)+" ");
    		System.out.println();
    		System.out.println("��������� ��� ������� "+this.releaseDate);
    		System.out.println("���������� ���� ������������ - "+this.testDate);
    		System.out.println();
    	}
    }

}
