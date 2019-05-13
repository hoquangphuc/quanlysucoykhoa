package com.example.demo.model;
// Generated May 8, 2019 11:38:39 PM by Hibernate Tools 5.1.7.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * KhoaGiaiQuyetSuCo generated by hbm2java
 */
@Entity
@Table(name = "khoa_giai_quyet_su_co", catalog = "quanlysuco")
public class KhoaGiaiQuyetSuCo implements java.io.Serializable {

	private KhoaGiaiQuyetSuCoId id;
	private Khoa khoa;
	private PhieuSuCo phieuSuCo;
	private Date ngaylaphdhc;

	public KhoaGiaiQuyetSuCo() {
	}

	public KhoaGiaiQuyetSuCo(KhoaGiaiQuyetSuCoId id, Khoa khoa, PhieuSuCo phieuSuCo) {
		this.id = id;
		this.khoa = khoa;
		this.phieuSuCo = phieuSuCo;
	}

	public KhoaGiaiQuyetSuCo(KhoaGiaiQuyetSuCoId id, Khoa khoa, PhieuSuCo phieuSuCo, Date ngaylaphdhc) {
		this.id = id;
		this.khoa = khoa;
		this.phieuSuCo = phieuSuCo;
		this.ngaylaphdhc = ngaylaphdhc;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "phieuMa", column = @Column(name = "PHIEU_MA", nullable = false)),
			@AttributeOverride(name = "khoaMa", column = @Column(name = "KHOA_MA", nullable = false)) })
	public KhoaGiaiQuyetSuCoId getId() {
		return this.id;
	}

	public void setId(KhoaGiaiQuyetSuCoId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KHOA_MA", nullable = false, insertable = false, updatable = false)
	public Khoa getKhoa() {
		return this.khoa;
	}

	public void setKhoa(Khoa khoa) {
		this.khoa = khoa;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PHIEU_MA", nullable = false, insertable = false, updatable = false)
	public PhieuSuCo getPhieuSuCo() {
		return this.phieuSuCo;
	}

	public void setPhieuSuCo(PhieuSuCo phieuSuCo) {
		this.phieuSuCo = phieuSuCo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "NGAYLAPHDHC", length = 19)
	public Date getNgaylaphdhc() {
		return this.ngaylaphdhc;
	}

	public void setNgaylaphdhc(Date ngaylaphdhc) {
		this.ngaylaphdhc = ngaylaphdhc;
	}

}