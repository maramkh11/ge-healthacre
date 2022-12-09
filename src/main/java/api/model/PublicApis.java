package api.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PublicApis {

    private int count;
    private List<Entry> entries;

    @Override
    public String toString() {
        return "count = " + count;
    }

}
