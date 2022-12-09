package api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Entry {

    @Setter(onMethod = @__({@JsonProperty("API")}))
    private String api;
    @Setter(onMethod = @__({@JsonProperty("Description")}))
    private String description;
    @Setter(onMethod = @__({@JsonProperty("Auth")}))
    private String auth;
    @Setter(onMethod = @__({@JsonProperty("HTTPS")}))
    private boolean https;
    @Setter(onMethod = @__({@JsonProperty("Cores")}))
    private String cores;
    @Setter(onMethod = @__({@JsonProperty("Link")}))
    private String link;
    @Setter(onMethod = @__({@JsonProperty("Category")}))
    private String category;

    public String toString() {
        return "Entry: API = " + api + ", Description= " + description + ", Auth= " + auth +
                " , HTTPS= " + https + " ,Cores= " + cores + " , Link= " + link +
                " ,Category= " + category;
    }

}
