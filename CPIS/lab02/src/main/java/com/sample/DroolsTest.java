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
            
        	// создадим несколько обьектов для проверки правил
            Date d1 = new Date(120, 2, 21);
            Computer c1 = new Computer(1, d1, new int[]{1,0,0,1});
            // занесем обьект в базу знаний
            kSession.insert(c1);
            
            Date d2 = new Date(121, 7, 12);
            Computer c2 = new Computer(2, d2, new int[]{1,1,0,0});
            kSession.insert(c2);
            
            // запустим работу правил
            kSession.fireAllRules();
            
            // выведем информацию о компьютерах
            c1.info();
            c2.info();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    // класс компьютер, содержит тип (1, 2), массив 5 тестов (0-тест не проводится, 1 - проводится)
    // массив 4 функций (тот же принцип, функции по порядку из дано), дата производста, дата теста
    public static class Computer {
    	int type;
    	int[] tests = new int[5];
    	int[] func = new int[4];
    	Date releaseDate;
    	Date testDate;
    	
    	// вспомогательное число - кол. миллисекунд в дне, потому что по другому не придумала)))
    	private static final long mill_day = 1000 * 60 * 60 * 24;
    	
    	// конструктор, по умолчанию заполняем массивы нулями, дату производста и тип задаем
    	Computer(int t, Date r, int[] f) {
    		type = t;
    		releaseDate = r;
    		testDate = r;
    		for (int i=0; i<5; i++)
    			tests[i] = 0;
    		for (int i=0; i<4; i++)
    			func[i] = f[i];
    	}
    	// функция добавления тестов в массив, на вход дан массив типа [1,2,5] - номера тестов
    	// функции заполняет массив тестов по типу [1,1,0,0,1]
		public void setTests(int[] arr) {
    		for (int i=0; i<arr.length; i++)
    			tests[arr[i]-1] = 1;
    	}
		// функции получения инфы класса, нужны для работы правил
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
    	// функция подсчета даты тестирования, на вход дата создания и кол. дней
    	// вывод - дата, полученная из даты создания + кол. миллисекунд в дней * кол. дней
    	public void setTestDate(int d) {
    		testDate = new Date(releaseDate.getTime() + mill_day * d);
    	}
    	// красивый вывод инфы про компьютер
    	public void info() {
    		System.out.println("Данный компьютер "+this.type+"-ого типа");
    		String[] tmp = {"DDNS", "DNS", "Gateway", "Router"};
    		System.out.print("Он выполняет функции ");
    		for (int i=0; i<4; i++)
    			if (this.func[i] == 1)
    				System.out.print(tmp[i]+" ");
    		System.out.println();
    		System.out.print("Тесты, проводимые для данного компьютера - ");
    		for (int i=0; i<5; i++)
    			if (this.tests[i] == 1)
    				System.out.print((i+1)+" ");
    		System.out.println();
    		System.out.println("Компьютер был выпущен "+this.releaseDate);
    		System.out.println("Предельная дата тестирования - "+this.testDate);
    		System.out.println();
    	}
    }

}
