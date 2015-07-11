package mtp.view.service;

import com.mtp.service.AccessService;
import com.vaadin.ui.UI;
import mtp.view.MtpUI;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yury_Morozov on 07.07.2015.
 */
@ApplicationScoped
public class NavigationService implements Serializable {

    @EJB
    private AccessService accessService;

    public Map<String, String> getNavigationRefs() {
        return new HashMap<String, String>() {{
            for (String entityTypeName : accessService.getAvailableAntitityTypes()) {
                put(entityTypeName, "list/" + entityTypeName);
            }
        }};
    }

    public String getMainPageRef() {
        return "";
    }

    public void navigateTo (String ref) {
        UI ui = MtpUI.getCurrent();
        if (ui != null) {
            ui.getNavigator().navigateTo(ref);
        } else {
//            throw new
        }
    }

}
