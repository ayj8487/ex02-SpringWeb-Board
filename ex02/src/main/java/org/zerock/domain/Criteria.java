package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter // lombok 이용 getter/setter 처리
@Setter
@ToString
public class Criteria { // 검색의 "기준"
	// MyBatis 페이징 처리	
	// 페이징 처리를 위해서는 SQL 실행 전 1페이지번호, 2한페이지당 몇개의 데이터 의 파라미터가 필요

/*	
 	페이징 처리의 BoardMapper는 인터페이스와 어노테이션을 이용하기 때문에 SQL 구문 처리가 복잡하다.
	때문에 XML 로 처리하여 알아보기 쉽고 관리하기 쉽게 처리
*/	
	private int pagNum; // 페이지 번호
	private int amount; // 한페이지당 몇 개의 데이터

	public Criteria() { // 생성자를 통해서 기본값을 1페이지, 10개로 지정처리 
		this(1,10);
	}
	
	public Criteria(int pagNum, int amount) {
		this.pagNum = pagNum;
		this.amount = amount;
	}
	
	

}
