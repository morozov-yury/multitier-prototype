package mtp.view;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by morozov.yury on 31.5.15.
 */
@CDIView("admin")
public class AdminView extends AbstractView {

    public static String NAME = "admin";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);
        setCompositionRoot(layout);

        layout.addComponent(new Label("Admin view"));
        layout.addComponent(new Button("Go to main page") {{
            addClickListener(new ClickListener() {
                @Override
                public void buttonClick(ClickEvent event) {
                    MtpUI.getCurrent().getNavigator().navigateTo(MainView.NAME);
                }
            });
        }});
    }
}
