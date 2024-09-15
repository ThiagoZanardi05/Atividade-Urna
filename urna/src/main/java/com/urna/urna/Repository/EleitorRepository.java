package com.urna.urna.Repository;

import com.urna.urna.Entity.Eleitor;
import com.urna.urna.Entity.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EleitorRepository extends JpaRepository<Eleitor, Long> {
    List<Eleitor> findByStatus(Status status);

}
