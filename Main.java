package service2;

public class Main {
	public static void main(String[] args) {
		Main main=new Main();
		main.start();
	}

	public void start() {
		Service service=new Service();
		service.test3();//1은 윤년평년판별 3은현재시각출력
	}
}
