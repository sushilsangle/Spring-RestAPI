package com.sushil.repository;


import com.sushil.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface DeptRepository extends JpaRepository<Department,Integer> {

    //@Query("update Department d set e.del_flg=true where e.id=:id")
   // @Query("update Department d set d.del_flg =false where d.id=:id")

    @Query("update Department e set e.status=false where e.id=:id")
    @Modifying
    public void softDelete(Integer id);

    @Query("from Department e where e.status=true ")
    List<Department> findAllRecord();
}
