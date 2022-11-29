package art.magnet.partner.u201416643.ideas.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import art.magnet.partner.u201416643.ideas.domain.model.entity.Idea;
import art.magnet.partner.u201416643.ideas.resource.*;
import art.magnet.partner.u201416643.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class IdeaMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public IdeaResource toResource(Idea model){
        return mapper.map(model, IdeaResource.class);
    }

    public Page<IdeaResource> modelListPage(List<Idea> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, IdeaResource.class), pageable, modelList.size());
    }

    public Idea toModel(CreationIdeaResource resource){
        return mapper.map(resource, Idea.class);
    }

    public Idea toModel(UpdateIdeaResource resource){
        return mapper.map(resource, Idea.class);
    }
}
