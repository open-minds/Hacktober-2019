package myPack;

import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.io.File;
import java.net.MalformedURLException;

class MPlayer {
    private MediaPlayer mediaPlayer ;
    private  MediaView mv;
    MPlayer(File file, AnchorPane pContainer) throws MalformedURLException {try{
        Media media = new Media(file.toURI().toURL().toExternalForm());
        mediaPlayer = new MediaPlayer(media);
         mv = new MediaView(mediaPlayer);
        mv.setPreserveRatio(false);
        mv.fitWidthProperty().bind(pContainer.widthProperty());
        mv.fitHeightProperty().bind(pContainer.heightProperty());
        pContainer.getChildren().removeAll();
        pContainer.getChildren().add(mv);
        mediaPlayer.setAutoPlay(true);}catch(NullPointerException ignored){}

    }

    public MediaView getMv() {
        return mv;
    }

    MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
}
