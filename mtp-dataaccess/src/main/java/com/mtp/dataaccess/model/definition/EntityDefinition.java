package com.mtp.dataaccess.model.definition;

import java.util.Map;
import java.util.Objects;

/**
 * Created by morozov.yury on 4.7.15.
 */
public abstract class EntityDefinition {

    private String id;

    private String name;

    private Map<String, AttributeDefinition> attributeDefinitions;

    public EntityDefinition() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, AttributeDefinition> getAttributeDefinitions() {
        return attributeDefinitions;
    }

    public void setAttributeDefinitions(Map<String, AttributeDefinition> attributeDefinitions) {
        this.attributeDefinitions = attributeDefinitions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityDefinition that = (EntityDefinition) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getAttributeDefinitions(), that.getAttributeDefinitions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAttributeDefinitions());
    }

    @Override
    public String toString() {
        return "EntityDefinition{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", attributeDefinitions=" + attributeDefinitions +
                '}';
    }
}
