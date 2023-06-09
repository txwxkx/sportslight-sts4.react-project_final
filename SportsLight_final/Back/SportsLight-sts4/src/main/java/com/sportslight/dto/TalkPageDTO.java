package com.sportslight.dto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Component
@NoArgsConstructor
public class TalkPageDTO {
	
	private int currentPage; //현재 페이지
	
	private int totalCount; //총 레코드 수
	
	private int blockCount = 20; //한 페이지에 보여줄 레코드 수
	
	private int blockPage = 5; //한 블록에 보여줄 페이지 수
	
	private int totalPage; //총 페이지수
	
	private int startRow; //시작 레코드 번호
	
	private int endRow; //끝 레코드 번호
	
	private int startPage; //한 블록의 시작 페이지 번호
	
	private int endPage; //한 블록의 끝 페이지 번호
	
	private int number;
	
	private String searchKey;
	
	private String searchWord;

	public TalkPageDTO(int currentPage, int totalCount) {
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		
		//총 페이지 수
		totalPage = totalCount / blockCount + (totalCount % blockCount == 0 ? 0 : 1);
		if(totalPage<currentPage)
		  this.currentPage = totalPage;

		//시작 레코드
		startRow = (this.currentPage - 1) * blockCount + 1;

		//끝 레코드
		endRow = startRow + blockCount - 1;

		//시작 페이지
		startPage = (int) ((this.currentPage - 1) / blockPage) * blockPage + 1;

		//끝 페이지
		endPage = startPage + blockPage - 1;
		if (totalPage < endPage)
			endPage = totalPage;

		//리스트에서의 출력번호
		number = totalCount - (this.currentPage - 1) * blockCount;
	}

	public TalkPageDTO(int currentPage, int totalCount, String searchKey, String searchWord) {
		this(currentPage, totalCount);
		this.searchKey = searchKey;
		this.searchWord = searchWord;
	}	

}// end class













