package mobsoft.hulcsa.com.festivalapp.model;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

public class Stage {
    private String stageId;
    private String name;
    private String description;
    private String imageUrl;

    public Stage() {}

    public String getStageId() {
        return stageId;
    }

    public void setStageId(String stageId) {
        this.stageId = stageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
