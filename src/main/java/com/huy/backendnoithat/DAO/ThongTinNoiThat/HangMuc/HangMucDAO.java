package com.huy.backendnoithat.DAO.ThongTinNoiThat.HangMuc;

import com.huy.backendnoithat.Entity.BangNoiThat.HangMucEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HangMucDAO extends CrudRepository<HangMucEntity, Integer> {
    @Query("from HangMucEntity where name = :name")
    HangMucEntity findUsingName(String name);
    @Modifying
    @Query("update HangMucEntity set name = :name where id = :id")
    void update(HangMucEntity hangMucEntity);
    @Query("FROM HangMucEntity hm JOIN FETCH hm.noiThatEntity")
    List<HangMucEntity> findAllAndJoinFetch();
    @Query("from HangMucEntity pc where pc.noiThatEntity.id = :id order by pc.id")
    List<HangMucEntity> searchByNoiThat(int id);
}
