package com.huy.backendnoithat.Service.ThongTinNoiThat.PhongCach;

import com.huy.backendnoithat.DAO.ThongTinNoiThat.PhongCach.PhongCachDAO;
import com.huy.backendnoithat.Entity.BangNoiThat.PhongCachNoiThatEntity;
import com.huy.backendnoithat.DTO.BangNoiThat.PhongCach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PhongCachServiceImpl implements PhongCachService {
    PhongCachDAO phongCachDAO;
    @Autowired
    public void setPhongCachDAO(PhongCachDAO phongCachDAO) {
        this.phongCachDAO = phongCachDAO;
    }
    @Override
    public List<PhongCach> findAll() {
        Iterable<PhongCachNoiThatEntity> phongCachNoiThatEntities = phongCachDAO.findAll();
        List<PhongCachNoiThatEntity> result = new ArrayList<>();
        phongCachNoiThatEntities.forEach(result::add);
        return result.stream()
                .map(phongCachNoiThat -> new PhongCach(phongCachNoiThat, false)).toList();
    }
    @Override
    public PhongCach findById(int id) {
        Optional<PhongCachNoiThatEntity> phongCachNoiThatEntity = phongCachDAO.findById(id);
        if (phongCachNoiThatEntity.isEmpty()) {
            return null;
        }
        return new PhongCach(phongCachNoiThatEntity.get(), false);
    }
    @Override
    public PhongCach findUsingName(String name) {
        return new PhongCach(phongCachDAO.findUsingName(name), false);
    }

    @Override
    public void save(PhongCach phongCachNoiThat) {
        PhongCachNoiThatEntity phongCachNoiThatEntity = new PhongCachNoiThatEntity(phongCachNoiThat);
        phongCachDAO.save(phongCachNoiThatEntity);
    }

    @Override
    public void deleteById(int id) {
        phongCachDAO.deleteById(id);
    }

    @Override
    public void update(PhongCach phongCachNoi) {
        phongCachDAO.update(phongCachNoi.getName(), phongCachNoi.getId());
    }

    @Override
    public List<PhongCach> joinFetchPhongCach() {
        return phongCachDAO.findAllAndJoinFetch().stream()
                .map(phongCachNoiThat -> new PhongCach(phongCachNoiThat, true)).toList();
    }

    @Override
    public PhongCach joinFetchPhongCachUsingId(int id) {
        return new PhongCach(phongCachDAO.findByIdAndJoinFetch(id), true);
    }
}
