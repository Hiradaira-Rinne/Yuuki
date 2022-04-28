package com.yuuki.config;

import com.yuuki.util.RsaUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author Yuuki
 * @date 2022/4/28 17:16
 */
@Configuration
public class RsaKeyConfig {

    @Value(value = "${rsa.key.privatekey}")
    private String privateKeyPath;

    @Value(value = "${rsa.key.publickey}")
    private String publicKeyPath;

    @Bean
    public PrivateKey getPrivateKey() {
        try {
            return RsaUtils.getPrivateKey(privateKeyPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public PublicKey getPublicKey() {
        try {
            return RsaUtils.getPublicKey(publicKeyPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
