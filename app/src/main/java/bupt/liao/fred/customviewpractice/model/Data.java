package bupt.liao.fred.customviewpractice.model;

/**
 * Created by Fred.Liao on 2017/11/17.
 * Email:fredliaobupt@qq.com
 */

public class Data {
    private String name;
    private float chance;
    private int color;

    public Data(String name, float chance, int color) {
        this.name = name;
        this.chance = chance;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public float getChance() {
        return chance;
    }

    public int getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChance(float chance) {
        this.chance = chance;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
