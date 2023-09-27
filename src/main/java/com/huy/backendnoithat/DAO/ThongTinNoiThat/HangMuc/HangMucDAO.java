package com.huy.backendnoithat.DAO.ThongTinNoiThat.HangMuc;

import com.huy.backendnoithat.Entity.BangNoiThat.HangMucEntity;

import java.util.List;

public interface HangMucDAO {
    List<HangMucEntity> findAll(String owner);
    HangMucEntity findById(String owner, int id);
    HangMucEntity findUsingName(String owner, String name);
    void save(String owner, HangMucEntity hangMucEntity, int parentId);
    void deleteById(String owner, int id);
    void update(String owner, HangMucEntity hangMucEntity);
    List<HangMucEntity> findAllAndJoinFetch(String owner);
    HangMucEntity findByIdAndJoinFetch(String owner, int id);
    List<HangMucEntity> searchByNoiThat(String owner, int id);
}
