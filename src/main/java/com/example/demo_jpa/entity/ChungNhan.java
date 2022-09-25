package com.example.demo_jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(ChungNhanPk.class)
@Table(name = "chungnhan")
public class ChungNhan implements Serializable{
	@Id
	@ManyToOne
	@JoinColumn(name = "MaNV")
	private NhanVien maNV;
	@Id
	@ManyToOne
	@JoinColumn(name = "MaMB")
	private MayBay MaMB;
	
	public MayBay getMaMB() {
		return MaMB;
	}
	public void setMaMB(MayBay maMB) {
		MaMB = maMB;
	}
	public NhanVien getMaNV() {
		return maNV;
	}
	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
	}
	public ChungNhan(MayBay maMB, NhanVien maNV) {
		super();
		MaMB = maMB;
		this.maNV = maNV;
	}
	public ChungNhan() {
		super();
	}
	
}