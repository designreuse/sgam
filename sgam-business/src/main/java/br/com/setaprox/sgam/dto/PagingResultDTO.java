package br.com.setaprox.sgam.dto;

import java.util.List;

public class PagingResultDTO<T> {

	private List<T> resultList;

	private int rowCount;

	public PagingResultDTO( List<T> resultList, int rowCount ) {
		super();
		this.resultList = resultList;
		this.rowCount = rowCount;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public int getRowCount() {
		return rowCount;
	}

}
