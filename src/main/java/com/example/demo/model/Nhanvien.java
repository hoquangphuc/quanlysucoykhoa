package com.example.demo.model;
// Generated May 8, 2019 11:38:39 PM by Hibernate Tools 5.1.7.Final

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Nhanvien generated by hbm2java
 */
@Entity
@Table(name = "nhanvien", catalog = "quanlysuco")
public class Nhanvien implements java.io.Serializable {

	private Long nvMa;
	private Chucvu chucvu;
	private Donvitructhuoc donvitructhuoc;
	private Khoa khoa;
	private Loainhanvien loainhanvien;
	private String nvTen;
	private Date nvNamsinh;
	private String nvSdt;
	private String nvEmail;
	private String nvTendangnhap;
	private String nvMatkhau;
	private Boolean nvTrangthai;
	private String nvChungchihanhnghe;
	private Set<ChitietquyenPhieusuco> chitietquyenPhieusucos = new HashSet<ChitietquyenPhieusuco>(0);
	private Set<PhieuSuCo> phieuSuCos = new HashSet<PhieuSuCo>(0);

	public Nhanvien() {
	}

	public Nhanvien(Chucvu chucvu, Donvitructhuoc donvitructhuoc, Khoa khoa, Loainhanvien loainhanvien) {
		this.chucvu = chucvu;
		this.donvitructhuoc = donvitructhuoc;
		this.khoa = khoa;
		this.loainhanvien = loainhanvien;
	}
	public Nhanvien(Chucvu chucvu, Donvitructhuoc donvitructhuoc, Khoa khoa, Loainhanvien loainhanvien, String nvTen,
					Date nvNamsinh, String nvSdt, String nvEmail,String nvTendangnhap,String nvMatkhau,String nvChungchihanhnghe){
		this.chucvu = chucvu;
		this.donvitructhuoc = donvitructhuoc;
		this.khoa = khoa;
		this.loainhanvien = loainhanvien;
		this.nvTen = nvTen;
		this.nvNamsinh = nvNamsinh;
		this.nvSdt = nvSdt;
		this.nvEmail = nvEmail;
		this.nvTendangnhap = nvTendangnhap;
		this.nvMatkhau = nvMatkhau;
		this.nvChungchihanhnghe = nvChungchihanhnghe;
		this.nvTrangthai = true;
	}

	public Nhanvien(Chucvu chucvu, Donvitructhuoc donvitructhuoc, Khoa khoa, Loainhanvien loainhanvien, String nvTen,
			Date nvNamsinh, String nvSdt, String nvEmail, String nvTendangnhap, String nvMatkhau, Boolean nvTrangthai,
			String nvChungchihanhnghe, Set<ChitietquyenPhieusuco> chitietquyenPhieusucos, Set<PhieuSuCo> phieuSuCos) {
		this.chucvu = chucvu;
		this.donvitructhuoc = donvitructhuoc;
		this.khoa = khoa;
		this.loainhanvien = loainhanvien;
		this.nvTen = nvTen;
		this.nvNamsinh = nvNamsinh;
		this.nvSdt = nvSdt;
		this.nvEmail = nvEmail;
		this.nvTendangnhap = nvTendangnhap;
		this.nvMatkhau = nvMatkhau;
		this.nvTrangthai = nvTrangthai;
		this.nvChungchihanhnghe = nvChungchihanhnghe;
		this.chitietquyenPhieusucos = chitietquyenPhieusucos;
		this.phieuSuCos = phieuSuCos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "NV_MA", unique = true, nullable = false)
	public Long getNvMa() {
		return this.nvMa;
	}

	public void setNvMa(Long nvMa) {
		this.nvMa = nvMa;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CV_MA", nullable = false)
	public Chucvu getChucvu() {
		return this.chucvu;
	}

	public void setChucvu(Chucvu chucvu) {
		this.chucvu = chucvu;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DVTT", nullable = false)
	public Donvitructhuoc getDonvitructhuoc() {
		return this.donvitructhuoc;
	}

	public void setDonvitructhuoc(Donvitructhuoc donvitructhuoc) {
		this.donvitructhuoc = donvitructhuoc;
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

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LNV_MA", nullable = false)
	public Loainhanvien getLoainhanvien() {
		return this.loainhanvien;
	}

	public void setLoainhanvien(Loainhanvien loainhanvien) {
		this.loainhanvien = loainhanvien;
	}

	@Column(name = "NV_TEN", length = 50)
	public String getNvTen() {
		return this.nvTen;
	}

	public void setNvTen(String nvTen) {
		this.nvTen = nvTen;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "NV_NAMSINH", length = 10)
	public Date getNvNamsinh() {
		return this.nvNamsinh;
	}

	public void setNvNamsinh(Date nvNamsinh) {
		this.nvNamsinh = nvNamsinh;
	}

	@Column(name = "NV_SDT", length = 11)
	public String getNvSdt() {
		return this.nvSdt;
	}

	public void setNvSdt(String nvSdt) {
		this.nvSdt = nvSdt;
	}

	@Column(name = "NV_EMAIL", length = 50)
	public String getNvEmail() {
		return this.nvEmail;
	}

	public void setNvEmail(String nvEmail) {
		this.nvEmail = nvEmail;
	}

	@Column(name = "NV_TENDANGNHAP")
	public String getNvTendangnhap() {
		return this.nvTendangnhap;
	}

	public void setNvTendangnhap(String nvTendangnhap) {
		this.nvTendangnhap = nvTendangnhap;
	}

	@Column(name = "NV_MATKHAU", length = 65535)
	public String getNvMatkhau() {
		return this.nvMatkhau;
	}

	public void setNvMatkhau(String nvMatkhau) {
		this.nvMatkhau = nvMatkhau;
	}

	@Column(name = "NV_TRANGTHAI")
	public Boolean getNvTrangthai() {
		return this.nvTrangthai;
	}

	public void setNvTrangthai(Boolean nvTrangthai) {
		this.nvTrangthai = nvTrangthai;
	}

	@Column(name = "NV_CHUNGCHIHANHNGHE")
	public String getNvChungchihanhnghe() {
		return this.nvChungchihanhnghe;
	}

	public void setNvChungchihanhnghe(String nvChungchihanhnghe) {
		this.nvChungchihanhnghe = nvChungchihanhnghe;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nhanvien")
	public Set<ChitietquyenPhieusuco> getChitietquyenPhieusucos() {
		return this.chitietquyenPhieusucos;
	}

	public void setChitietquyenPhieusucos(Set<ChitietquyenPhieusuco> chitietquyenPhieusucos) {
		this.chitietquyenPhieusucos = chitietquyenPhieusucos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nhanvien")
	public Set<PhieuSuCo> getPhieuSuCos() {
		return this.phieuSuCos;
	}

	public void setPhieuSuCos(Set<PhieuSuCo> phieuSuCos) {
		this.phieuSuCos = phieuSuCos;
	}

}
