package art.magnet.partner.u201416643.ideas.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import art.magnet.partner.u201416643.ideas.domain.model.entity.Idea;

import java.util.List;

public interface IdeaService {

    List<Idea> getAll();

    Page<Idea> getAll(Pageable pageable);

    Idea getById(Long IdeaId);

    Idea create(Idea idea);
}
