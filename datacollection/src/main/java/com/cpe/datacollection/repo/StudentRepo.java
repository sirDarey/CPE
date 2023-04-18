package com.cpe.datacollection.repo;

import com.cpe.datacollection.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
