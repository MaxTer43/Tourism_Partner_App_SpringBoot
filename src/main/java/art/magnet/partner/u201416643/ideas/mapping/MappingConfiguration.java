package art.magnet.partner.u201416643.ideas.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("ideaMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public IdeaMapper ideaMapper(){
        return new IdeaMapper();
    }
}
