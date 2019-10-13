package myPack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.net.MalformedURLException;

public class Controller {

    private static File file;
    private MPlayer m ;

    @FXML
    MenuItem open = new MenuItem();
    @FXML
    AnchorPane pContainer =new AnchorPane();

    public void openFile() throws MalformedURLException {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Video files (*.mp4)", "*.mp4"),new FileChooser.ExtensionFilter("Audio files (*.mp3)", "*.mp3"));
            file = fileChooser.showOpenDialog(new Stage());
            m.getMediaPlayer().stop();
            m = new MPlayer(file,pContainer);
        }catch (NullPointerException | MalformedURLException e){
            m = new MPlayer(file,pContainer);
        }
    }
    @FXML
    AnchorPane FullAnchor = new AnchorPane();
    public void screen(MouseEvent e){
        if(e.getClickCount() == 2) {
            MediaView fullm = m.getMv();
            fullm.setPreserveRatio(false);
            fullm.fitWidthProperty().bind(FullAnchor.widthProperty());
            fullm.fitHeightProperty().bind(FullAnchor.heightProperty());
            FullAnchor.getChildren().add(fullm);
            Main.pstage.setScene(new Scene(FullAnchor));
            Main.pstage.setFullScreen(true);
        }
    }



}
