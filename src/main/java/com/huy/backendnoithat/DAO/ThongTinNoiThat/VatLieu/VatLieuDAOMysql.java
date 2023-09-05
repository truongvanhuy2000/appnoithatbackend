package com.huy.backendnoithat.DAO.ThongTinNoiThat.VatLieu;

import com.huy.backendnoithat.Entity.BangNoiThat.VatLieuEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository("vatLieuDAOMysql")
public class VatLieuDAOMysql implements VatLieuDAO {
    EntityManager entityManager;
    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<VatLieuEntity> findAll() {
        TypedQuery<VatLieuEntity> query = entityManager.createQuery("from VatLieuEntity vl join fetch vl.thongSoEntity order by vl.id", VatLieuEntity.class);
        return query.getResultList();
    }
    @Override
    public VatLieuEntity findById(int id) {
        return entityManager.find(VatLieuEntity.class, id);
    }
    @Override
    public VatLieuEntity findUsingName(String name) {
        TypedQuery<VatLieuEntity> query = entityManager.createQuery("from VatLieuEntity where name = :name", VatLieuEntity.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
    @Override
    @Transactional
    public void save(VatLieuEntity vatLieuEntity) {
        entityManager.persist(vatLieuEntity);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        VatLieuEntity vatLieuEntity = entityManager.find(VatLieuEntity.class, id);
        entityManager.remove(vatLieuEntity);
    }
    @Override
    @Transactional
    public void update(VatLieuEntity vatLieuEntity) {
        TypedQuery<VatLieuEntity> query = entityManager.createQuery(
                "update VatLieuEntity set name = :name where id = :id",
                VatLieuEntity.class);
        query.setParameter("name", vatLieuEntity.getName());
        query.setParameter("id", vatLieuEntity.getId());
        query.executeUpdate();
    }
    @Override
    public List<VatLieuEntity> findAllAndJoinFetch() {
        TypedQuery<VatLieuEntity> query = entityManager.createQuery(
                "FROM VatLieuEntity vl " +
                        "JOIN FETCH vl.thongSoEntity ts "
                , VatLieuEntity.class);
        return query.getResultList();
    }
    @Override
    public VatLieuEntity findByIdAndJoinFetch(int id) {
        return null;
    }
    @Override
    public List<VatLieuEntity> searchByHangMuc(int id) {
        TypedQuery<VatLieuEntity> query = entityManager.createQuery("from VatLieuEntity vl where vl.hangMucEntity.id = :id order by vl.id", VatLieuEntity.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
}
