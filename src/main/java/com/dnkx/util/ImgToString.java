package com.dnkx.util;

import org.apache.log4j.Logger;
import sun.misc.BASE64Decoder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.imageio.ImageIO;

public class ImgToString {
    private static final Logger logger = Logger.getLogger(ImgToString.class);
    public static void main(String[] args) throws IOException {
    //test
        BufferedImage image_buffer = ImageIO.read(new File("E:\\trans-pro\\UNIONPAYQQ001\\广州琼悦科技有限公司\\3.jpg"));
        String string_image = imgToBase64String(image_buffer);
        System.out.println(string_image);
    }
    public static String imgToBase64String(final RenderedImage img) {
        final ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ImageIO.write(img, "jpg", Base64.getEncoder().wrap(os));
            logger.info("111");
            return os.toString(StandardCharsets.ISO_8859_1.name());
        } catch (final IOException ioe) {
            throw new UncheckedIOException(ioe);
        }
    }



}
