package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;


/*
    문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 작성하고,  
        Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
        
        - 삭제, 검색기능은 '이름'을 입력 받아서 처리한다.
         
        (Map의 구조는 key값으로 '이름'을 사용하고, value값으로는 'Phone클래스의 인스턴스'로 한다.)
          
        아래 메뉴의 내용을 프로그램하시오.

 실행예시) 
       ------------------------------
       다음 메뉴를 선택하세요.
       
       1. 전화번호 등록
       2. 전화번호 수정
       3. 전화번호 삭제
       4. 전화번호 검색
       5. 전화번호 전체 출력
       0. 프로그램 종료
       ------------------------------
       번호입력>> 1
 
       새롭게 등록할 전화번호 정보를 입력하세요.
       이름 >> 홍길동
       전화번호 >> 010-1111-1111
       주소 >> 대전시 중구 대흥동 
       
       '홍길동'은 이미 등록된 사람입니다. 
 
       ------------------------------
       다음 메뉴를 선택하세요.
       
       1. 전화번호 등록
       2. 전화번호 수정
       3. 전화번호 삭제
       4. 전화번호 검색
       5. 전화번호 전체 출력
       0. 프로그램 종료
       ---------------------------------------
       번호입력>> 5
       
        ---------------------------------------
          번호    이름          전화번호                  주소
        ---------------------------------------
          1    홍길동   010-1111-1111  대전시 중구 대흥동 
          ~~~~~~
          ~~~~~~
        ---------------------------------------
        번호입력>> 0
        
        프로그램을 종료합니다.
                   
 */

public class PhoneBookTest {
   static Scanner sc = new Scanner(System.in);
   static HashMap<String, Phone> phoneBookMap = new HashMap<>();
   File files = new File("d:/d_other/phoneBook.dat");
   
   public static void main(String[] args) {
      new PhoneBookTest().phoneBookStart();
   }

   public void phoneBookStart() {
      if(files.exists()){
         
         
         try {
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(files)));
            
            Object obj;
            
            try {
               while( (obj = ois.readObject()) != null){
                  phoneBookMap =(HashMap<String, Phone>)obj;   
               }
            } catch(EOFException e){
               
            } catch (ClassNotFoundException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
            } finally{
               ois.close();
            }
         
         
         } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         

         
      }
      
      while (true) {
         int choice = phoneMenu();

         switch (choice) {
         case 1: // 1. 전화번호 등록
            addPhone();
            break;
         case 2:// 2. 전화번호 수정
            updatePhone();
            break;
         case 3:// 3. 전화번호 삭제
            removePhone();
            break;
         case 4:// 4. 전화번호 검색
            searchPhone();
            break;
         case 5:// 5. 전화번호 전체 출력
            listupPhone();
            break;
         case 6: // 6. 전화번호 저장
            saveData();
            break;
         case 0:// 0. 프로그램 종료
            System.out.println("프로그램을 종료합니다.");
            saveData();
            System.exit(0);
         default:
            System.out.println("번호를 다시 선택하세요.");
         }
      }
      
   }

   private void saveData() {
      
      try {
         ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(files)));
      
         oos.writeObject(phoneBookMap);
         System.out.println("정보를 저장하였습니다.");
         oos.close();
            
      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      
   }

   //전체 출력
   private void listupPhone() {
      System.out.println("---------------------------------------");
      System.out.println("번호\t이름\t전화번호\t주소");
      System.out.println("---------------------------------------");
      int count = 0;
      for(String key : phoneBookMap.keySet()){
         Phone p = phoneBookMap.get(key);
         count++;
         System.out.println(count + "\t" + key + "\t" + p.getTel() + "\t" + p.getAddr());
      }   
      System.out.println("---------------------------------------");
   }

   //전화번호 검색
   public void searchPhone() {
      System.out.println("전화번호를 검색합니다.");
      System.out.println("전화번호를 검색할 사람 이름>>");
      String name = sc.nextLine();
      
      if(!phoneBookMap.containsKey(name)){
         System.out.println(name + "님의 전화번호가 존재하지 않습니다.");
      }else{
         Phone p = phoneBookMap.get(name);
         System.out.println("---------------------------------------");
         System.out.println("이름\t전화번호\t주소");
         System.out.println("---------------------------------------");
         System.out.println(name + "\t" + p.getTel() + "\t" + p.getAddr());
         System.out.println("---------------------------------------");
      }
   }
      
   
   //전화번호 삭제
   public void removePhone() {
      System.out.println("전화번호를 삭제할 사람 이름>>");
      String name = sc.nextLine();
      if(!phoneBookMap.containsKey(name)){
         System.out.println(name + "님의 전화번호가 존재하지 않습니다.");
      }else{
         System.out.println(name + "님의 전화번호가 삭제되었습니다.");
         phoneBookMap.remove(name);
      }
   }

   //전화번호 수정
   private void updatePhone() {
      System.out.println("전화번호를 수정할 사람 이름>>");
      String name = sc.nextLine();
      if(!phoneBookMap.containsKey(name)){
         System.out.println(name + "님의 전화번호가 존재하지 않습니다.");
      }else{
         System.out.println("새롭게 저장할 전화번호>");
         String tel = sc.nextLine();
         System.out.println("새롭게 저장할 주소>");
         String addr = sc.nextLine();
         phoneBookMap.put(name, new Phone(name, tel, addr));
         System.out.println(name + "(이)가 수정되었습니다.");
      }
   }
   
   //동작
   private static int phoneMenu() {
      while (true) {
         System.out.println("------------------------------");
         System.out.println("다음 메뉴를 선택하세요.");
         System.out.println("\t1. 전화번호 등록");
         System.out.println("\t2. 전화번호 수정");
         System.out.println("\t3. 전화번호 삭제");
         System.out.println("\t4. 전화번호 검색");
         System.out.println("\t5. 전화번호 전체 출력");
         System.out.println("\t6. 전화번호 저장");
         System.out.println("\t0. 프로그램 종료");
         System.out.println("------------------------------");
         System.out.println("번호입력>>");
         int input = Integer.parseInt(sc.nextLine());
         return input;
      }
   }
   
   // 전화번호 등록
   public void addPhone() {
      String name, tel, addr;
      System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
      System.out.println("이름>>");
      name = sc.nextLine();
      
      boolean check;
      check = phoneBookMap.containsKey(name);

      if (check == true) {
         System.out.println(name + "(은)는 이미 등록된 사람입니다.");
         
      } else {
         System.out.println("전화번호>>");
         tel = sc.nextLine();
         System.out.println("주소>>");
         addr = sc.nextLine();

         phoneBookMap.put(name, new Phone(name, tel, addr));
         System.out.println(name + "(이)가 등록되었습니다.");
      }
   }   
      
   
class Phone implements Serializable{
   
   private static final long serialVersionUID = 5703197688825784993L;
      private String name;
      private String tel;
      private String addr;

      public Phone(String name, String tel, String addr) {
         super();
         this.name = name;
         this.tel = tel;
         this.addr = addr;
      }

      public String getName() {
         return name;
      }

      public void setName(String name) {
         this.name = name;
      }

      public String getTel() {
         return tel;
      }

      public void setTel(String tel) {
         this.tel = tel;
      }
      
      public String getAddr() {
         return addr;
      }

      public void setAddr(String addr) {
         this.addr = addr;
      }
      
   }
}

















