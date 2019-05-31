package net.katrinka.togglator.web;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.util.NamedFeature;

import static net.katrinka.togglator.config.TogglatorFeatures.BUTTONTEXT;

@Route("")
public class MainView extends VerticalLayout {
    private FeatureManager manager;

    public MainView(FeatureManager manager) {
        this.manager = manager;
        String labelText = "Clickez Vous";

        if (manager.isActive(BUTTONTEXT)) {
            labelText = "Drück den Kopf";
        }

        Button button = new Button(labelText, event -> Notification.show("You clicka de button!"));
        add(button);
        // This is a Feature that doesn't exist
        Label dh = new Label("Doo Hickey toggle: " + manager.isActive(new NamedFeature("DOO_HICKEY")));
        add(dh);
    }
}
