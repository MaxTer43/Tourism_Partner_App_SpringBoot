package art.magnet.partner.u201416643.ideas.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import art.magnet.partner.u201416643.ideas.domain.model.entity.Idea;

import java.util.List;

public interface IdeaRepository extends JpaRepository<Idea, Long>{
    @Override
    List<Idea> findAll();
}
