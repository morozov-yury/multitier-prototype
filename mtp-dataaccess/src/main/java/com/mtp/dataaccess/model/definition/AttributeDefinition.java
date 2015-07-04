package com.mtp.dataaccess.model.definition;

import java.util.Objects;

/**
 * Created by morozov.yury on 4.7.15.
 */
public class AttributeDefinition {

    private String id;

    private String name;

    private boolean editable;

    private boolean searchable;

    public AttributeDefinition() {

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

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isSearchable() {
        return searchable;
    }

    public void setSearchable(boolean searchable) {
        this.searchable = searchable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributeDefinition that = (AttributeDefinition) o;
        return Objects.equals(isEditable(), that.isEditable()) &&
                Objects.equals(isSearchable(), that.isSearchable()) &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), isEditable(), isSearchable());
    }

    @Override
    public String toString() {
        return "AttributeDefinition{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", editable=" + editable +
                ", searchable=" + searchable +
                '}';
    }
}
