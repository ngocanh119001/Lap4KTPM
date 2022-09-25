package com.example.demo_jpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "nhanvien")
public class NhanVien implements Serializable{

	@Id
	@Column(columnDefinition = "varchar(9)")
	private String MaNV;
	@Column(columnDefinition = "varchar(50)")
	private String Ten;
	private int Luong;
	@OneToMany(mappedBy = "maNV")
	private List<ChungNhan> chungNhans;
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public String getTen() {
		return Ten;
	}
	public void setTen(String ten) {
		Ten = ten;
	}
	public int getLuong() {
		return Luong;
	}
	public void setLuong(int luong) {
		Luong = luong;
	}
	public NhanVien(String maNV, String ten, int luong) {
		super();
		MaNV = maNV;
		Ten = ten;
		Luong = luong;
	}
	public NhanVien() {
		super();
	}
	@Override
	public String toString() {
		return "NhanVien [MaNV=" + MaNV + ", Ten=" + Ten + ", Luong=" + Luong + "]";
	}
	
}