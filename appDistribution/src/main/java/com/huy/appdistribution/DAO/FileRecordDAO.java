package com.huy.appdistribution.DAO;

import com.huy.appdistribution.Entity.FileRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRecordDAO extends CrudRepository<FileRecord, Integer> {
}
