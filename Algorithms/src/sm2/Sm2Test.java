package sm2;

import java.io.IOException;

public class Sm2Test {
    public static void main(String[] args){

        Sm2Utils.generateKeyPair();
        String plainText = "zhongshihang";
        byte[] sourceData = plainText.getBytes();
        //以下的秘钥能够使用generateKeyPair()生成的秘钥内容
        // 国密规范正式私钥
        //String prik2 = "3690655E33D5EA3D9A4AE1A1ADD766FDEA045CDEAA43A9206FB8C430CEFE0D94";
        String prik2 = Utils.byteToHex(Sm2Utils.privateKey.toByteArray());
       // String prik2 = Sm2Utils.privateKey.toString();
        // 国密规范正式公钥
        //String pubk2 = "04F6E0C3345AE42B51E06BF50B98834988D54EBC7460FE135A48171BC0629EAE205EEDE253A530608178A98F1E19BB737302813BA39ED3FA3C51639D7A20C7391A";
      //  String pubk2 = Sm2Utils.publicKey.toString();
        String pubk2 = Utils.byteToHex(Sm2Utils.publicKey.getEncoded());
        System.out.println("加密: ");
        String cipherText = null;
        try {
            cipherText = Sm2Utils.encrypt(Utils.hexToByte(pubk2), sourceData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(cipherText);
        System.out.println("解密: ");
        try {
            plainText = new String(Sm2Utils.decrypt(Utils.hexToByte(prik2), Utils.hexToByte(cipherText)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(plainText);
    }
}
