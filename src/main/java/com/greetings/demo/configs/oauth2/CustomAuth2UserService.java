package com.greetings.demo.configs.oauth2;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
@Service
public class CustomAuth2UserService extends DefaultOAuth2UserService{

        @Override
        public OAuth2User loadUser(OAuth2UserRequest userRequest) {
            OAuth2User oAuth2User = super.loadUser(userRequest);
            return new CustomerAuth2User(oAuth2User);
        }
    }

