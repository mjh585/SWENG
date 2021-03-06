import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class PWSImage extends PWSMedia<ImageView>{

    private ImageView imageView;

    private String fileName;

    @Override
    public ImageView getPwsMedia() { return this.imageView; }

    public PWSImage(String id, PWSPosition pwsPosition, PWSTransitions pwsTransitions, String path) {
        this.setId(id);
        this.setPwsPosition(pwsPosition);
        this.setPwsTransitions(pwsTransitions);
        this.fileName = path;
        this.imageView = new ImageView(new Image(this.getClass().getResource(path).toExternalForm()));
        this.imageView.setX(this.getPwsPosition().getX());
        this.imageView.setY(this.getPwsPosition().getY());
        this.imageView.setFitWidth(this.getPwsPosition().getWidth());
        this.imageView.setFitHeight(this.getPwsPosition().getHeight());
        this.setTransition(pwsTransitions);
    }

    public void setTransition(PWSTransitions pwsTransitions) {
        Timeline timeline = new Timeline();
        if(pwsTransitions.isTriggered()) {
            timeline.getKeyFrames().add(new KeyFrame(Duration.ZERO, "auto", (ActionEvent event) -> {
                this.getPwsMedia().setVisible(false);
                this.getTimeline().stop();
            }));
        }
        else {
            timeline.getKeyFrames().add(new KeyFrame(Duration.ZERO, "auto", (ActionEvent event) -> {
                this.getPwsMedia().setVisible(false);
            }));
        }
        timeline.getKeyFrames().add(new KeyFrame(this.getPwsTransitions().getStart(), "trigger", (ActionEvent event) -> {
            this.getPwsMedia().setVisible(true);
        }));
        if(this.getPwsTransitions().getPwsDuration() >= 0) {
            timeline.getKeyFrames().add(new KeyFrame(this.getPwsTransitions().getDuration(), "trigger", (ActionEvent event) -> {
                this.getPwsMedia().setVisible(false);
            }));
        }
        this.setTimeline(timeline);
    }

    @Override
    public String toString() {
        return "PWSImage:\nid = " + this.getId() + "\nfileName = " + this.fileName + "\n" + this.getPwsPosition();
    }

    public void setImage(String imagePath) {
        this.imageView.setImage(new Image(imagePath));
    }
}
