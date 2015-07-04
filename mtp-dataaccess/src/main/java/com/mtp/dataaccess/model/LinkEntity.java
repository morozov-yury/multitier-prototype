package com.mtp.dataaccess.model;

import java.util.Objects;

/**
 * Created by morozov.yury on 4.7.15.
 */
public class LinkEntity extends Entity {

    private DataEntity left;

    private DataEntity right;

    public LinkEntity() {
    }

    public DataEntity getLeft() {
        return left;
    }

    public void setLeft(DataEntity left) {
        this.left = left;
    }

    public DataEntity getRight() {
        return right;
    }

    public void setRight(DataEntity right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkEntity that = (LinkEntity) o;
        return Objects.equals(getLeft(), that.getLeft()) &&
                Objects.equals(getRight(), that.getRight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLeft(), getRight());
    }

    @Override
    public String toString() {
        return "LinkEntity{" +
                "left=" + left +
                ", right=" + right +
                "} " + super.toString();
    }
}
