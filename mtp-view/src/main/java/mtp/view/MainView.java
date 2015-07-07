package mtp.view;

import com.mtp.service.TestService;
import com.mtp.utils.StringUtils;
import com.mtp.utils.TimeUtils;
import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.*;
import mtp.view.tile.NavigationTile;
import org.apache.logging.log4j.Logger;

import javax.ejb.EJB;
import javax.inject.Inject;

/**
 * Created by morozov.yury on 31.5.15.
 */
@CDIView("")
public class MainView extends AbstractView {

    public static String NAME = "";

    @EJB
    private TestService testService;

    @Inject
    private Logger logger;

    @Inject
    private NavigationTile navigationTile;

    public MainView() {

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        final HorizontalLayout compositionRoot = new HorizontalLayout();
        setCompositionRoot(compositionRoot);
        compositionRoot.setSizeFull();
        compositionRoot.setMargin(true);

        compositionRoot.addComponent(navigationTile);

        compositionRoot.addComponent(new Label("MainView"));

    }

}
