package com.example.demo_jpa.repository;

import static org.junit.Assert.fail;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo_jpa.entity.ChuyenBay;

@Repository
public interface ChuyenBayDAOImpl extends CrudRepository<ChuyenBay, String> {
	@Query(value = "select *from chuyenbay where GaDi =:name",nativeQuery = true)
	public List<ChuyenBay> listChuyenBayDAD(@Param(value = "name")String name);
	@Query(value = "select *from chuyenbay where DoDai < 10000 and  DoDai > 8000",nativeQuery = true)
	public List<ChuyenBay> listChuyenBay10To8();
	@Query(value = "select *from chuyenbay where GaDi like :di and GaDen like :den",nativeQuery = true)
	public List<ChuyenBay> listChuyenBayDenVaDi(@Param(value = "di")String di,@Param(value = "den")String den);
	@Query(value = "select count(*)from chuyenbay where GaDi like 'SGN'",nativeQuery = true)
	public int numChuyenBaySGN();
	@Query(value = "select * from chuyenbay where GaDen in  (select GaDi from chuyenbay ) and ( GaDi in  (select GaDen from chuyenbay ))",nativeQuery = true)
	public List<ChuyenBay> listABA();
	@Query(value = "select GaDi,count(GaDi )from chuyenbay group by GaDi",nativeQuery = true)
	public List<Object[]> listGroupGaDi();
	@Query(value = "select * from chuyenbay where GioDi <'12:00:00'",nativeQuery = true)
	public List<ChuyenBay> list1200();
	@Query(value = "select GaDi,COUNT(GaDi) from chuyenbay where GioDi <'12:00:00' group by GaDi",nativeQuery = true)
	public List<Object[]> list1200GroupGaDi();
	@Query(value = "SELECT * FROM chuyenbay WHERE chuyenbay.DoDai < ( SELECT MAX(maybay.TamBay) FROM maybay WHERE maybay.Loai LIKE (%:loai%) )",nativeQuery = true)
	public List<Object[]> listMaxTamBayOfBoeing(@Param(value = "loai")String loai);
	@Query(value = "SELECT chuyenbay.GaDi, SUM(chuyenbay.ChiPhi) as total FROM chuyenbay GROUP BY(chuyenbay.GaDi)",nativeQuery = true)
	public List<Object[]> listSumChiPhi();
}
