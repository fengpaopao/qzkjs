package com.qzsq.article.util;


import sun.misc.BASE64Decoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * MyUtil class
 *
 * @author gyh
 * @date 2018/12/6
 */
public class MyUtil {

    /**
     * 把对象转化为字符串
     *
     * @param obj
     * @return java.lang.String
     * @author gyh
     * @date 2018/12/6 下午4:13
     */
    public static String serial( Object obj ) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            String s = baos.toString("iso-8859-1");
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 把字符串转化为Java对象
     *
     * @param data
     * @return
     * @author gyh
     * @date 2018/12/6 下午4:17
     */
    public static Object deserial( String data ) {
        ByteArrayInputStream bais = null;
        try {
            bais = new ByteArrayInputStream(data.getBytes("iso-8859-1"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(bais);
            Object o = ois.readObject();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bais.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 加密
     * 1.构造密钥生成器
     * 2.根据ecnodeRules规则初始化密钥生成器
     * 3.产生密钥
     * 4.创建和初始化密码器
     * 5.内容加密
     * 6.返回字符串
     *
     * @author gyh
     * @param encodeRules
     * @param content
     * @return java.lang.String
     * @date 2018/12/6 下午4:48
     */
    static String encodeRules = "asd";

    public static String AESEncode( String content ) {
        try {
            //1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            //2.根据ecnodeRules规则初始化密钥生成器
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");

            random.setSeed(encodeRules.getBytes());
            //生成一个128位的随机源,根据传入的字节数组
            keygen.init(128, random);
            //3.产生原始对称密钥
            SecretKey original_key = keygen.generateKey();
            //4.获得原始对称密钥的字节数组
            byte[] raw = original_key.getEncoded();
            //5.根据字节数组生成AES密钥
            SecretKey key = new SecretKeySpec(raw, "AES");
            //6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance("AES");
            //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //8.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
            byte[] byte_encode = content.getBytes("utf-8");
            //9.根据密码器的初始化方式--加密：将数据加密
            byte[] byte_AES = cipher.doFinal(byte_encode);
            //10.将加密后的数据转换为字符串
            //这里用Base64Encoder中会找不到包
            //解决办法：
            //在项目的Build path中先移除JRE System Library，再添加库JRE System Library，重新编译后就一切正常了。
            String encode = bytesToHexString(byte_AES);
            String AES_encode = new String(encode);
            //11.将字符串返回
            return AES_encode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //如果有错就返加nulll
        return null;
    }

    /**
     * 解密
     *
     * @param content
     * @return java.lang.String
     * @author gyh
     * @date 2018/12/6 下午4:57
     */
    public static String AESDncode( String content ) {
        try {
            //1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            //2.根据ecnodeRules规则初始化密钥生成器
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(encodeRules.getBytes());
            //生成一个128位的随机源,根据传入的字节数组
            keygen.init(128, random);
            //3.产生原始对称密钥
            SecretKey original_key = keygen.generateKey();
            //4.获得原始对称密钥的字节数组
            byte[] raw = original_key.getEncoded();
            //5.根据字节数组生成AES密钥
            SecretKey key = new SecretKeySpec(raw, "AES");
            //6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance("AES");
            //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.DECRYPT_MODE, key);
            //8.将加密并编码后的内容解码成字节数组
            byte[] byte_content = hexStringToByte(content);
            /*
             * 解密
             */
            byte[] byte_decode = cipher.doFinal(byte_content);
            String AES_decode = new String(byte_decode, "utf-8");
            return AES_decode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }

        //如果有错就返加nulll
        return null;
    }

    /**
     * 把byte数组转成16进制字符串
     *
     * @param bArray
     * @return java.lang.String
     * @author gyh
     * @date 2018/12/6 下午5:16
     */
    public static final String bytesToHexString( byte[] bArray ) {
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2) {
                sb.append(0);
            }
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 把16进制字符串转成byte数组
     *
     * @param hex
     * @return byte[]
     * @author gyh
     * @date 2018/12/6 下午5:18
     */
    public static byte[] hexStringToByte( String hex ) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }

    private static int toByte( char c ) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);
        return b;
    }

    /**
     * 把base64图片数据转为本地图片
     *
     * @param base64ImgData
     * @param filePath
     * @throws IOException
     */
    public static String[] convertBase64DataToImage( String base64ImgData, String filePath ) throws IOException {

        BASE64Decoder decoder = new BASE64Decoder();
        //前台在用Ajax传base64值的时候会把base64中的+换成空格，所以需要替换回来。
        String baseValue = base64ImgData.replaceAll(" ", "+");
        //去除base64中无用的部分

        //去掉base64字符串的开头部分
        String r3 = base64ImgData.substring(base64ImgData.indexOf(",") + 1);
        // 解密
        byte[] b = decoder.decodeBuffer(r3);
        // 处理数据
        for (int i = 0; i < b.length; ++i) {
            if (b[i] < 0) {
                b[i] += 256;
            }
        }

        String s = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "";
        //存放的路径
        String path = Config.config.getProperty("di") + s + "." + filePath;
        File dest = new File(path);
        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        String imagename = s + "." + filePath;
        String[] strings = new String[]{imagename, path};
        //输出流
        OutputStream out = new FileOutputStream(path);
        out.write(b);
        out.flush();
        out.close();

        return strings;


    }
    //删除文件中的某一张图片

    public static boolean delteeImage( String path ) {
        //创建一个文件流指向文件中的图片
        File file = new File("path");
        //删除文件
        boolean delete = file.delete();
        return delete;


    }

    /**
     * @return
     * @Author ffc
     * @Description //TODO 分割字符串
     * @Date 2019/5/16
     * @Param * @param path
     **/
    public static String stringsub( String path ) {
        System.out.println(path + "***************");

        String[] split = path.split("////");

        System.out.println(split[split.length - 2]);
        String[] s = split[split.length - 2].split("_");


        return s[0];
    }

    public static String getJson( String obj ) {
        obj = obj.replace("//", "");
        char[] array = obj.toCharArray();
        char[] charArray = new char[array.length - 2];
        for (int i = 1; i < array.length - 1; i++) {
            charArray[i - 1] = array[i];
        }

        return new String(charArray);
    }
}

