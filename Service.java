package service2;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Service {
	public void test1() {
		int year;
		Scanner sc = new Scanner(System.in);
		System.out.println("년도를 입력:");
		year=sc.nextInt();
		
		if((year%4==0&&year%100!=0)||year%400==0) {
			System.out.println("윤년");}
			else {
				System.out.println("평년");
				
		}
		sc.close();
	}

	public void test3() {
		LocalDateTime now=LocalDateTime.now();
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyy.MM.dd a HH:mm:ss");
		System.out.println("현재 시간:"+now.format(dtf));
	}
}
