package com.example.ooad.utils;

import javax.swing.JComponent;
import javax.swing.JDialog;

import java.awt.*;

public class GridBagAdder {

  private int x;
  private int y;
  private int width;
  private int height;
  private int marginT;
  private int marginR;
  private int marginB;
  private int marginL;
  private int anchor;
  private GridBagConstraints constr;

  public int getX() {
    return this.x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return this.y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getWidth() {
    return this.width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return this.height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getMarginT() {
    return this.marginT;
  }

  public void setMarginT(int marginT) {
    this.marginT = marginT;
  }

  public int getMarginR() {
    return this.marginR;
  }

  public void setMarginR(int marginR) {
    this.marginR = marginR;
  }

  public int getMarginB() {
    return this.marginB;
  }

  public void setMarginB(int marginB) {
    this.marginB = marginB;
  }

  public int getMarginL() {
    return this.marginL;
  }

  public void setMarginL(int marginL) {
    this.marginL = marginL;
  }

  public int getAnchor() {
    return this.anchor;
  }

  public void setAnchor(int anchor) {
    this.anchor = anchor;
  }

  public GridBagConstraints getConstraint() {
    this.constr = new GridBagConstraints();
    constr.gridx = this.x;
    constr.gridx = this.x;
    constr.gridy = this.y;
    constr.gridheight = this.height;
    constr.gridwidth = this.width;
    constr.insets = new Insets(this.marginT, this.marginL, this.marginB, this.marginR);
    constr.anchor = this.anchor;
    return constr;
  }

  public GridBagAdder(GridBagAdderBuilder builder) {
    this.x = builder.x;
    this.y = builder.y;
    this.width = builder.width;
    this.height = builder.height;
    this.marginT = builder.marginT;
    this.marginR = builder.marginR;
    this.marginB = builder.marginB;
    this.marginL = builder.marginL;
    this.anchor = builder.anchor;

  }

  public static class GridBagAdderBuilder {
    private int x = 0;
    private int y = 0;
    private int width = 1;
    private int height = 1;
    private int marginT = 0;
    private int marginR = 0;
    private int marginB = 0;
    private int marginL = 0;
    private int anchor = GridBagConstraints.CENTER;

    public GridBagAdderBuilder setX(int x) {
      this.x = x;
      return this;
    }

    public GridBagAdderBuilder setY(int y) {
      this.y = y;
      return this;
    }

    public GridBagAdderBuilder width(int width) {
      this.width = width;
      return this;
    }

    public GridBagAdderBuilder height(int height) {
      this.height = height;
      return this;
    }

    public GridBagAdderBuilder marginT(int marginT) {
      this.marginT = marginT;
      return this;
    }

    public GridBagAdderBuilder marginR(int marginR) {
      this.marginR = marginR;
      return this;
    }

    public GridBagAdderBuilder marginB(int marginB) {
      this.marginB = marginB;
      return this;
    }

    public GridBagAdderBuilder marginL(int marginL) {
      this.marginL = marginL;
      return this;
    }

    public GridBagAdderBuilder anchor(int anchor) {
      this.anchor = anchor;
      return this;
    }

    public GridBagAdder build() {
      return new GridBagAdder(this);
    }

  }
}
