package com.example.demo.model;
// Generated May 8, 2019 11:38:39 PM by Hibernate Tools 5.1.7.Final

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

/**
 * Khoa generated by hbm2java
 */
@Entity
@Table(name = "khoa", catalog = "quanlysuco")
public class Khoa implements java.io.Serializable {

	private Long khoaMa;
	private Donvitructhuoc donvitructhuoc;
	private String khoaTen;
	private Boolean khoaTrangthai;
	private Set<Nhanvien> nhanviens = new HashSet<Nhanvien>(0);
	private Set<Phong> phongs = new HashSet<Phong>(0);
	private Set<KhoaGiaiQuyetSuCo> khoaGiaiQuyetSuCos = new HashSet<KhoaGiaiQuyetSuCo>(0);

	public Khoa() {
	}

	public Khoa(Donvitructhuoc donvitructhuoc, String khoaTen) {
		this.donvitructhuoc = donvitructhuoc;
		this.khoaTen = khoaTen;
		this.khoaTrangthai = true;
	}


	public Khoa(Donvitructhuoc donvitructhuoc, String khoaTen, Boolean khoaTrangthai, Set<Nhanvien> nhanviens,
					 Set<Phong> phongs, Set<KhoaGiaiQuyetSuCo> khoaGiaiQuyetSuCos) {
		this.donvitructhuoc = donvitructhuoc;
		this.khoaTen = khoaTen;
		this.khoaTrangthai = khoaTrangthai;
		this.nhanviens = nhanviens;
		this.phongs = phongs;
		this.khoaGiaiQuyetSuCos = khoaGiaiQuyetSuCos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "KHOA_MA", unique = true, nullable = false)
	public Long getKhoaMa() {
		return this.khoaMa;
	}

	public void setKhoaMa(Long khoaMa) {
		this.khoaMa = khoaMa;
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

	@Column(name = "KHOA_TEN", length = 30)
	public String getKhoaTen() {
		return this.khoaTen;
	}

	public void setKhoaTen(String khoaTen) {
		this.khoaTen = khoaTen;
	}

	@Column(name = "KHOA_TRANGTHAI")
	public Boolean getKhoaTrangthai() {
		return this.khoaTrangthai;
	}

	public void setKhoaTrangthai(Boolean khoaTrangthai) {
		this.khoaTrangthai = khoaTrangthai;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "khoa")
	public Set<Nhanvien> getNhanviens() {
		return this.nhanviens;
	}

	public void setNhanviens(Set<Nhanvien> nhanviens) {
		this.nhanviens = nhanviens;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "khoa")
	public Set<Phong> getPhongs() {
		return this.phongs;
	}

	public void setPhongs(Set<Phong> phongs) {
		this.phongs = phongs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "khoa")
	public Set<KhoaGiaiQuyetSuCo> getKhoaGiaiQuyetSuCos() {
		return this.khoaGiaiQuyetSuCos;
	}

	public void setKhoaGiaiQuyetSuCos(Set<KhoaGiaiQuyetSuCo> khoaGiaiQuyetSuCos) {
		this.khoaGiaiQuyetSuCos = khoaGiaiQuyetSuCos;
	}

}
