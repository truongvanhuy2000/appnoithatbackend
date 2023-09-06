package com.huy.backendnoithat.Service.ThongTinNoiThat.HangMuc;

import com.huy.backendnoithat.DAO.ThongTinNoiThat.HangMuc.HangMucDAO;
import com.huy.backendnoithat.DAO.ThongTinNoiThat.NoiThat.NoiThatDAO;
import com.huy.backendnoithat.DTO.BangNoiThat.PhongCach;
import com.huy.backendnoithat.Entity.BangNoiThat.HangMucEntity;
import com.huy.backendnoithat.DTO.BangNoiThat.HangMuc;
import com.huy.backendnoithat.Entity.BangNoiThat.NoiThatEntity;
import com.huy.backendnoithat.Entity.BangNoiThat.PhongCachNoiThatEntity;
import com.huy.backendnoithat.Service.ThongTinNoiThat.NoiThat.NoiThatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HangMucServiceImpl implements HangMucService {
    HangMucDAO hangMucDAO;
    NoiThatService noiThatService;
    @Autowired
    public HangMucServiceImpl(HangMucDAO hangMucDAO, NoiThatService noiThatService) {
        this.hangMucDAO = hangMucDAO;
        this.noiThatService = noiThatService;
    }
    @Override
    public List<HangMuc> findAll() {
        Iterable<HangMucEntity> hangMucEntities = hangMucDAO.findAll();
        List<HangMucEntity> result = new ArrayList<>();
        hangMucEntities.forEach(result::add);
        return result.stream()
                .map(hangMuc -> new HangMuc(hangMuc, false)).toList();
    }
    @Override
    public HangMuc findUsingId(int id) {
        Optional<HangMucEntity> hangMucEntity =
        return new HangMuc(hangMucDAO.findById(id), false);
    }
    @Override
    public HangMuc findUsingName(String name) {
        return new HangMuc(hangMucDAO.findUsingName(name), false);
    }
    @Override
    public void save(HangMuc hangMuc, int parentId) {
        HangMucEntity hangMucEntity = new HangMucEntity(hangMuc);
        NoiThatEntity noiThatEntity = new NoiThatEntity(noiThatService.findUsingId(parentId));
        hangMucEntity.setNoiThatEntity(noiThatEntity);
        hangMucDAO.save(hangMucEntity);
    }
    @Override
    public void deleteById(int id) {
        hangMucDAO.deleteById(id);
    }
    @Override
    public void update(HangMuc hangMuc) {
        hangMucDAO.update(new HangMucEntity(hangMuc));
    }

    @Override
    public List<HangMuc> joinFetchHangMuc() {
        return hangMucDAO.findAllAndJoinFetch().stream().map(hangMuc -> new HangMuc(hangMuc, true)).toList();
    }

    @Override
    public HangMuc joinFetchHangMucUsingId(int id) {
        return null;
    }

    @Override
    public List<HangMuc> searchByNoiThat(int id) {
        return hangMucDAO.searchByNoiThat(id).stream().map(hangMuc -> new HangMuc(hangMuc, false)).toList();
    }
}
