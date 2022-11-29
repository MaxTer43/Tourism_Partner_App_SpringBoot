package art.magnet.partner.u201416643.ideas.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import art.magnet.partner.u201416643.ideas.domain.service.IdeaService;
import art.magnet.partner.u201416643.ideas.mapping.IdeaMapper;
import art.magnet.partner.u201416643.ideas.resource.CreationIdeaResource;
import art.magnet.partner.u201416643.ideas.resource.IdeaResource;

@Tag(name = "Idea", description = "Painting")
@RestController
@RequestMapping(value = "api/v1/ideas")
public class IdeaController {

    private final IdeaService service;
    private final IdeaMapper mapper;

    public IdeaController(IdeaService service, IdeaMapper mapper){
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping
    public Page<IdeaResource> getAllIdeas(Pageable pageable){
        return mapper.modelListPage(service.getAll(), pageable);
    }

    @GetMapping("{ideaId}")
    public IdeaResource getIdeaById(@PathVariable("ideaId") Long ideaId){
        return mapper.toResource(service.getById(ideaId));
    }

    @PostMapping
    public ResponseEntity<IdeaResource> createIdea(CreationIdeaResource resource){
        return new ResponseEntity<>(mapper.toResource(service.create(
                mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
