package mobsoft.hulcsa.com.festivalapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

public class Stage {
    @SerializedName("stageId")
    private String stageId = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("imageUrl")
    private String imageUrl = null;


    /**
     * Unique identifier of a stage.
     **/
    public String getStageId() {
        return stageId;
    }
    public void setStageId(String stageId) {
        this.stageId = stageId;
    }


    /**
     * Display name of stage.
     **/
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Description of stage.
     **/
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Image URL representing the stage.
     **/
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Stage stage = (Stage) o;
        return Objects.equals(stageId, stage.stageId) &&
                Objects.equals(name, stage.name) &&
                Objects.equals(description, stage.description) &&
                Objects.equals(imageUrl, stage.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stageId, name, description, imageUrl);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Stage {\n");

        sb.append("    stageId: ").append(toIndentedString(stageId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
