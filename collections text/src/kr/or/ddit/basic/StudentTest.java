package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
	문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 
		맴버로 갖는 Student test클래스를 작성한다. 
		이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 
		매개변수로 받아서 초기화 처리한다.
		
		이 Student 객체는 List에 저장하여 관리한다.
		
		List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 
		내부 정렬기준을 구현하고,
		
		종점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬되는
		외부 정렬기준 클래스를 작성하여 정렬된 결과를 출력하시오.
		
		(등수는 List에 전체 데이터가 추가된 후에 저장되도록 한다.)

*/
//리스트만 만들고 .add 데이터를 넣어서 하면 된다 .
// 일단..리스트만.. 내부정렬은 나중에
// 
public class StudentTest {
	public static void main(String[] args) {
		ArrayList<Student> student = new ArrayList<>();
		student.add(new Student(5, "김하나", 90, 80, 90 ));
		student.add(new Student(3, "박둘째", 50, 70, 50 ));
		student.add(new Student(2, "오세번", 90, 80, 90 ));
		student.add(new Student(1, "양다섯", 92, 77, 27 ));
		student.add(new Student(6, "정여섯", 88, 30, 40 ));
		System.out.println("정렬 전...");
		for(Student st : student){
			System.out.println(st);
		}
		Collections.sort(student);
		System.out.println("정렬 후...");
		for(Student st : student){
			System.out.println(st);
		}
		System.out.println("정렬 전...");
		for(Student st : student){
			System.out.println(st);
		}
		Collections.sort(student, new StudentIdDesc());
		System.out.println("정렬 후...");
		int i =0;
		for(Student st : student){
			i++;
			st.setRank(i);
			System.out.println(st);
		}
		
		
	}
}
class StudentIdDesc implements Comparator<Student>{

	@Override
	// DESC
	public int compare(Student std1, Student std2) {
		if(std1.gettScore() > std2.gettScore()){
			return -1; 
		}else if(std1.gettScore() < std2.gettScore()){
			return 1; 
		}else{
			if(std1.getName().compareTo(std2.getName()) > 0){
				return 1; 
			}else if(std1.getName().compareTo(std2.getName()) <0){
				return -1; 
			}else{
				return 0;
			}
		}
	}
}
class Student implements Comparable<Student>{
	int sId;
	String name;
	int kScore;
	int eScore;
	int mScore;
	int tScore;
	int rank;

	public Student(int sId, String name, int kScore, int eScore, int mScore) {
		super();
		
		this.sId = sId;
		this.name = name;
		this.kScore = kScore;
		this.eScore = eScore;
		this.mScore = mScore;
		this.settScore(tScore);
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getkScore() {
		return kScore;
	}

	public void setkScore(int kScore) {
		this.kScore = kScore;
	}

	public int geteScore() {
		return eScore;
	}

	public void seteScore(int eScore) {
		this.eScore = eScore;
	}

	public int getmScore() {
		return mScore;
	}

	public void setmScore(int mScore) {
		this.mScore = mScore;
	}

	public int gettScore() {
		return tScore;
	}

	public void settScore(int tScore) {
		tScore = this.kScore + this.eScore + this.mScore;
		this.tScore = tScore;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Student [sId=" + sId + ", name=" + name + ", kScore=" + kScore
				+ ", eScore=" + eScore + ", mScore=" + mScore + ", tScore="
				+ tScore + ", rank=" + rank + "]";
	}
	// 학번의 오름차순 정렬  
	@Override
	public int compareTo(Student student) {
		return new Integer(this.getsId()).compareTo(student.getsId());
	}
	
	
}
