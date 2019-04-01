package com.ivy.root.common.util;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;


/**
* @Description:    java类作用描述
* @Author:         matao
* @CreateDate:     2019/3/11 14:50

* @UpdateUser:     matao
* @UpdateDate:     2019/3/11 14:50
* @UpdateRemark:   修改内容

* @Version:        1.0
*/

public class CodeUtils {
    //敏感值 用于对jwt HA256加密
    private final static String SECRET = "jklf-=ertjerk.,sdf";
    private static final Base64 BASE_64 = new Base64();

    /**
     * 盐值加密
     *
     * @param password
     * @param salt
     * @return
     */
    public static String getSaltPassword(String password, String salt) {
        password = getSHA256Str(password);
        password = password + salt;
        password = getSHA256Str(password);
        return password;
    }

    /**s
     * 编码base64
     *
     * @param str
     * @return
     */
    public static String encodeBase64(String str) {
        return BASE_64.encodeToString(str.getBytes());
    }

    /**
     * 解码base64
     *
     * @param str
     * @return
     */
    public static String decodeBase64(String str) {
        return new String(BASE_64.decode(str.getBytes()));
    }

    /**
     * 获取盐值
     *
     * @return
     */
    public static String getSalt() {
        return System.currentTimeMillis() + "";
    }

    /**
     * 获取SHA256加密字符串
     *
     * @param str
     * @return
     */
    public static String getSHA256Str(String str) {
        MessageDigest messageDigest;
        String encdeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(str.getBytes("UTF-8"));
            encdeStr = Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encdeStr;
    }

    /**
     * 检验用户登录
     *
     * @param password
     * @param salt
     * @param encodedPassword
     * @return
     */
    public static boolean checkUser(String password, String salt, String encodedPassword) {
        if (StringUtils.isEmpty(password) || StringUtils.isEmpty(salt) || StringUtils.isEmpty(encodedPassword)) {
            return false;
        }
        String saltPassword = getSaltPassword(password, salt);
        if (saltPassword.equals(encodedPassword)) {
            return true;
        }
        return false;
    }

    //JWT
    public static String getJwtString() {
        return null;
    }

    //用于装载 jwt 信息的载体
    public static class JwtBean {
        private Map<String, Object> headMap = new HashMap<String, Object>();
        private Map<String, Object> playloadMap = new HashMap<String, Object>();
        private static Gson gson = new GsonBuilder().create();
        private static JsonParser jsonParser = new JsonParser();

        public JwtBean() {
        }

        /**
         * 通过jwt串 解码后获取JwtBean
         * 若非合法jwt 将返回null
         *
         * @param jwt
         * @return
         */
        public static JwtBean getJwtBean(String jwt) {
            if (jwt == null) {
                return null;
            }
            String[] jwts = jwt.split("\\.");
            if (jwts.length != 3) {
                return null;
            }
//验证
            String signature = getSHA256Str(jwts[0] + "." + jwts[1] + SECRET);
            if (!jwts[2].equals(signature)) {
                return null;
            }
//验证成功 构建jwtBean
            JwtBean jwtBean = null;
            try {
                JsonElement headElement = jsonParser.parse(decodeBase64(jwts[0]));
                JsonElement payloadElement = jsonParser.parse(decodeBase64(jwts[1]));
                jwtBean = new JwtBean();
                jwtBean.setHeadMap(JsonUtils.jsonToMap(decodeBase64(jwts[0])));
                jwtBean.setPlayloadMap(JsonUtils.jsonToMap(decodeBase64(jwts[1])));
            } catch (Exception e) {
                return null;
            }
            return jwtBean;
        }

        public void addHead(String key, Object value) {
            headMap.put(key, value);
        }

        public void addPlayload(String key, Object value) {
            playloadMap.put(key, value);
        }

        public Map<String, Object> getHeadMap() {
            return headMap;
        }

        public Map<String, Object> getPlayloadMap() {
            return playloadMap;
        }

        public Object getHead(String key) {
            return headMap.get(key);
        }

        public Object getPlayload(String key) {
            return playloadMap.get(key);
        }

        public String getHeadJson() {
            return gson.toJson(headMap);
        }

        public String getPlayloadJson() {
            return gson.toJson(playloadMap);
        }

        public JwtBean setHeadMap(Map<String, Object> headMap) {
            this.headMap = headMap;
            return this;
        }

        public JwtBean setPlayloadMap(Map<String, Object> playloadMap) {
            this.playloadMap = playloadMap;
            return this;
        }

        @Override
        public String toString() {
            String jwt = null;
            String headJson = gson.toJson(headMap);
            String playload = gson.toJson(playloadMap);
//base64
            headJson = encodeBase64(headJson);
            playload = encodeBase64(playload);
            jwt = headJson + "." + playload;
            jwt = jwt + "." + getSHA256Str(jwt + SECRET);
            return jwt;
        }
    }

}