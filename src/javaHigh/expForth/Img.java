package javaHigh.expForth;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Img {
    public enum IMG_STORE_TYPE {GRAY, GRAY_A, RGB, RGB_A;}

    private IMG_STORE_TYPE storeType;
    private short[] pixelData;
    private int width;
    private int height;

    public Img() {
    }

    // 从参数file指定的路径读取图像⽂件，有合理的函数体即可
    public void readImg(String file) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.width = img.getWidth();
        this.height = img.getHeight();
    }

    //将图像数据写出到参数file指定的路径，有合理的函数体即可
    public void writeImg(String file) {
        try {
            BufferedImage img = null;
            ImageIO.write(img, "png", new File(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 执行一元操作
    public Img unaryOperation(UnaryOperation unaryOp) {
        Img result = new Img();
        result.width = this.width;
        result.height = this.height;
        result.storeType = this.storeType;
        result.pixelData = new short[this.pixelData.length];
        for (int i = 0; i < this.pixelData.length; i++) {
            result.pixelData[i] = unaryOp.apply(this.pixelData[i]);
        }
        return result;
    }

    // 执行二元操作
    public Img binaryOperation(Img img, BinaryOperation binaryOp) {
        if (this.width != img.width || this.height != img.height || this.storeType != img.storeType) {
            throw new IllegalArgumentException("Images must have the same dimensions and storage type.");
        }
        Img result = new Img();
        result.width = this.width;
        result.height = this.height;
        result.storeType = this.storeType;
        result.pixelData = new short[this.pixelData.length];
        for (int i = 0; i < this.pixelData.length; i++) {
            result.pixelData[i] = binaryOp.apply(this.pixelData[i], img.pixelData[i]);
        }
        return result;
    }
}
