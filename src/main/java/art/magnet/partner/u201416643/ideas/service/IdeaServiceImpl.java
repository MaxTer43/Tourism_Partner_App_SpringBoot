package art.magnet.partner.u201416643.ideas.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import art.magnet.partner.u201416643.ideas.domain.model.entity.Idea;
import art.magnet.partner.u201416643.ideas.domain.persistence.IdeaRepository;
import art.magnet.partner.u201416643.ideas.domain.service.IdeaService;
import art.magnet.partner.u201416643.shared.exception.ResourceNotFoundException;
import art.magnet.partner.u201416643.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class IdeaServiceImpl implements IdeaService {

    private static final String ENTITY = "Idea";

    private final IdeaRepository ideaRepository;

    private final Validator validator;

    public IdeaServiceImpl(IdeaRepository ideaRepository, Validator validator){
        this.ideaRepository = ideaRepository;
        this.validator = validator;
    }

    @Override
    public List<Idea> getAll(){
        return ideaRepository.findAll();
    }

    @Override
    public Page<Idea> getAll(Pageable pageable){
        return ideaRepository.findAll(pageable);
    }

    @Override
    public Idea getById(Long id){
        return ideaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public Idea create(Idea idea){
        Set<ConstraintViolation<Idea>> violations = validator.validate(idea);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return ideaRepository.save(idea);
    }
}
