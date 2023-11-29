package com.huy.appdistribution.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name = "file_record")
@Getter @Setter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name="file_name")
    String fileName;
    @Column(name="file_type")
    String fileType;
    @Column(name="file_size")
    long fileSize;
    @Column(name="version")
    String version;
}
