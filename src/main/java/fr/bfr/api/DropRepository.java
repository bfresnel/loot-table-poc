package fr.bfr.api;

import fr.bfr.model.DropChance;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DropRepository extends Repository<DropChance, Integer> {

    List<DropChance> findAll();
}
