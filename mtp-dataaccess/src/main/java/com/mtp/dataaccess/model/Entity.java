package com.mtp.dataaccess.model;

import com.mtp.dataaccess.model.definition.EntityDefinition;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by morozov.yury on 4.7.15.
 */
public abstract class Entity {

    private String id;

    private EntityDefinition entityDefinition;

    private Map<String, String> attributeValues;

    public Entity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EntityDefinition getEntityDefinition() {
        return entityDefinition;
    }

    public void setEntityDefinition(EntityDefinition entityDefinition) {
        this.entityDefinition = entityDefinition;
    }

    public Map<String, String> getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(Map<String, String> attributeValues) {
        this.attributeValues = attributeValues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(getId(), entity.getId()) &&
                Objects.equals(getEntityDefinition(), entity.getEntityDefinition()) &&
                Objects.equals(getAttributeValues(), entity.getAttributeValues());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEntityDefinition(), getAttributeValues());
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id='" + id + '\'' +
                ", entityDefinition=" + entityDefinition +
                ", attributeValues=" + attributeValues +
                '}';
    }

}
