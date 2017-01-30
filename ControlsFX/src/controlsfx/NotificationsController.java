package controlsfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 *
 * @author YounusShalaby
 */
public class NotificationsController implements Initializable {

    @FXML
    private void handleButtonAction(ActionEvent event) {
        new ShowNotification().start();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    class ShowNotification extends Thread {

        @Override
        public void run() {

            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, e);
            }

            Image img = new Image("true.png");

            Notifications notification = Notifications.create()
                    .title("This is Sample Notification")
                    .text("this is sample info")
                    .graphic(new ImageView(img)) // OR(1) null
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT)
                    .onAction(new EventHandler<ActionEvent>() {

                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("You Clicked on the Notification !");
                        }
                    });

            notification.darkStyle();
            
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    notification.show(); // OR(1) noti.showInformation();
                }
            });

        }

    }
}
