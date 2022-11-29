package art.magnet.partner.u201416643.ideas.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class IdeaResource {
    private Long id;
    private String textQuery;
    private Integer initialSamples;
    private Long authorId;
}
