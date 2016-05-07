package br.com.setaprox.sgam.dto;

public class PageRequestDTO<T> {

	private int start;

	private int total;

	private T filter;

	public PageRequestDTO( int start, int total, T filtro ) {
		this.start = start;
		this.total = total;
		this.filter = filtro;
	}

	public int getStart() {
		return start;
	}

	public int getTotal() {
		return total;
	}

	public T getFiltro() {
		return filter;
	}

}
