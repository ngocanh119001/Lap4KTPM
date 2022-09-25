package com.example.demo_jpa.entity;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chuyenbay")
public class ChuyenBay implements Serializable{
	@Id
	@Column(name = "MaCB",columnDefinition = "varchar(5)")
	private String MaCB;
	@Column(name = "GaDi",columnDefinition = "varchar(50)")
	private String GaDi;
	@Column(name = "GaDen",columnDefinition = "varchar(50)")
	private String GaDen;
    @Column(name = "DoDai")
	private int DoDai;
	@Column(name = "GioDi", columnDefinition = "TIME(7)")
	private LocalTime GioDi;
	@Column(name = "GioDen", columnDefinition = "TIME(7)")
	private LocalTime GioDen;
    @Column(name = "ChiPhi")
	private int ChiPhi;
	public String getMaCB() {
		return MaCB;
	}
	public void setMaCB(String maCB) {
		MaCB = maCB;
	}
	public String getGaDi() {
		return GaDi;
	}
	public void setGaDi(String gaDi) {
		GaDi = gaDi;
	}
	public String getGaDen() {
		return GaDen;
	}
	public void setGaDen(String gaDen) {
		GaDen = gaDen;
	}
	public int getDoDai() {
		return DoDai;
	}
	public void setDoDai(int doDai) {
		DoDai = doDai;
	}
	public LocalTime getGioDi() {
		return GioDi;
	}
	public void setGioDi(LocalTime gioDi) {
		GioDi = gioDi;
	}
	public LocalTime getGioDen() {
		return GioDen;
	}
	public void setGioDen(LocalTime gioDen) {
		GioDen = gioDen;
	}
	public int getChiPhi() {
		return ChiPhi;
	}
	public void setChiPhi(int chiPhi) {
		ChiPhi = chiPhi;
	}
	public ChuyenBay(String maCB, String gaDi, String gaDen, int doDai, LocalTime gioDi, LocalTime gioDen, int chiPhi) {
		super();
		MaCB = maCB;
		GaDi = gaDi;
		GaDen = gaDen;
		DoDai = doDai;
		GioDi = gioDi;
		GioDen = gioDen;
		ChiPhi = chiPhi;
	}
	public ChuyenBay() {
		super();
	}
	@Override
	public String toString() {
		return "ChuyenBay [MaCB=" + MaCB + ", GaDi=" + GaDi + ", GaDen=" + GaDen + ", DoDai=" + DoDai + ", GioDi="
				+ GioDi + ", GioDen=" + GioDen + ", ChiPhi=" + ChiPhi + "]";
	}
	
}