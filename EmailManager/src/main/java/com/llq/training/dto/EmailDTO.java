package com.llq.training.dto;

import java.util.Date;

public class EmailDTO {
	private Long id;

	private String ma;

	private String noi_dung;

	private String nguoi_tao;

	private Date ngay_tao;

	private String nguoi_sua;

	private Date ngay_sua;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMa() {
		return ma;
	}

	public void setMa(String ma) {
		this.ma = ma;
	}

	public String getNoi_dung() {
		return noi_dung;
	}

	public void setNoi_dung(String noi_dung) {
		this.noi_dung = noi_dung;
	}

	public String getNguoi_tao() {
		return nguoi_tao;
	}

	public void setNguoi_tao(String nguoi_tao) {
		this.nguoi_tao = nguoi_tao;
	}

	public Date getNgay_tao() {
		return ngay_tao;
	}

	public void setNgay_tao(Date ngay_tao) {
		this.ngay_tao = ngay_tao;
	}

	public String getNguoi_sua() {
		return nguoi_sua;
	}

	public void setNguoi_sua(String nguoi_sua) {
		this.nguoi_sua = nguoi_sua;
	}

	public Date getNgay_sua() {
		return ngay_sua;
	}

	public void setNgay_sua(Date ngay_sua) {
		this.ngay_sua = ngay_sua;
	}

}
