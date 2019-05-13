package com.example.demo.model;
// Generated May 8, 2019 11:38:39 PM by Hibernate Tools 5.1.7.Final

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Phong generated by hbm2java
 */
@Entity
@Table(name = "phong", catalog = "quanlysuco")
public class Phong implements java.io.Serializable {

	private Long phongMa;
	private Khoa khoa;
	private String phongTen;
	private Boolean phongTrangthai;

	public Phong() {
	}

	public Phong(Khoa khoa) {
		this.khoa = khoa;
	}
	public Phong(Khoa khoa, String phongTen)
	{
		this.khoa = khoa;
		this.phongTen = phongTen;
		this.phongTrangthai = true;
	}

	public Phong(Khoa khoa, String phongTen, Boolean phongTrangthai) {
		this.khoa = khoa;
		this.phongTen = phongTen;
		this.phongTrangthai = phongTrangthai;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "PHONG_MA", unique = true, nullable = false)
	public Long getPhongMa() {
		return this.phongMa;
	}

	public void setPhongMa(Long phongMa) {
		this.phongMa = phongMa;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KHOA_MA", nullable = false)
	public Khoa getKhoa() {
		return this.khoa;
	}

	public void setKhoa(Khoa khoa) {
		this.khoa = khoa;
	}

	@Column(name = "PHONG_TEN")
	public String getPhongTen() {
		return this.phongTen;
	}

	public void setPhongTen(String phongTen) {
		this.phongTen = phongTen;
	}

	@Column(name = "PHONG_TRANGTHAI")
	public Boolean getPhongTrangthai() {
		return this.phongTrangthai;
	}

	public void setPhongTrangthai(Boolean phongTrangthai) {
		this.phongTrangthai = phongTrangthai;
	}

}