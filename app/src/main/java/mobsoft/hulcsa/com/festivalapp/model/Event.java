package mobsoft.hulcsa.com.festivalapp.model;

import com.orm.dsl.Table;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Created by mobsoft on 2017. 03. 20..
 */

@Table
public class Event   {

    @SerializedName("eventId")
    private String eventId = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("genre")
    private String genre = null;

    @SerializedName("imageUrl")
    private String imageUrl = null;

    @SerializedName("day")
    private Integer day = null;

    @SerializedName("startTime")
    private Integer startTime = null;

    @SerializedName("endTime")
    private Integer endTime = null;

    @SerializedName("stageId")
    private String stageId = null;



    /**
     * Unique identifier of an event.
     **/
    public String getEventId() {
        return eventId;
    }
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }


    /**
     * Display name of event.
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
     * Genre of event.
     **/
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
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


    /**
     * Day of event.
     **/
    public Integer getDay() {
        return day;
    }
    public void setDay(Integer day) {
        this.day = day;
    }


    /**
     * Start time of event.
     **/
    public Integer getStartTime() {
        return startTime;
    }
    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }


    /**
     * End time of event.
     **/
    public Integer getEndTime() {
        return endTime;
    }
    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }


    /**
     * Unique identifier of the stage of the event.
     **/
    public String getStageId() {
        return stageId;
    }
    public void setStageId(String stageId) {
        this.stageId = stageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Event event = (Event) o;
        return Objects.equals(eventId, event.eventId) &&
                Objects.equals(name, event.name) &&
                Objects.equals(description, event.description) &&
                Objects.equals(genre, event.genre) &&
                Objects.equals(imageUrl, event.imageUrl) &&
                Objects.equals(day, event.day) &&
                Objects.equals(startTime, event.startTime) &&
                Objects.equals(endTime, event.endTime) &&
                Objects.equals(stageId, event.stageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, name, description, genre, imageUrl, day, startTime, endTime, stageId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Event {\n");

        sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    genre: ").append(toIndentedString(genre)).append("\n");
        sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
        sb.append("    day: ").append(toIndentedString(day)).append("\n");
        sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
        sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
        sb.append("    stageId: ").append(toIndentedString(stageId)).append("\n");
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
