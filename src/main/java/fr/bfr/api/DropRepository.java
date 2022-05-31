package fr.bfr.api;

import fr.bfr.model.DropChance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DropRepository extends JpaRepository<DropChance, Integer> {

    @NonNull
    List<DropChance> findAll();
}
