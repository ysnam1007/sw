package basic.lesson.gisa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LessonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//startLesson 호출
		LessonMain lm = new LessonMain();
		lm.startLesson();
	}
	// startLesson 메소드이름 기본 메소드 생성(void, p-none)
	public void startLesson() {
		System.out.println("start Lesson");
		this.testStart();
	}
	
	
	public void testStart() {
		//데이터 파일 생성
		ArrayList<Student> list = this.makeData();
		//로직클래스에게 데이터 전달
		Solution solution = new Solution();
		String answer = solution.solveQuestion2(list);
		//정답받아서 답안지 작성
		this.writeAnswer(2,answer);
		answer = solution.solveQuestion3(this.makeData());
		this.writeAnswer(3, answer);
		answer = solution.solveQuestion4(this.makeData());
		this.writeAnswer(4, answer);
		answer = solution.solveQuestion1(this.makeData());
		this.writeAnswer(1, answer);
	}
	
	public ArrayList<Student> makeData(){
		ArrayList<Student> list = null;
		System.out.println("데이터를 생성해서 전달");
		// 파일 연결
		File file = new File("Abc1115.csv");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			// 파일 안의 1000개의 라인에 각각 접근하여 --> 스트림 처리(IO)
			// 각 라인을 11개의 데이터로 분리하여 -->String 분리
			// Student객체로 생성한 다음 List에 저장 -->ArrayList
			list = new ArrayList<Student>();
			while((line=br.readLine())!=null) {
				String[] temp = line.split(",");
				int stdNo = Integer.parseInt(temp[0]);
				String email = temp[1];
				int kor = Integer.parseInt(temp[2].trim());
				int eng = Integer.parseInt(temp[3].trim());
				int math = Integer.parseInt(temp[4].trim());
				int sci = Integer.parseInt(temp[5].trim());
				int hist = Integer.parseInt(temp[6].trim());
				int total = Integer.parseInt(temp[7].trim());
				String mgrCode = temp[8];
				String accCode = temp[9];
				String locCode = temp[10];
				Student student = new Student(stdNo, email, kor, eng, math, sci, hist, total, mgrCode, accCode, locCode);
				list.add(student);
				//System.out.println(kor);
			}
			
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
		if(file.exists()) {
			System.out.println("file exists");
			
		} else {
			System.out.println("file not exists");
		}
		
		return list;
	}
	
	public void writeAnswer(int number,String answer) {
		System.out.println("정답을 받아서 답안지 작성");
		//파일 생성
		File file = new File("Ans"+number+".txt");
		//파일 접근
		try {
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(answer);
			pw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//파일 쓰기
		// --> 스트림 지식
	}
	
}
