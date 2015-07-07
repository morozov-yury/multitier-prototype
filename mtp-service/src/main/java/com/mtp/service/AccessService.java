package com.mtp.service;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yury_Morozov on 07.07.2015.
 */
@Stateless
public class AccessService {

    public List<String> getAvailableAntitityTypes() {
        return new ArrayList<String>() {{
            add("EntityType1");
            add("EntityType2");
            add("EntityType3");
            add("EntityType4");
            add("EntityType5");
            add("EntityType6");
        }};
    }

}
