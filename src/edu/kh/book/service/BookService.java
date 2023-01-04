package edu.kh.book.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class BookService {
	
	Scanner sc = new Scanner(System.in);
	
	Set<Map <String, Object> > setBook = new HashSet< Map<String, Object> >();
	Set<Map <String, Object> > favoriteBook = new HashSet< Map<String, Object>>();
	
	
	
	public void displayMenu() {
		
		int menuNum = 0;
		
		try {
			
			do {
				
				System.out.println(" ==== 도서 목록 출력 ==== ");
				System.out.println(" 1. 도서 등록 ");
				System.out.println(" 2. 도서 전체 조회 ");
				System.out.println(" 3. 도서 검색 조회 ");
				System.out.println(" 4. 도서 수정 ");
				System.out.println(" 5. 도서 삭제 ");
				System.out.println(" 6. 즐찾 추가 ");
				System.out.println(" 7. 즐찾 삭제 ");
				System.out.println(" 8. 즐찾 내보내기 ");
				
				
				System.out.println();
				System.out.print("원하는 번호 입력 : ");
				
				menuNum = sc.nextInt();
				sc.nextLine();
				
				
				switch(menuNum) {
				
				case 1 : addBook(); break;
				case 2 : selectAllBook(); break;
				case 3 : selectBook(); break;
				case 4 : updateBook(); break;
				case 5 : deleteBook(); break;
				case 6 : favoriteBook(); break;
				case 7 : break;
				case 8 : break;
				case 0 : System.out.println("프로그램 종료"); break;
				default : System.out.println("잘못 입력하셨습니다."); break;
				}
				
				
			}while(menuNum != 0);
			
			
		}catch(InputMismatchException e) {
			
			
			e.printStackTrace();
			menuNum = -1;
			
		}
	
		
	}
	
	public void addBook() {
		
		System.out.println("도서 등록 페이지");
		
		System.out.print("도서 번호 입력 : ");
		int bookNum = sc.nextInt();
		sc.nextLine();
		
		System.out.print("도서 제목 입력 : ");
		String bookName = sc.nextLine();
		
		System.out.print("도서 가격 입력 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		System.out.print("작가 입력 : ");
		String author = sc.next();
		
		System.out.print("출판사 입력 : ");
		String publisher = sc.next();
		
		
		
		Map <String, Object> map = new HashMap<String, Object>();
		
		map.put("도서 번호", bookNum);
		map.put("도서 제목", bookName);
		map.put("도서 가격", price);
		map.put("작가 이름", author);
		map.put("출판사", publisher);
		
		setBook.add(map);
		
		System.out.println(setBook + " 가 추가되었습니다.");
		
		
	}
	
	
	public void selectAllBook() {
		
		System.out.println(" ==== 도서 전체 조회 페이지 ==== ");
		System.out.println();
		
		System.out.println(setBook.toString());
		System.out.println();
		
		
	}
	
	
	
	public void selectBook() {
		
		
		System.out.println(" ==== 도서 조회 페이지 ==== ");
		
		System.out.println();
		System.out.println(" 조회를 원하는 도서 번호를 입력하세요 : ");
		Integer a = sc.nextInt();
		sc.nextLine();
		
	
		
		for(Map<String,Object> map : setBook) {
			if(map.get("도서 번호") == a ) {
				System.out.println(map);
			}
		}
	}
	
	
	public void updateBook() {
		
		System.out.println( " ==== 도서 수정 페이지 ==== ");
		System.out.println();
		
		System.out.println(" 수정을 원하는 도서 번호를 입력하세요 : ");
		Integer a = sc.nextInt();
		sc.nextLine();
		
		for(Map<String,Object> map : setBook) {
			if(map.get("도서 번호") == a ) {
				
				System.out.print("도서 번호 입력 : ");
				int bookNum = sc.nextInt();
				sc.nextLine();
				
				System.out.print("도서 제목 입력 : ");
				String bookName = sc.nextLine();
				
				System.out.print("도서 가격 입력 : ");
				int price = sc.nextInt();
				sc.nextLine();
				
				System.out.print("작가 입력 : ");
				String author = sc.next();
				
				System.out.print("출판사 입력 : ");
				String publisher = sc.next();
				
				map.put("도서 번호", bookNum);
				map.put("도서 제목", bookName);
				map.put("도서 가격", price);
				map.put("작가 이름", author);
				map.put("출판사", publisher);
				
				break;
			}
		}
		System.out.println("수정 완료");
	}
	
	public void deleteBook() {
		
		System.out.println(" ==== 도서 삭제 페이지 ==== ");
		System.out.println();
		
		System.out.println("삭제 하고 싶은 도서 번호를 입력하세요.");
		Integer a = sc.nextInt();
		sc.nextLine();
		
		for(Map<String, Object> map : setBook) {
			if(map.get("도서 번호") == a) {
				map.clear();
				break;
			}
		}
		System.out.println("삭제 완료");
	}
	
	
	public void favoriteBook() {
		
		selectAllBook();
		
		
		System.out.println( " === 도서 즐겨찾기 등록 페이지 === ");
		System.out.println();
		
		System.out.println( "즐겨 찾기를 원하는 도서 제목을 입력하세요.");
		
		String name = sc.nextLine();
		
		for(Map<String, Object> map : setBook) {
			System.out.println("하하하하");
			
			if(map.get("도서 제목").equals(name)) {
				
				Map<String, Object> fav = new HashMap<String, Object>();
				
				
				fav.put("도서 번호", map.get("도서 번호"));
				fav.put("도서 제목", map.get("도서 제목"));
				fav.put("작가 이름", map.get("작가 이름"));
				
				favoriteBook.add(fav);
				
				
			}
		}
		System.out.println(favoriteBook.toString() + " 가 즐겨찾기에 추가 되었습니다.");
	}
	
	
	
	public void deleteFavoriteBook() {
		
		
		
		
		
		
		
		
	}
	
	public void output1() {
		
		
	}
	
	
	
}