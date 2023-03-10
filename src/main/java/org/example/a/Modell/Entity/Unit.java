package org.example.a.Modell.Entity;

import org.example.a.Graphic.ImageLoader;
import org.example.a.JPanel.GamePanel;
import org.example.a.Modell.Building.Building;
import org.example.a.Modell.Object.Tree;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;

public class Unit {

    private boolean isSelected;
    private GamePanel gamePanel;
    private int worldX, worldY, speed, goalX, goalY, hitPoint, attack, defense, range, maxHitPoint;
    private BufferedImage image;
    private Rectangle solidArea;
    ImageLoader imageLoader = new ImageLoader();
    private String name;

    {
        this.isSelected = false;
        this.worldX = 160;
        this.worldY = 160;
        this.goalX = this.worldX;
        this.goalY = this.worldY;
        this.image = imageLoader.setup("/NHD1", 48, 48);
        this.solidArea = new Rectangle(this.worldX, this.worldY, 48, 48);

        this.name = "Peasant";
        this.range = 0;
        this.attack = 1;
        this.defense = 0;
        this.maxHitPoint = 45;
        this.hitPoint = maxHitPoint;
    }

    public void draw(Graphics2D g2) {
        int screenX = worldX - gamePanel.getPlayer().getScreenX();
        int screenY = worldY - gamePanel.getPlayer().getScreenY();
        g2.drawImage(this.getImage(), screenX, screenY, null);
    }

    public Unit(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setGoals(int x, int y) {
        this.goalX = x;
        this.goalY = y;
    }

    public void moveUnit() {
        if (checkBorder()) {
            if (getWorldX() != this.goalX || getWorldY() != this.goalY) {
                if (getGoalX() < getWorldX()) {
                    setWorldX(getWorldX() - 1);
                    getSolidArea().x = getWorldX();
                }
                if (getGoalX() > getWorldX()) {
                    setWorldX(getWorldX() + 1);
                    getSolidArea().x = getWorldX();
                }
                if (getGoalY() < getWorldY()) {
                    setWorldY(getWorldY() - 1);
                    getSolidArea().y = getWorldY();
                }
                if (getGoalY() > getWorldY()) {
                    setWorldY(getWorldY() + 1);
                    getSolidArea().y = getWorldY();
                }
            }
        }
    }

    private boolean checkBorder() {
        return getGoalX() >= 0 && goalY >= 0;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }


    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public int getWorldX() {
        return worldX;
    }

    public void setWorldX(int worldX) {
        this.worldX = worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public void setWorldY(int worldY) {
        this.worldY = worldY;
    }

    public int getSpeed() {
        return speed;
    }


    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getMaxHitPoint() {
        return maxHitPoint;
    }

    public void setMaxHitPoint(int maxHitPoint) {
        this.maxHitPoint = maxHitPoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getGoalX() {
        return goalX;
    }

    public void setGoalX(Integer goalX) {
        this.goalX = goalX;
    }

    public int getGoalY() {
        return goalY;
    }

    public void setGoalY(Integer goalY) {
        this.goalY = goalY;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Rectangle getSolidArea() {
        return solidArea;
    }

    public void setSolidArea(Rectangle solidArea) {
        this.solidArea = solidArea;
    }
}
