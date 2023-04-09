package com.llq.training.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "EMAIL_BIEU_MAU")
public class EmailEntity {

	@Id
	@GeneratedValue(generator = "sequence-generator")
	@GenericGenerator(
      name = "sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters = {
        @Parameter(name = "sequence_name", value = "EMAIL_BIEU_MAU_SEQ"),
        @Parameter(name = "initial_value", value = "230"),
        @Parameter(name = "increment_size", value = "1")
        }
    )
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "MA")
	private String ma;

	@Lob
	@Column(name = "NOI_DUNG")
	private String noi_dung;

	@Column(name = "NGUOI_TAO")
	private String nguoi_tao;

	@Column(name = "NGAY_TAO")
	private Date ngay_tao;

	@Column(name = "NGUOI_SUA")
	private String nguoi_sua;

	@Column(name = "NGAY_SUA")
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
