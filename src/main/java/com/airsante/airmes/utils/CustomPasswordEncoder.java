package com.airsante.airmes.utils;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author jerome.vinet
 * @since 2019.05.28
 */
public class CustomPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        String mdpCrypted = DigestUtils.sha1Hex("VenT@i3$an734-9"+rawPassword.toString());
        return mdpCrypted;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String mdpCrypte = DigestUtils.sha1Hex("VenT@i3$an734-9"+rawPassword);
        return mdpCrypte.equals(encodedPassword);
    }
}