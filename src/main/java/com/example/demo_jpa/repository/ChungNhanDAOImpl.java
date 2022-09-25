package com.example.demo_jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo_jpa.entity.ChungNhan;
@Repository
public interface ChungNhanDAOImpl extends CrudRepository<ChungNhan, String>{
	@Query(value = "SELECT nhanvien.MaNV\r\n"
			+ "FROM     chungnhan INNER JOIN\r\n"
			+ "                  maybay ON chungnhan.MaMB = maybay.MaMB INNER JOIN\r\n"
			+ "                  nhanvien ON chungnhan.MaNV = nhanvien.MaNV\r\n"
			+ "				  where maybay.Loai like '%Boeing%'\r\n"
			+ "GROUP BY nhanvien.MaNV",nativeQuery = true)
	public List<Object[]> listChuyenBayDenVaDi();

	@Query(value = "select nhanvien.MaNV,MaMB,Ten,Luong FROM     chungnhan INNER JOIN\r\n"
			+ "                  nhanvien ON chungnhan.MaNV = nhanvien.MaNV where MaMB=747",nativeQuery = true)
	public List<Object[]> listNV747();

	@Query(value = "select MaMB FROM     chungnhan INNER JOIN\r\n"
			+ "                  nhanvien ON chungnhan.MaNV = nhanvien.MaNV where nhanvien.Ten like %:ten%",nativeQuery = true)
	public List<Object[]> listMaMBOfNguyen(@Param(value = "ten")String name);

	@Query(value = "SELECT nhanvien.MaNV\r\n"
			+ "FROM     chungnhan INNER JOIN\r\n"
			+ "                  maybay ON chungnhan.MaMB = maybay.MaMB INNER JOIN\r\n"
			+ "                  nhanvien ON chungnhan.MaNV = nhanvien.MaNV\r\n"
			+ "				  where maybay.Loai like %:loai1% or maybay.Loai like %:loai2%\r\n"
			+ "GROUP BY nhanvien.MaNV",nativeQuery = true)
	public List<Object[]> listMaMVOfLoaiMB(@Param(value = "loai1")String loai1,@Param(value = "loai2")String loai2);
	@Query(value = "select Loai from maybay where TamBay < (select DoDai from chuyenbay where MaCB like :maCB)",nativeQuery = true)
	public List<Object[]> listLoaiByMaCB(@Param(value = "maCB")String maCB);
	@Query(value = "select * from chuyenbay where DoDai < (select TamBay from maybay where Loai like :loai)",nativeQuery = true)
	public List<Object[]> listChuyenBayByLoai(@Param(value = "loai")String loai);

	@Query(value = "SELECT nhanvien.Ten\r\n"
			+ "FROM     maybay INNER JOIN\r\n"
			+ "                  chungnhan ON maybay.MaMB = chungnhan.MaMB INNER JOIN\r\n"
			+ "                  nhanvien ON chungnhan.MaNV = nhanvien.MaNV\r\n"
			+ "				   where maybay.Loai like %:loai% \r\n"
			+ "GROUP BY nhanvien.Ten",nativeQuery = true)
	public List<Object[]> listTenNVByLoai(@Param(value = "loai")String loai);

	@Query(value = "SELECT maybay.MaMB, maybay.Loai,count( nhanvien.MaNV)\r\n"
			+ "FROM     chungnhan INNER JOIN\r\n"
			+ "                  maybay ON chungnhan.MaMB = maybay.MaMB INNER JOIN\r\n"
			+ "                  nhanvien ON chungnhan.MaNV = nhanvien.MaNV\r\n"
			+ "GROUP BY maybay.MaMB, maybay.Loai",nativeQuery = true)
	public List<Object[]> listMayBayAndCountNV();
	@Query(value = "SELECT chungnhan.MaNV FROM chungnhan GROUP BY(chungnhan.MaNV) HAVING COUNT(chungnhan.MaMB) = 3",nativeQuery = true)
	public List<Object[]> listNVHavingMaMB3();
}