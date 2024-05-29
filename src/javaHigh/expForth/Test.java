package javaHigh.expForth;

public class Test {
    public static void main(String[] args) {
        Img img1 = new Img();
        img1.readImg("path/to/image1.png");

        Img img2 = img1.unaryOperation(value -> (short) Math.min(value + 100, 255));
        img2.writeImg("path/to/output_image_unary.png");

        Img img3 = new Img();
        img3.readImg("path/to/image2.png");

        Img img4 = img1.binaryOperation(img3, (value1, value2) -> (short) Math.min(value1 + value2, 255));
        img4.writeImg("path/to/output_image_binary.png");
    }
}

