import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class FLAudio extends FLMedia<MediaPlayer> {

	private String fileName;
	private MediaPlayer mediaPlayer;

	public FLAudio(String audioFile, Position position) {
		this.isRendered = false;
		this.fileName = audioFile;
		this.mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(audioFile).toExternalForm()));
		this.position = position;
		this.mediaPlayer.setOnEndOfMedia(() -> this.mediaPlayer.stop());	// Resets audio when finished playing

		//printProperties(this);
	}

	@Override
	//public MediaPlayer getMedia() { return this.mediaPlayer; }
	public MediaPlayer getMedia() { return this.mediaPlayer; }

	public void play() {
		//this.mediaPlayer.stop();	// Resets audio before playing
		this.mediaPlayer.play();
	}

	public String getFileName() { return this.fileName; }

	public void printProperties(FLAudio audio) {
		System.out.println("");
		System.out.println("New FLAudio Created. Listing properties:");
		System.out.println("	File Name: " + audio.getFileName());
		System.out.println("	Position: x = " + audio.position.getX() + ", y = " + audio.position.getY());
	}

}