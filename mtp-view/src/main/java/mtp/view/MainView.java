package mtp.view;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import mtp.MtpUI;

/**
 * Created by morozov.yury on 31.5.15.
 */
@CDIView("")
public class MainView extends CustomComponent implements View {

    public static String NAME = "";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);
        setCompositionRoot(layout);

        layout.addComponent(new Label("Admin view"));

        layout.addComponent(new Button("Test button") {{
            addClickListener(new ClickListener() {
                @Override
                public void buttonClick(ClickEvent event) {
                    layout.addComponent(new Label("Click"));
                }
            });
        }});

        layout.addComponent(new Button("Go to admin page") {{
            addClickListener(new ClickListener() {
                @Override
                public void buttonClick(ClickEvent event) {
                    MtpUI.getCurrent().getNavigator().navigateTo(AdminView.NAME);
                }
            });
        }});

    }

}
