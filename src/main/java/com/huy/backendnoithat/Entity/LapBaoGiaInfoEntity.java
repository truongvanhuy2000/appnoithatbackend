package com.huy.backendnoithat.Entity;

import com.huy.backendnoithat.Entity.Account.AccountEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lap_bao_gia_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LapBaoGiaInfoEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="ten_cong_ty")
    private String tenCongTy;
    @Column(name="dia_chi_van_phong")
    private String diaChiVanPhong;
    @Column(name="so_dien_thoai")
    private String soDienThoai;
    @Column(name= "dia_chi_xuong")
    private String diaChiXuong;
    @Column(name="email")
    private String email;
    @Column(name="logo")
    private String logoPath;
    @Column(name="note", length = 1000)
    private String note;
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private AccountEntity account;
}
